package com.shijihui.controller;

import com.shijihui.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

	/**
	 * 查询所有用户
	 * @return list<user>
	 */
	@RequestMapping("/all")
	public String all(Model model){
        log.info("select all user");
        model.addAttribute("users", userService.selectAll());
		return "index";
	}
	
}
