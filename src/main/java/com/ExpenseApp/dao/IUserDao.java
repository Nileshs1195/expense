package com.ExpenseApp.dao;

import java.util.List;

import com.ExpenseApp.pojo.User;

public interface IUserDao {

	String registerUser(User user);

	User loginUser(String email, String password);

	List<User> usersList();

}
