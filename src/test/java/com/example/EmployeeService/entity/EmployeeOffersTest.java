package com.example.EmployeeService.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeOffersTest {

    EmployeeOffers offers=new EmployeeOffers();
    EmployeeOffers empOffers=new EmployeeOffers();

    @Test
    void testOfferId()
    {
        offers.setId(1);
        assertEquals(offers.getId(),1);
    }

    @Test
    void testOfferName()
    {
        offers.setName("abc");
        assertEquals(offers.getName(),"abc");
    }

    @Test
    void testOfferDescription()
    {
        offers.setDescription("House for sale");
        assertEquals(offers.getDescription(),"House for sale");
    }

    @Test
    void testOfferEmpId()
    {
        offers.setId(1);
        assertEquals(offers.getId(),1);
    }

    @Test
    void testOfferEngagedEmpId()
    {
        Employee emp = new Employee();
        offers.setEngagedEmployee(emp);
        assertEquals(offers.getEngagedEmployee(),emp);
    }

    @Test
    void testOpenedDate()
    {
        offers.setOpenDate(new Date());
        assertEquals(offers.getOpenDate(),new Date());
    }

    @Test
    void testEngagedDate()
    {
        Date date = new Date();
        offers.setEngagedDate(date);
        assertEquals(offers.getEngagedDate(),date);
    }

    @Test
    void testClosedDate()
    {

        offers.setClosedDate(new Date());
        assertEquals(offers.getClosedDate(),new Date());
    }

    @Test
    void testLikes()
    {
        offers.setLikes(10);
        assertEquals(offers.getLikes(),10);
    }

    @Test
    void testOfferCategory()
    {
        offers.setCategory("House Rental");
        assertEquals(offers.getCategory(),"House Rental");
    }

}
