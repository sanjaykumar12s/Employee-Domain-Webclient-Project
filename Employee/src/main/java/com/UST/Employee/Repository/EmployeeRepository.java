package com.UST.Employee.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.UST.Employee.Model.Employee;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Flux<Employee> findBySkillSet(String skillSet);
    Flux<Employee> findByStatus(String status);
}
