package com.UST.Employee.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {

    private String id;
    private String employeeName;
    private String skillSet;
    private String email;
    private String status;
    private String domain_id;
}
