package com.mbaraujo.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDetails {

    private int id;
    private String firstName;
    private String lastName;

}
