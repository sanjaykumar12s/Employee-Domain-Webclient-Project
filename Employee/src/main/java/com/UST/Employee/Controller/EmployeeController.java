package com.UST.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.UST.Employee.Model.Employee;
import com.UST.Employee.Service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public Mono<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @GetMapping("/getallemployee")
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/skills/{skillSet}")
    public Flux<Employee> getEmployeesBySkillSet(@PathVariable("skillSet") String skillSet) {
        return employeeService.findBySkillSet(skillSet);
    }

    @GetMapping("/status/{status}")
    public Flux<Employee> getEmployeesByStatus(@PathVariable String status) {
        return employeeService.findByStatus(status);
    }
}
