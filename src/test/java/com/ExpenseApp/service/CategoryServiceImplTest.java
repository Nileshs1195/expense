package com.ExpenseApp.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ExpenseApp.dto.CategoryDto;
import com.ExpenseApp.pojo.Category;
import com.ExpenseApp.repository.CategoryRepository;

public class CategoryServiceImplTest {

	@InjectMocks
	CategoryServiceImpl service;

	@Mock
	CategoryRepository repository;

	@Before
	public void setUp() throws Exception {
		// service=new CategoryServiceImpl();
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Method used to get Category by using CategoryById JPA method
	 */
	@Test
	public void testGetCategoryById() {

		Category cat = new Category();
		cat.setCategoryName("Cars");
		cat.setCategoryDesc("Driving");

		when(repository.findByCategoryId(3)).thenReturn(cat);
		Category catdata = service.getCategoryById(3);
		assertEquals("Cars", catdata.getCategoryName());
	}

	/**
	 * Method used to get CategoryList
	 */

	@Test
	public void testGetgetCategoryList() {
		when(repository.findAll()).thenReturn(Stream.of(new Category(1010, "SS", "aa")).collect(Collectors.toList()));
		assertEquals(1, service.getCategoryList().size());
	}

	/**
	 * Method used to add Category
	 */

	@Test
	public void saveCategory() {
//		CategoryDto cat1=new CategoryDto();
//		cat1.setCategoryId(101);
//		cat1.setCategoryName("Ecommerce Shopping");
//		cat1.setCategoryDesc("Purchase an Item");

		Category cat1 = new Category();
		cat1.setCategoryId(101);
		cat1.setCategoryName("advhgav");
		cat1.setCategoryDesc("Purchase an Item");

		service.addCategory(cat1);
		when(repository.save(cat1)).thenReturn(cat1);
		service.addCategory(cat1);

//		Integer c=service.getCategoryList().size();
//		
//		Category cats=service.getCategoryById(0);

	}
}
