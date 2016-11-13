package com.sistema.hibernate.exam01.dao;

import java.util.List;

import com.sistema.hibernate.exam01.models.Employee;

public interface EmployeeDAO {
	public Employee selectById(Integer id);

	public List<Employee> selectAll();

	public void insert(Employee employee);

	public void update(Employee employee);

	public void delete(Employee employee);
}
