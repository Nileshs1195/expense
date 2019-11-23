package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp.Project.Dao.IExpenseDao;
import com.ExpenseApp.Project.pojo.Expense;

@Service
public class ExpenseServiceImpl implements IExpenseService
{
	@Autowired
	IExpenseDao expenseDao;
	
	@Override
	public String addExpense(Expense expense)
	{	
		return expenseDao.addExpense(expense);
	}

	@Override
	public Expense getExpense(int expenseid) {
		return expenseDao.getExpense(expenseid);

	}

	@Override
	public List<Expense> getExpenseList(Expense expense)
	{
		
		return expenseDao.getExpenseList(expense);
	}

	@Override
	public List<Object> getMonthlyExpense() {
		return expenseDao.getMonthlyExpense();
	}
}