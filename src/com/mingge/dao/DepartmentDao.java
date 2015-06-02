package com.mingge.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sun.awt.image.OffScreenImage;

import com.mingge.entities.Department;


@Repository
public class DepartmentDao {
	private static List<Department> departments=null;
	
	static{
	departments=new ArrayList<Department>();
		departments.add(new Department(1,"部门1"));
		departments.add(new Department(2,"部门2"));
		departments.add(new Department(3,"部门3"));
		departments.add(new Department(4,"部门4"));
		departments.add(new Department(5,"部门5"));
		departments.add(new Department(6,"部门6"));
	}

	public Collection<Department> getAll()
	{
		return departments;
	}
	public Department getDepartment(Integer id)
	{
		
		for(int i=0;i<departments.size();i++)
		{
			if(departments.get(i).getId()==id)
				return departments.get(i);
		}
		
		return null;
	
	}
	
}
