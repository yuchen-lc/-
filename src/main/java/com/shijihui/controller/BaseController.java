package com.shijihui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:/index";
    }

	/**
	 * 首页
	 */
	@RequestMapping({"/index",""})
	public String index(Model model){
        log.info("index");
        model.addAttribute("username", "jiangzhiyong");
		return "index";
	}

    /**
     * 首页
     */
    @RequestMapping("/welcome")
    public String welcome(){
        log.info("welcome");
        return "welcome";
    }

    /**
     * 心跳
     */
    @RequestMapping("/status")
    public String status(){
        return "";
    }

    /**
     * 404
     */
    @RequestMapping("*")
    public String _404(){
        return "404";
    }
	
}
