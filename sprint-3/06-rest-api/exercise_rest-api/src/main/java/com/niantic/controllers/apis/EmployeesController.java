package com.niantic.controllers.apis;

import com.niantic.models.Employees;
import com.niantic.services.EmployeesDao;
import com.niantic.services.MySqlEmployeesDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    private EmployeesDao employeesDao = new MySqlEmployeesDao();

    @GetMapping("/api/employees")
    public List<Employees> getAllEmployees()
    {
        return employeesDao.getEmployees();
    }


}
