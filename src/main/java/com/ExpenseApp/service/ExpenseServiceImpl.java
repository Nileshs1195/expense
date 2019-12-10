package com.ExpenseApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp.customexception.ExpenseNotFoundException;
import com.ExpenseApp.dao.IExpenseDao;
import com.ExpenseApp.pojo.Expense;
import com.ExpenseApp.pojo.User;

@Service
public class ExpenseServiceImpl implements IExpenseService {
	@Autowired
	IExpenseDao expenseDao;

	@Override
	public String addExpense(Expense expense) {
		return expenseDao.addExpense(expense);
	}

	@Override
	public Expense getExpense(int expenseid) {
		Expense expenseData = expenseDao.getExpense(expenseid);

		if (expenseData == null) {
			throw new ExpenseNotFoundException("");
		}
		return expenseData;

	}

	@Override
	public List<Expense> getExpenseList(Expense expense) {

		return expenseDao.getExpenseList(expense);
	}

	@Override
	public List<Object> getMonthlyExpense() {
		return expenseDao.getMonthlyExpense();
	}

	@Override
	public List<Object> getUsersMonthlyExpense(Integer id) {
		return expenseDao.getUsersMonthlyExpense(id);
	}

	@Override
	public String addExpenses(Integer id, Expense expense) {

		return expenseDao.addExpenses(id, expense);
	}
}