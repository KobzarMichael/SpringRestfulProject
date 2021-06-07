package com.kobzar.spring.rest.Controller;

import com.kobzar.spring.rest.entity.Employee;
import com.kobzar.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/new")
    public void addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname,
                            @RequestParam("department") String department, @RequestParam("salary") int salary) {

        Employee employee = new Employee(name, surname, department, salary);
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }
}
