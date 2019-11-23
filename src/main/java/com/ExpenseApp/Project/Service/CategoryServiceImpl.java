package com.ExpenseApp.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ExpenseApp.Project.Dao.ICategoryDao;
import com.ExpenseApp.Project.Repository.CategoryRepository;
import com.ExpenseApp.Project.pojo.Category;

@Service
//public class CategoryServiceImpl 
public class CategoryServiceImpl implements ICategoryService
{
	@Autowired
	ICategoryDao categoryDao;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public String addCategory(Category category)
	{	
		String categoryName=category.getCategoryName();
		categoryRepository.save(category);
		 return categoryName+ " Category Added in Stock";
	}
	
	public Optional<Category> getCategoryByIdAndName(Integer id, String name)
	{
		return categoryDao.getCategoryByIdAndName(id,name);
	}
	
//	@Override
//	public String addCategory(Category category)
//	{
//		return categoryDao.addCategory(category);
//	}
	
	@Override
	public List<Category> getCategoryList() 
	{	
		return categoryDao.getCategoryList();
	}
	
	@Override
	public Category getCategoryById(int cid)
	{
		return categoryDao.getCategoryById(cid);
	}
}
