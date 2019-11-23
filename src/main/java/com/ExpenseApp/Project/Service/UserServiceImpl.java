package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp.Project.Dao.IUserDao;
import com.ExpenseApp.Project.pojo.User;

@Service
public class UserServiceImpl implements IUserService
{ 	
	@Autowired
	private IUserDao userDao;
	
	/**
	 * Method used for user registration
	 * @param user
	 * @return status string
	 */
	public String registerUser(User user)
	{
		try {
			
		}catch(Exception e) {
			//log.error("");
		}
		return userDao.registerUser(user);
	}

	@Override
	public User loginUser(String email, String password) 
	{	
		return userDao.loginUser(email,password);
	}

	@Override
	public List<User> usersList() {
		
		return userDao.usersList();
	}


}
