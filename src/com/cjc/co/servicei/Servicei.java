package com.cjc.co.servicei;

import java.util.List;

import com.cjc.co.model.Employee;


public interface Servicei {

	public int saveUser(Employee e);
	public List<Employee> getAll();
	public List<Employee> loginUser(Employee e);
	public void deleteUser(int id);
	public Employee getUser(int id);
	public void updateUser(Employee e);
}
