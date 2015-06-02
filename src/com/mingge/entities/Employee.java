package com.mingge.entities;

public class Employee {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private Department department;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee(Integer id, String name, String sex, Integer age,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", department=" + department + "]";
	}
	public Employee() {
		
	}
	
}
