package com.example.EmployeeService.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthResponseTest {

    AuthResponse authResponse=new AuthResponse();
    AuthResponse auth=new AuthResponse(1,"siva",true);

    @Test
    void testEmpid()
    {
        authResponse.setEmpid(1);
        assertEquals(authResponse.getEmpid(),1);
    }

    @Test
    void testUserName()
    {
        authResponse.setUserName("siva");
        assertEquals(authResponse.getUserName(),"siva");
    }

    @Test
    void testIsValid()
    {
        authResponse.setValid(true);
        assertEquals(authResponse.isValid(),true);
    }

    @Test
    void testToString() {
        String string = auth.toString();
        assertEquals(auth.toString(), string);
    }
}

