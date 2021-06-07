package com.kobzar.spring.rest.service;

import com.kobzar.spring.rest.DAO.EmployeeDAO;
import com.kobzar.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

    @Transactional
    public void addNewEmployee (Employee employee) {
        employeeDAO.addNewEmployee(employee);
    }

    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
