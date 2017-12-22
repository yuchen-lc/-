package com.shijihui.controller;

import com.shijihui.entity.ProductInfo;
import com.shijihui.query.ProductInfoQuery;
import com.shijihui.service.ProductInfoService;
import com.shijihui.vo.DataPageVo;
import com.shijihui.vo.WebRetureVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductInfoService productInfoService;

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/detail")
    @ResponseBody
	public Object detail(int id){
        ProductInfo product = productInfoService.selectById(id);
		return new WebRetureVo<ProductInfo>(product);
	}

    /**
     * 查询
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Object query(ProductInfoQuery query){
        log.info("query = " + query);
        Integer total = productInfoService.countByQuery(query);
        List<ProductInfo> productInfoList = productInfoService.selectByQuery(query);
        return new WebRetureVo<DataPageVo>(new DataPageVo<ProductInfo>(productInfoList, query.getCurPage(), query.getPageSize(), total));
    }
	
}
