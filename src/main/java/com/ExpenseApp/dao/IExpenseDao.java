package com.ExpenseApp.dao;

import java.util.List;

import com.ExpenseApp.pojo.Expense;

public interface IExpenseDao {
	String addExpense(Expense expense);

	Expense getExpense(int expenseid);

	List<Expense> getExpenseList(Expense expense);

	List<Object> getMonthlyExpense();

	List<Object> getUsersMonthlyExpense(Integer id);

	String addExpenses(Integer id, Expense expense);

}
