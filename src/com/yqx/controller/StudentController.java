package com.yqx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yqx.dao.StudentDao;
import com.yqx.daoImpl.StudentDaoImpl;
import com.yqx.entity.Student;
import com.yqx.util.Pager;

@Controller
public class StudentController {
	
	@RequestMapping("/add")
	public String add(Student s) {
		StudentDao dao = new StudentDaoImpl();
		dao.add(s);
		return "forward:/queryByPage";
	}
	@RequestMapping("/deleteById")
	public String deleteById(int id) {
		StudentDao dao = new StudentDaoImpl();
		dao.deleteById(id);
		return "forward:/queryByPage";
	}
	@RequestMapping("/deleteMore")
	public String deleteMore(String ids) {
		StudentDao dao = new StudentDaoImpl();
		dao.deleteMore(ids);
		return "forward:/queryByPage";
	}
	@RequestMapping("/update")
	public String update(Student s) {
		StudentDao dao = new StudentDaoImpl();
		dao.update(s);
		return "forward:/queryByPage";
	}
	@RequestMapping("/queryById")
	public String queryById(HttpServletRequest request,int id,String currentPage,Map<String,Object> map) {
		
		String qname = request.getParameter("qname");
		String qusername = request.getParameter("qusername");
		String qsex = request.getParameter("qsex");
		
		StudentDao dao = new StudentDaoImpl();
		Student s = dao.queryById(id);
		map.put("student", s);
		map.put("currentPage", currentPage);
		map.put("qname", qname);
		map.put("qusername", qusername);
		map.put("qsex", qsex);
		
		return "update";
	}
	@RequestMapping("/queryByPage")
	public String queryByPage(HttpServletRequest request,String currentPage,Map<String,Object> map) {
		
		String qname = request.getParameter("qname");
		String qusername = request.getParameter("qusername");
		String qsex = request.getParameter("qsex");

		String condition = " where 1=1 ";
		if (qname != null && !qname.equals("")&&!qname.equalsIgnoreCase("null")) {
			condition += " and name like '%" + qname + "%' ";
		}
		if (qusername != null && !qusername.equals("")&&!qusername.equalsIgnoreCase("null")) {
			condition += " and username like '%" + qusername + "%' ";
		}
		if (qsex != null && !qsex.equals("") && !qsex.equals("-1")&&!qsex.equalsIgnoreCase("null")) {
			condition += " and sex = " + qsex ;
		}
		
		StudentDao dao = new StudentDaoImpl();
		Pager<Student> pager = new Pager<>(dao.getTotals(condition),currentPage);
		List<Student> list = dao.queryByPage(pager.getSp(), pager.getPageSize(),condition);
		pager.setList(list);
		
		map.put("pager", pager);
		map.put("qname", qname);
		map.put("qusername", qusername);
		map.put("qsex", qsex);
		
		return "list";
	}
	
	/*
	 * 处理参数为日期格式
	 * */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	            true));
	}
	
}
