package com.mingge.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mingge.entities.Department;
import com.mingge.entities.Employee;


@Repository
public class EmployeeDao {
	@Autowired
	private DepartmentDao departmentDao;

	private static List<Employee>  employees=null;
	

	static{
		employees=new ArrayList<Employee>();
		employees.add(new Employee(1, "张三", "男", 12, new Department(101, "部门1")));
		employees.add(new Employee(2, "李四", "男", 12, new Department(101, "部门1")));
		employees.add( new Employee(3, "王五", "男", 12, new Department(101, "部门1")));
		employees.add( new Employee(4, "赵柳", "男", 12, new Department(101, "部门1")));
		employees.add(new Employee(5, "逗逼", "男", 12, new Department(101, "部门1")));
	}
	
	public Collection<Employee> getAll()
	{
		
		return employees;
	}
	
	public void save(Employee employee)
	{
		if(employee.getId()==null)
		{
			employee.setId(employees.size()+1);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		System.out.println(employee);
		
		employees.add(employee);
	}
	public void delete(Integer id)
	{ 
		for(int i=0;i<employees.size();i++)
		{
			if(employees.get(i).getId()==id)
			{
				employees.remove(i);
			}
		}
	}
	
	public Employee getId(Integer id)
	{
		for(int i=0;i<employees.size();i++)
			if(employees.get(i).getId()==id)
				return employees.get(i);
		return null;
	}
}
