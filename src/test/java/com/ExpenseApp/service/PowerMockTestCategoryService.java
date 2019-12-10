package com.ExpenseApp.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CategoryServiceImpl.class)
public class PowerMockTestCategoryService {

	@InjectMocks
	CategoryServiceImpl service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(CategoryServiceImpl.class);
	}

	@Test
	public void testGetMessage() {
		String status = "Mocked";

		when(CategoryServiceImpl.getStatus()).thenReturn(status);

		assertEquals(status, service.getStatus());

	}

}
