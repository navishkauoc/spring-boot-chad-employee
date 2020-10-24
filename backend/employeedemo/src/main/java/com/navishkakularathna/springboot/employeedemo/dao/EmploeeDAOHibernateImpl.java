package com.navishkakularathna.springboot.employeedemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.navishkakularathna.springboot.employeedemo.entity.Employee;

@Repository
public class EmploeeDAOHibernateImpl implements EmployeeDAO {
	
	//Define a field for Entity Manager
	private EntityManager entityManager;
	
	//Setup constructor injection
	@Autowired
	public EmploeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//Get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//Execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//Return the results
		return employees;
	}

}
