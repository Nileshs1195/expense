package com.ExpenseApp.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.Project.Service.CategoryServiceImpl;
import com.ExpenseApp.Project.Service.ICategoryService;
import com.ExpenseApp.Project.pojo.Category;

@RestController
@RequestMapping("/category")
public class CategoryController

{	
	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
	/**
	 * Method used to add Category 
	 * @param Category
	 * @return status string
	 */
	@PostMapping("/addcategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
	{	
		return new ResponseEntity<String>(categoryServiceImpl.addCategory(category),HttpStatus.OK);
	} 
	
	/**
	 * Method used to get CategoryType 
	 * @param categoryId and categoryName
	 * @return Category Details (Category Object)
	 */
	@PostMapping("/categoryType")
	public Optional<Category> getCategoryByIdAndName(@RequestBody Category category)
	{
		Integer id=category.getCategoryId();
		String name=category.getCategoryName();
		return categoryService.getCategoryByIdAndName(id,name);
	}
	
	@GetMapping("/categorylist")
	public ResponseEntity<List<Category>> getCategoryList()
	{
		return new ResponseEntity<List<Category>>(categoryService.getCategoryList(),HttpStatus.OK);
	}
	
	@GetMapping("/categorylist/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id)
	{
		return new ResponseEntity<Category>(categoryService.getCategoryById(id),HttpStatus.OK);
	}
}