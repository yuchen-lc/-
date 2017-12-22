package com.shijihui.controller;

import com.shijihui.entity.CasInfo;
import com.shijihui.query.CasInfoQuery;
import com.shijihui.service.CasInfoService;
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
@RequestMapping("/cas")
public class CasController {

    private static final Logger log = LoggerFactory.getLogger(CasController.class);

    @Resource
    private CasInfoService casInfoService;

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/detail")
    @ResponseBody
	public Object detail(int id){
        CasInfo casInfo = casInfoService.selectById(id);
		return new WebRetureVo<CasInfo>(casInfo);
	}

    /**
     * 查询
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Object query(CasInfoQuery query){
        log.info("query = " + query);
        Integer total = casInfoService.countByQuery(query);
        List<CasInfo> productInfoList = casInfoService.selectByQuery(query);
        return new WebRetureVo<DataPageVo>(new DataPageVo<CasInfo>(productInfoList, query.getCurPage(), query.getPageSize(), total));
    }
	
}
