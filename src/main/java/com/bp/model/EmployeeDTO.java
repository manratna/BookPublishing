package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private JobDTO job;
    private Integer jobLevel;
    private PublisherDTO publisher;
    private String hireDate;
}

