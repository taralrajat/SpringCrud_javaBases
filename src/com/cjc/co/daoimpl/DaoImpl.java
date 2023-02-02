package com.cjc.co.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.co.daoi.Dao;
import com.cjc.co.model.Employee;


@Repository
public class DaoImpl implements Dao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveUser(Employee e) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (int) session.save(e);
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();
		Query Q = session.createQuery("from Employee");
		List<Employee> elist = Q.getResultList();
		return elist;
	}

	@Override
	public List<Employee> loginUser(Employee e) {
		Session session = sessionFactory.openSession();
		Query Q = session.createQuery("from Employee where username=:u and password=:p");
		Q.setParameter("u", e.getUsername());
		Q.setParameter("p", e.getPassword());
		List<Employee> elist = Q.getResultList();		
		return elist;
	}

	@Override
	public void deleteUser(int id) {	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query Q = session.createQuery("delete from Employee where id=:id");
		Q.setParameter("id", id);
		Q.executeUpdate();
		tx.commit();
	}

	@Override
	public Employee getUser(int id) {
		Session session = sessionFactory.openSession();
		Query Q = session.createQuery("from Employee where id=:id");
		Q.setParameter("id", id);
		Employee e = (Employee) Q.getSingleResult();
		return e;
	}

	@Override
	public void updateUser(Employee e) {    //id   name   usernmae   password      addr.city
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		Query Q = session.createQuery("update User set name=:n, username=:u, password=:p *********city=:c*************** where id=:i");
//		
//		Q.setParameter("n", e.getName());
//		Q.setParameter("u", e.getUsername());
//		Q.setParameter("p", e.getPassword());
//		Q.setParameter("i", e.getId());
//		Q.executeUpdate();
		
		session.update(e);
		tx.commit();
	}

}
