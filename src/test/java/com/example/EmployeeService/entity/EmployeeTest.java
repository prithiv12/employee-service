package com.example.EmployeeService.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    Employee emp=new Employee();

    @Test
    void testEmpId()
    {
        emp.setId(1);
        assertEquals(emp.getId(),1);
    }

    @Test
    void testEmpName()
    {
        emp.setEName("abc");
        assertEquals(emp.getEName(),"abc");
    }

    @Test
    void testEmpDepartment()
    {
        emp.setEDepartment("Sales");
        assertEquals(emp.getEDepartment(),"Sales");
    }

    @Test
    void testEmpGender()
    {
        emp.setGender("Male");
        assertEquals(emp.getGender(),"Male");
    }

    @Test
    void testEmpAge()
    {
        emp.setAge(23);
        assertEquals(emp.getAge(),23);
    }

    @Test
    void testEmpContactNumber()
    {
        long number = Long.parseLong(new String("12345"));
        emp.setPhoneNumber(number);
        assertEquals(emp.getPhoneNumber(),12345);
    }

    @Test
    void testEmpEmail()
    {
        emp.setEmail("abc@gmail.com");
        assertEquals(emp.getEmail(),"abc@gmail.com");
    }

    @Test
    void testEmpPoints()
    {
        emp.setPointsGained(100);
        assertEquals(emp.getPointsGained(),100);
    }

}