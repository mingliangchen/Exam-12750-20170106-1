package com.hand.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.service.CustomerService;




@Controller
@RequestMapping("/hand")
public class CustomerController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String login(@RequestParam(value = "first_name", required = false, defaultValue = "") String first_name){
	    System.out.println(first_name);
		if(first_name==null){
		    String data="用户名为空，请输入";
			return data;
		}
		Boolean f=customerService.login(first_name);
		if (f) {
		    String  data="success";
			return data;
		}
		String data="用户名不存在";
		return data;  //WEB-INF/jsp/list.jsp    look at spring-web.xml			
	}
	
}
