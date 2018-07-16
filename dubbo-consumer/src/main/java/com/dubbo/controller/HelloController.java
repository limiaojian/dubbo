package com.dubbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/say",method=RequestMethod.GET)
	@ResponseBody
	public String say(String name){
		return helloService.say(name);
	}
}
