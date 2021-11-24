package com.example.EmployeeService.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private int empid;
    private String userName;
    private boolean isValid;
}
