package com.ExpenseApp.Project.Dao;

import java.util.List;
import java.util.Optional;

import com.ExpenseApp.Project.pojo.Category;

public interface ICategoryDao {
	
		
		public String addCategory(Category category);

		

		public List<Category> getCategoryList();



		public Category getCategoryById(int cid);



		public Optional<Category> getCategoryByIdAndName(Integer id, String name);
		

	}



