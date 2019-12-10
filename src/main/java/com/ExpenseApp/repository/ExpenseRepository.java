package com.ExpenseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExpenseApp.pojo.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
