package com.niantic.services;

import com.niantic.models.Employees;

import java.util.List;

public interface EmployeesDao {
    List<Employees> getEmployees();
}
