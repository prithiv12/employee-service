package com.example.EmployeeService.entity;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MessageResponse {

    Date timeStamp;
    String message;
    HttpStatus status;

    public MessageResponse(String message, HttpStatus status) {
        super();
        this.message = message;
        this.timeStamp=new Date();
        this.status=status;
    }
}