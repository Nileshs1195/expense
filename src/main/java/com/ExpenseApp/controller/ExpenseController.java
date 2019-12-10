package com.ExpenseApp.controller;

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

import com.ExpenseApp.customexception.ExpenseNotFoundException;
import com.ExpenseApp.pojo.Expense;
import com.ExpenseApp.service.IExpenseService;

/**
 * 
 * @author Nilesh
 *
 */
@RestController
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
	IExpenseService expenseService;

	/**
	 * Method used to add Expense
	 * 
	 * @param Expense
	 * @return status string
	 */
	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
		return new ResponseEntity<String>(expenseService.addExpense(expense), HttpStatus.OK);
	}

	/**
	 * Method used to fetch ExpenseList
	 * 
	 * @param Expense (Parameter not needed but added for some other purpose)
	 * @return Expense List
	 */
	@GetMapping("/expenseList")
	public ResponseEntity<List<Expense>> getExpenseList(@RequestBody Expense expense) {
		return new ResponseEntity<List<Expense>>(expenseService.getExpenseList(expense), HttpStatus.OK);
	}

	/**
	 * Method used to fetch ExpenseList of specific user
	 * 
	 * @param Integer id
	 * @return Expense List
	 */
	@GetMapping("/expenseList/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Expense>(expenseService.getExpense(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new ExpenseNotFoundException("");
		}
	}

	/**
	 * Method used to fetch All Users Expenses
	 * 
	 * @param
	 * @return Expense List
	 */
	@GetMapping("/monthlyExpense")
	public ResponseEntity<List<Object>> getMonthlyExpense() {
		return new ResponseEntity<List<Object>>(expenseService.getMonthlyExpense(), HttpStatus.OK);
	}

	/**
	 * Method used to display monthly expense amount of specific user
	 * 
	 * @param Integer id
	 * @return Expense Amount List
	 */
	@GetMapping("/monthlyExpense/{id}")
	public ResponseEntity<List<Object>> getUsersMonthlyExpense(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<Object>>(expenseService.getUsersMonthlyExpense(id), HttpStatus.OK);
	}

	@PostMapping("/expenseListMappingToUser/{id}")
	public ResponseEntity<String> addExpenses(@PathVariable("id") Integer id, @RequestBody Expense expense) {
		return new ResponseEntity<String>(expenseService.addExpenses(id, expense), HttpStatus.OK);
	}

}
