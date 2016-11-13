package com.sistema.hibernate.exam01;

import java.util.List;

import com.sistema.hibernate.exam01.dao.EmployeeDAO;
import com.sistema.hibernate.exam01.impl.HibernateEmployeeDAO;
import com.sistema.hibernate.exam01.models.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDAO employeeDAO = new HibernateEmployeeDAO();
        
        employeeDAO.insert(new Employee(1L, "name1", "email1", 2000f));
        employeeDAO.insert(new Employee(2L, "name2", "email2", 4000f));
        
        List employees = employeeDAO.selectAll();
        
    }
}
