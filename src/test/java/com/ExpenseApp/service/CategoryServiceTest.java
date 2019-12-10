package com.ExpenseApp.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.ExpenseApp.dto.CategoryDto;
import com.ExpenseApp.pojo.Category;
import com.ExpenseApp.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryServiceImpl service;
	
	/**
	 * Method used to get Category by using CategoryById JPA method
	 */
	@Test
	public void testGetCategoryById()
	{	
		Category cat=service.getCategoryById(7);
		Assert.assertEquals("Paint", cat.getCategoryName());
		Assert.assertEquals("color", cat.getCategoryDesc());	
	}
	
	/**
	 * Method used to add Category  
	 */
	@Test
	public void testSaveCategory()
	{
		CategoryDto cat1=new CategoryDto();
		cat1.setCategoryId(101);
		cat1.setCategoryName("Ecommerce Shopping");
		cat1.setCategoryDesc("Purchase an Item");
		
		service.addCategory(cat1);
	}
	
	@Test
	public void testGetCategoryByName()
	{	
		Category cat=service.getCategoryByName("Paint");
		assertEquals("Paint",cat.getCategoryName());
		
		//Assert.assertEquals("", "Paint",service.getCategoryByName("Paint") );
	}
	
}
