package com.ExpenseApp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.pojo.Expense;
import com.ExpenseApp.pojo.User;
import com.ExpenseApp.repository.ExpenseRepository;
import com.ExpenseApp.repository.UserRepository;

@Repository
@Transactional
public class ExpenseDaoImpl implements IExpenseDao {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public String addExpense(Expense expense) {
		/** START **/

		User user = expense.getUser();
		expense.getUser().getUserid();

		entityManager.persist(expense);
		System.out.println(expense);
		return "Expense Added Successfully";

		/** END **/
	}

	@Override
	public Expense getExpense(int expenseid) {
		String jpql = "select e from Expense e where e.expense_id=:eid";
		Expense expense = entityManager.createQuery(jpql, Expense.class).setParameter("eid", expenseid)
				.getSingleResult();

		return expense;
	}

	@Override
	public List<Expense> getExpenseList(Expense expense) {
		String jpql = "select e from Expense e ";
		return entityManager.createQuery(jpql, Expense.class).getResultList();
	}

	@Override
	public List<Object> getMonthlyExpense() {

			String jpql = "select e.expense_amount from Expense e ";
		return entityManager.createQuery(jpql, Object.class).getResultList();

	}

	public List<Object> getUsersMonthlyExpense(Integer id) {
		String jpql = "select e.expense_amount from Expense e where userid=:cid";
		return entityManager.createQuery(jpql, Object.class).setParameter("cid", id).getResultList();

	}

	@Override
	public String addExpenses(Integer id, Expense expense) {

		System.out.println("id ........." + id);
		String userJpql = "select u from user u where u.userid=:uid";
		User user = entityManager.createQuery(userJpql, User.class).setParameter("uid", id).getSingleResult();
		Expense expData = new Expense();

		System.out.println(user);
		Integer userId = user.getUserid();
		System.out.println(userId);
		if (userId.equals(id)) {
			expense.getUser().setUserid(id);
			entityManager.persist(expense);

		}
		return expense.getExpense_type() + "Added";
	}
}
