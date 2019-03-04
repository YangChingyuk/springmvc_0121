package com.yqx.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yqx.entity.User;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String Hello() {
		System.out.println("Hello World!");
		return "hello";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/hello2")
	public String Hello2(String username,String password,String name) {
		System.out.println("获取前台传过来的参数:" + username);
		System.out.println("获取前台传过来的参数:" + password);
		System.out.println("获取前台传过来的参数:" + name);
		return "hello";
	}
	@RequestMapping("/hello3")
	public String Hello3(User user,Map<String,Object> map) {//多个参数可以通过对象封装
		System.out.println("获取前台传过来的参数:" + user.getUsername());
		System.out.println("获取前台传过来的参数:" + user.getPassword());
		System.out.println("获取前台传过来的参数:" + user.getName());
		//后台传递值到前台页面
		map.put("user", user);
		return "hello";
	}
	@RequestMapping("/hello4")
	public String Hello4(User user,Map<String,Object> map) {//多个参数可以通过对象封装
		System.out.println("获取前台传过来的参数:" + user.getUsername());
		System.out.println("获取前台传过来的参数:" + user.getPassword());
		System.out.println("获取前台传过来的参数:" + user.getName());
		//后台传递值到前台页面
		map.put("user", user);
		//重定向到另一个请求地址,值无法传递到页面
		return "redirect:hello";
	}
	@RequestMapping("/hello5")
	public String Hello5(User user,Map<String,Object> map) {//多个参数可以通过对象封装
		System.out.println("获取前台传过来的参数:" + user.getUsername());
		System.out.println("获取前台传过来的参数:" + user.getPassword());
		System.out.println("获取前台传过来的参数:" + user.getName());
		//后台传递值到前台页面
		map.put("user", user);
		//重定向到jsp页面,值无法传递到页面
		return "redirect:hello.jsp";
	}
	@RequestMapping("/hello6")
	public String Hello6(User user,Map<String,Object> map) {//多个参数可以通过对象封装
		System.out.println("获取前台传过来的参数:" + user.getUsername());
		System.out.println("获取前台传过来的参数:" + user.getPassword());
		System.out.println("获取前台传过来的参数:" + user.getName());
		//后台传递值到前台页面
		map.put("user", user);
		//请求转发到另一个请求,可以传递值
		return "forward:hello";
	}
}
