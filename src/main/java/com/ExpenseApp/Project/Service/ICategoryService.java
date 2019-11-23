package com.ExpenseApp.Project.Service;

import java.util.List;
import java.util.Optional;

import com.ExpenseApp.Project.pojo.Category;

public interface ICategoryService
{
	
	public String addCategory(Category category);

	public List<Category> getCategoryList();

	public Category getCategoryById(int cid);

	public Optional<Category> getCategoryByIdAndName(Integer id, String name);

	
}
