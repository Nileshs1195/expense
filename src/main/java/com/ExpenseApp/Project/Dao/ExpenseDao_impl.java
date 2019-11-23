package com.ExpenseApp.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.pojo.Expense;

@Repository
@Transactional
public class ExpenseDao_impl implements IExpenseDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public String addExpense(Expense expense)
	{	
		entityManager.persist(expense);
		return "Expense Added Successfully";
	}
	

	@Override
	public Expense getExpense(int expenseid) {
		String jpql= "select e from Expense e where e.expense_id=:eid";
		Expense expense=entityManager.createQuery(jpql,Expense.class).setParameter("eid",expenseid).getSingleResult();
		
		return expense;
	}


	@Override
	public List<Expense> getExpenseList(Expense expense)
	{
		String jpql="select e from Expense e ";
		return entityManager.createQuery(jpql,Expense.class).getResultList();
	}


	@Override
	public List<Object> getMonthlyExpense() {
		String jpql="select sum(e.expense_amount) from Expense e group by userid";
		return entityManager.createQuery(jpql).getResultList();
	
	}	
}