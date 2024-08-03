package com.java.springBoot.repository;

import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.entity.Workbook;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@MyCustomComponent
public class WorkbookRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Workbook createEntity(Workbook workbook) {
		entityManager.persist(workbook);
		return workbook;
	}

	@Transactional
	public Workbook updateEntity(Workbook workbook) {
		return entityManager.merge(workbook);
	}

}
