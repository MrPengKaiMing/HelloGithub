package com.mingge.controller;

import java.util.Map;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mingge.dao.DepartmentDao;
import com.mingge.dao.EmployeeDao;
import com.mingge.entities.Employee;
import com.sun.corba.se.spi.orbutil.fsm.Input;

@Controller
@RequestMapping("/mingge")
public class EmployeeHandler {
	public final String SUCCESS="success";
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping("/test")
	public String test()
	{
		System.out.println("success");
		return SUCCESS;
	}
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,Map<String , Object> map)
	{
		if(id!=null)
			map.put("employee", employeeDao.getId(id));
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String Update(Employee employee)
	{
		employeeDao.save(employee);
		return "redirect:/mingge/emps";
	}
	
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map)
	{
		//ModelAndView modelAndView=new ModelAndView("list");
		System.out.println(employeeDao.getAll());
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String, Object> map){
		map.put("employee", employeeDao.getId(id));
		map.put("departments", departmentDao.getAll());
		return "input";
		
	}
	
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String, Object> map)
	{
		map.put("departments", departmentDao.getAll());
		map.put("employee", new Employee());
		return "input";
	}
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee)
	{
		//System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id)
	{
		System.out.println("超链接传进来的id:"+id);
		employeeDao.delete(id);
		return "redirect:/mingge/emps";
	}
	
}
