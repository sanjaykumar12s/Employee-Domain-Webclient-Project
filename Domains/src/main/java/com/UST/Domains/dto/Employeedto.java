package com.UST.Domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeedto {
    private String id;
    private String employeeName;
    private String skillSet;
    private String email;
    private String status;
    private String domain_id;
}
