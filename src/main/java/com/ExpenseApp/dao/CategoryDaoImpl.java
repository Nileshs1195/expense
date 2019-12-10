package com.ExpenseApp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.pojo.Category;
import com.ExpenseApp.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	CategoryRepository categoryRepository;
}