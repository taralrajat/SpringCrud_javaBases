package com.cjc.co.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.co.daoi.Dao;
import com.cjc.co.model.Employee;
import com.cjc.co.servicei.Servicei;

@Service
public class ServiceImpl implements Servicei{

	@Autowired
	Dao di;
	
	@Override
	public int saveUser(Employee e) {
		
		int count = di.saveUser(e);
		
		return count;
	}

	@Override
	public List<Employee> getAll() {
		
		return di.getAll();
	}

	@Override
	public List<Employee> loginUser(Employee e) {
		return di.loginUser(e);
	}

	@Override
	public void deleteUser(int id) {
		
		di.deleteUser(id);
	}

	@Override
	public Employee getUser(int id) {
		
		return di.getUser(id);
	}

	@Override
	public void updateUser(Employee e) {
		
		di.updateUser(e);
	}

}
