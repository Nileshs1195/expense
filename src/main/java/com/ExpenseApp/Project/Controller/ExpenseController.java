package com.ExpenseApp.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.Project.CustomException.ExpenseNotFoundException;
import com.ExpenseApp.Project.Service.IExpenseService;
import com.ExpenseApp.Project.pojo.Expense;

@RestController
@RequestMapping("/expense")
public class ExpenseController
{	
	@Autowired
	IExpenseService expenseService;
	
	/**
	 * Method used to add Expense 
	 * @param Expense 
	 * @return status string
	 */
	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody Expense expense)
	{
		return new ResponseEntity<String>(expenseService.addExpense(expense),HttpStatus.OK);
	}
	
	/**
	 * Method used to fetch ExpenseList 
	 * @param Expense (Parameter not needed but added for some other purpose)  
	 * @return Expense List
	 */
	@GetMapping("/expenseList")
	public ResponseEntity<List<Expense>> getExpenseList(@RequestBody Expense expense)
	{
		return new ResponseEntity<List<Expense>> (expenseService.getExpenseList(expense),HttpStatus.OK);
	}
	
	@GetMapping("/expenseList/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable Integer id)
	{
		try
		{
			return new ResponseEntity<Expense> (expenseService.getExpense(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ExpenseNotFoundException("");
		}
	}
	
	@GetMapping("/monthlyExpense")
	public ResponseEntity<List<Object>> getMonthlyExpense()
	{
		return new ResponseEntity<List<Object>>(expenseService.getMonthlyExpense(),HttpStatus.OK);
	}
	

//	@GetMapping("/monthlyExpenseByUser")
//	public List<Object> getUsersMonthlyExpense(Integer id)
//	{
//		return (List<Object>) new ResponseEntity<List<Object>>(expenseService.getUsersMonthlyExpense(id),HttpStatus.OK);
//	}

}
