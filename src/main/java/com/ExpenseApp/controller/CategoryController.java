package com.ExpenseApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.customexception.CategoryNotFoundException;
import com.ExpenseApp.dto.CategoryDto;
import com.ExpenseApp.pojo.Category;
import com.ExpenseApp.service.CategoryServiceImpl;
import com.ExpenseApp.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController

{
	@Autowired
	ICategoryService categoryService;

	/**
	 * Method used to add Category
	 * 
	 * @param Category Object
	 * @return status string
	 */

	@PostMapping("/addcategory")
	public ResponseEntity<String> addCategory(@Valid @RequestBody Category category) {
		return new ResponseEntity<String>(categoryService.addCategory(category), HttpStatus.OK);
	}

	/**
	 * Method used get Category List
	 * 
	 * @param No parameter
	 * @return Category List
	 */
	@GetMapping("/categorylist")
	public ResponseEntity<List<Category>> getCategoryList() {
		return new ResponseEntity<List<Category>>(categoryService.getCategoryList(), HttpStatus.OK);
	}

	/**
	 * Method used get specific Category
	 * 
	 * @param Integer id
	 * @return Category Details if id is valid or returns and Exception
	 */

	@GetMapping("/categorylist/{id}")
	public Category getCategoryById(@PathVariable Integer id) {
		return categoryService.getCategoryById(id);
	}

	/**
	 * Method used to get CategoryType
	 * 
	 * @param categoryId and categoryName
	 * @return Category Details (Category Object)
	 */
	@PostMapping("/categoryType")
	public Optional<Category> getCategoryByIdAndName(@RequestBody Category category) {
		Integer id = category.getCategoryId();
		String name = category.getCategoryName();
		return categoryService.getCategoryByIdAndName(id, name);
	}

	@PostMapping("/categoryname")
	public Category getCategoryByName(@RequestBody Category category) {
		String name = category.getCategoryName();

		return categoryService.getCategoryByName(name);
	}

}