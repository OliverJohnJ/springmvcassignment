package com.te.assignmentapp.respo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import com.te.assignmentapp.Employee.Employee;

public class Employe {

	Employee e;

	public void save(Employee emp) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(emp);
		transaction.commit();
		System.out.println("saved");
	}

	public Employee retrive(String name) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Employee find = entityManager.find(Employee.class, name);
		e = find;
		return find;
	}

	public Employee getE() {
		return e;
	}

	public void delete(String name) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee find = entityManager.find(Employee.class, name);
		entityManager.persist(find);
		entityManager.remove(find);
		transaction.commit();
		
	}
	
	

	public void update(String name, String updatedname) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Employee find = entityManager.find(Employee.class, name);
		entityManager.persist(find);
		find.setName(updatedname);
		transaction.commit();
		System.out.println("updated");	
		
	}
	
	
	

}
