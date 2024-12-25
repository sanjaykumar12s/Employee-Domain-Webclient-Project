package com.UST.Employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UST.Employee.Model.Employee;
import com.UST.Employee.Repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<Employee> addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Flux<Employee> findBySkillSet(String skillSet) {
        return employeeRepository.findBySkillSet(skillSet);
    }

    public Flux<Employee> findByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }
}
