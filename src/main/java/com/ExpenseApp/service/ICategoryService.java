package com.ExpenseApp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.ExpenseApp.dto.CategoryDto;
import com.ExpenseApp.pojo.Category;

public interface ICategoryService {

	public String addCategory(CategoryDto categorydto);

	public List<Category> getCategoryList();

	// public Optional<Category> getCategoryById(int cid);

	public Optional<Category> getCategoryByIdAndName(Integer id, String name);

	public Category getCategoryById(Integer id);

	public String addCategory(@Valid Category category);

	Category getCategoryByName(String name);

}
