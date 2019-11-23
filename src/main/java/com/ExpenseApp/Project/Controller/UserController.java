package com.ExpenseApp.Project.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.Project.Service.IUserService;
import com.ExpenseApp.Project.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController
{	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		if(user.getPassword().equals(user.getConfirmPassword()))
		{
			return new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("password dosen't match",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/loginuser")
	public User loginUser(@RequestBody User user)
	{
		String email=user.getEmail();
		String Password=user.getPassword();
		return userService.loginUser(email,Password);
	}
	
	/**
	 * Method used to get registered users list
	 * @param No any parameter provided
	 * @return List of registered Users
	 */
	
	@GetMapping("/usersList")
	public List<User> usersList()
	{
		return userService.usersList();
	}
	


}
