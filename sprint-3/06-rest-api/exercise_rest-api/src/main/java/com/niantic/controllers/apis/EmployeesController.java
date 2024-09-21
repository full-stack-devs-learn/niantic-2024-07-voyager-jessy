package com.niantic.controllers.apis;

import com.niantic.models.Employees;
import com.niantic.models.HttpError;
import com.niantic.services.EmployeesDao;
import com.niantic.services.MySqlEmployeesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeesDao employeesDao;

    @Autowired
    public EmployeesController(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees()
    {
        try{
            var employees = employeesDao.getEmployees();
            return ResponseEntity.ok(employees);
        }
        catch(Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Error has occured");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }


}
