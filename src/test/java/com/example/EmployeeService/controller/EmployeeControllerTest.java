package com.example.EmployeeService.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.entity.EmployeeOffers;
import com.example.EmployeeService.entity.MessageResponse;
import com.example.EmployeeService.service.IEmployeeService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController empCont;

    @Mock
    private IEmployeeService empServ;

    EmployeeController employeeController = new EmployeeController();



    @Test
    @DisplayName("Checking for EmployeeController - if it is loading or not for @GetMapping")
    void employeeControllerNotNullTest(){
        assertThat(employeeController).isNotNull();
    }

    @Test
    public void testViewProfile() throws Exception{
        Employee emp1=new Employee(1,"siva","Technical","male",22,98765432102L,"siva@gmail.com",0,null,null,null);
        ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp1,HttpStatus.OK);
        when(empServ.viewEmployee("token", 1)).thenReturn(emp1);
        assertEquals(empCont.viewProfile("token", 1),response);
    }

    @Test
    public void testViewEmployeeOffers() throws Exception{
        Employee emp1=new Employee(1,"Dhatchin","Intern","male",22,98765432103L,"dhatchin@gmail.com",0,null,null,null);
        Employee emp2=new Employee(2,"Harshini","Human Resources","male",22,98765432104L,"Ram@gmail.com",0,null,null,null);
        EmployeeOffers empOffer1=new EmployeeOffers(1,"phone","with latest android version","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,1);
        EmployeeOffers empOffer2=new EmployeeOffers(2,"Tv","with large display","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,2);
        List<EmployeeOffers> offerList=Arrays.asList(empOffer1,empOffer2);
        ResponseEntity<?> response = new ResponseEntity<>(offerList,HttpStatus.OK);
        when(empServ.viewEmpOffers("token", 1)).thenReturn(offerList);
        assertEquals(empCont.viewEmployeeOffers("token", 1),response);
    }

    @Test
    public void testViewTopOffers() throws Exception{
        Employee emp1=new Employee(1,"Dhatchin","Intern","male",22,98765432103L,"dhatchin@gmail.com",0,null,null,null);
        Employee emp2=new Employee(2,"Harshini","Human Resources","male",22,98765432104L,"Ram@gmail.com",0,null,null,null);
        EmployeeOffers empOffer1=new EmployeeOffers(1,"phone","with latest android version","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,1);
        EmployeeOffers empOffer2=new EmployeeOffers(2,"Tv","with large display","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,2);
        List<EmployeeOffers> offerList=Arrays.asList(empOffer1,empOffer2);
        ResponseEntity<?> response = new ResponseEntity<>(offerList,HttpStatus.OK);
        when(empServ.viewTopOffers("token", 1)).thenReturn(offerList);
        assertEquals(empCont.viewTopOffers("token", 1),response);
    }

    @Test
    public void testSavePoints() throws Exception{
        MessageResponse msg=new MessageResponse(new Date(),"points saved successfully",HttpStatus.OK);
        ResponseEntity<MessageResponse> response = new ResponseEntity<MessageResponse>(HttpStatus.OK);
        when(empServ.savePoints("token", 1)).thenReturn(msg);
        assertEquals(empCont.viewProfile("token", 1),response);
    }

    @Test
    public void testGetLikedOffers() throws Exception{
        Employee emp1=new Employee(1,"Dhatchin","Intern","male",22,98765432103L,"dhatchin@gmail.com",0,null,null,null);
        Employee emp2=new Employee(2,"Harshini","Human Resources","male",22,98765432104L,"Ram@gmail.com",0,null,null,null);
        EmployeeOffers empOffer1=new EmployeeOffers(1,"phone","with latest android version","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,1);
        EmployeeOffers empOffer2=new EmployeeOffers(2,"Tv","with large display","Electronics",new Date(),new Date(),new Date(),emp1,emp2,null,2);
        Set<EmployeeOffers> offerSet=new HashSet<EmployeeOffers>();
        offerSet.add(empOffer1);
        offerSet.add(empOffer2);
        when(empServ.getLikedOffers("token")).thenReturn(offerSet);
        assertEquals(empCont.getLikedOffers("token"),offerSet);
    }

}