package com.cjc.co.daoi;

import java.util.List;

import com.cjc.co.model.Employee;

public interface Dao {
	
	public int saveUser(Employee e);
	
	public List<Employee> getAll();
	
	public List<Employee> loginUser(Employee e);
	
	public void deleteUser(int id);
	
	public Employee getUser(int id);

	public void updateUser(Employee e);
}
