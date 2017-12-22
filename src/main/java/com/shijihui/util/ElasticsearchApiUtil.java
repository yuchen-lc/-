package com.shijihui.util;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangzhiyong on 16/5/8.
 */
public class ElasticsearchApiUtil {


    private static final String ADDRESS_IP = "139.196.90.109";
    private static final int ADDRESS_PORT = 9300;

    private static final Settings settings;
    private static final Client client;

    static {
        /**
         * es_home/config/elasticsearch.yml 文件中有cluster.name 和 node.name
         */
//        settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true).put("cluster.name", "elasticsearch").build();
        settings = ImmutableSettings.settingsBuilder().build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ADDRESS_IP, ADDRESS_PORT));
    }


    /**
     * 创建索引
     * @param t
     */
    public static <T> void index(String index, String type, T t) {
        String jsonValue = JSONObject.toJSONString(t);
        client.prepareIndex(index, type).setSource(jsonValue).execute().actionGet();
    }

    /**
     * 删除索引
     * @param id
     */
    public static void delete(String index, String type, String id) {
        //删除方法一
        DeleteRequest request = new DeleteRequest();
        request.index(index);
        request.type(type);
        request.id(id);
        client.delete(request);

        //删除方法二
//        client.prepareDelete().setIndex("chemical").setType("info").execute().actionGet();

        //删除方法三
//        ClusterStateResponse response = client.admin().cluster()
//                .prepareState()
//                .execute().actionGet();
//        //获取所有索引
//        String[] indexs=response.getState().getMetaData().getConcreteAllIndices();
//        for (String index : indexs) {
//            System.out.println(index);
//            client.admin().indices().prepareDelete(index).execute().actionGet();
//        }

        //删除方法四
//        QueryBuilder builder = QueryBuilders.idsQuery("info").queryName("id").toXContent();
//        client.prepareDeleteByQuery(indexEnum.getIndex()).setQuery(builder).execute().actionGet();
    }

    public static List<Integer> search(String index, String type, Map<String, Object> map) {
        List<Integer> list = new ArrayList<Integer>();
        if (map == null) {
            return list;
        }
        SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type);
        builder.setQuery(QueryBuilders.termQuery("id", "00"));
//        builder.setPostFilter(map);
        SearchResponse response = builder.setSize(100).setExplain(true).execute().actionGet(500);
        for (SearchHit hit : response.getHits()) {
            Integer id = (Integer)hit.getSource().get("id");
            String name = (String)hit.getSource().get("name");
            System.out.println(id);
            System.out.println(name);
            list.add(id);
        }
        return list;
    }

    public static void main(String[] args) {
//        ProductDTO productDTO1 = new ProductDTO();
//        productDTO1.setId(100);
//        productDTO1.setCas("75867-40-2");
//        productDTO1.setCName("4-[(三甲基硅基)乙炔基]苄腈");
//        productDTO1.setEName("4-TRIMETHYLSILYLETHYNYLBENZONITRILE");
//        ElasticsearchApiUtil.index("product_baseinfo", "product", productDTO1);
//
//        ProductDTO productDTO2 = new ProductDTO();
//        productDTO2.setId(200);
//        productDTO2.setCas("64024-63-1");
//        productDTO2.setCName("4-[(三甲基甲硅烷基)乙炔基]吗啉");
//        productDTO2.setEName("4-((TRIMETHYLSILYL)ETHYNYL)MORPHOLINE");
//        ElasticsearchApiUtil.index("product_baseinfo", "product", productDTO2);

        int a = 10;
        int b = 10;
        method(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

//
//        ProductDTO productDTO3 = new ProductDTO();
//        productDTO3.setId(300);
//        productDTO3.setCas("64024-63-1");
//        productDTO3.setCName("4-甲醛");
//        productDTO3.setEName("4-JIAQUAN");
//        ElasticsearchApiUtil.index("product_baseinfo", "product", productDTO3);
    }

    static void method(int a, int b) {
        a = 200;
        b = 100;
    }
}
