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
		System.out.println("��ȡǰ̨�������Ĳ���:" + username);
		System.out.println("��ȡǰ̨�������Ĳ���:" + password);
		System.out.println("��ȡǰ̨�������Ĳ���:" + name);
		return "hello";
	}
	@RequestMapping("/hello3")
	public String Hello3(User user,Map<String,Object> map) {//�����������ͨ�������װ
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getUsername());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getPassword());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getName());
		//��̨����ֵ��ǰ̨ҳ��
		map.put("user", user);
		return "hello";
	}
	@RequestMapping("/hello4")
	public String Hello4(User user,Map<String,Object> map) {//�����������ͨ�������װ
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getUsername());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getPassword());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getName());
		//��̨����ֵ��ǰ̨ҳ��
		map.put("user", user);
		//�ض�����һ�������ַ,ֵ�޷����ݵ�ҳ��
		return "redirect:hello";
	}
	@RequestMapping("/hello5")
	public String Hello5(User user,Map<String,Object> map) {//�����������ͨ�������װ
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getUsername());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getPassword());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getName());
		//��̨����ֵ��ǰ̨ҳ��
		map.put("user", user);
		//�ض���jspҳ��,ֵ�޷����ݵ�ҳ��
		return "redirect:hello.jsp";
	}
	@RequestMapping("/hello6")
	public String Hello6(User user,Map<String,Object> map) {//�����������ͨ�������װ
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getUsername());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getPassword());
		System.out.println("��ȡǰ̨�������Ĳ���:" + user.getName());
		//��̨����ֵ��ǰ̨ҳ��
		map.put("user", user);
		//����ת������һ������,���Դ���ֵ
		return "forward:hello";
	}
}
