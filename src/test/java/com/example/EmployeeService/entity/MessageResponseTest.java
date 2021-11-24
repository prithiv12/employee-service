package com.example.EmployeeService.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageResponseTest {

    MessageResponse messageResponse = new MessageResponse();
    Date date=new Date();

    @Test
    void testMessage() {
        messageResponse.setMessage("Tested");
        assertEquals(messageResponse.getMessage(), "Tested");
    }

    @Test
    void testStatus() {
        messageResponse.setMessage("Tested");
        assertEquals(messageResponse.getMessage(), "Tested");
    }

    @Test
    void testTimeStamp() {
        messageResponse.setTimeStamp(date);
        assertEquals(messageResponse.getTimeStamp(),date);
    }
}

