package com.sistema.hibernate.exam01.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.exam01.HibernateSession;
import com.sistema.hibernate.exam01.dao.EmployeeDAO;
import com.sistema.hibernate.exam01.models.Employee;

public class HibernateEmployeeDAO implements EmployeeDAO {
	public Employee selectById(Integer id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}

	public List<Employee> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		session.close();
		return employees;
	}

	public void insert(Employee employee) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(employee);
		employee.setId(id);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(Employee employee) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
		
	}

	public void delete(Employee employee) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		
	}
}
