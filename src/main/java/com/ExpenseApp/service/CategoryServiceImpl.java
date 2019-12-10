package com.ExpenseApp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ExpenseApp.customexception.CategoryNotFoundException;
import com.ExpenseApp.dao.ICategoryDao;
import com.ExpenseApp.dto.CategoryDto;
import com.ExpenseApp.pojo.Category;
import com.ExpenseApp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public String addCategory(CategoryDto categorydto) {
		Category cmodel = new Category();
		cmodel.setCategoryId(categorydto.getCategoryId());
		cmodel.setCategoryName(categorydto.getCategoryName());
		cmodel.setCategoryDesc(categorydto.getCategoryDesc());

		String categoryName = cmodel.getCategoryName();

		categoryRepository.save(cmodel);
		return categoryName + " Category Added in Stock";
	}

	public List<Category> getCategoryList() {
		return categoryRepository.findAll();
	}

	public Optional<Category> getCategoryByIdAndName(Integer id, String name) {
		return categoryRepository.findByCategoryIdAndCategoryName(id, name);
	}

	@Override
	public Category getCategoryById(Integer id) {

		return categoryRepository.findByCategoryId(id);
	}

	@Override
	public String addCategory(@Valid Category category) {
		categoryRepository.save(category);
		return category.getCategoryName() + " Added in Stock";
	}

	@Override
	public Category getCategoryByName(String name) {

		return categoryRepository.findByCategoryName(name);
	}

	public static String getStatus() {
		return "Mocked";
	}
}
