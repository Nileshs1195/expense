package com.ExpenseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExpenseApp.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
