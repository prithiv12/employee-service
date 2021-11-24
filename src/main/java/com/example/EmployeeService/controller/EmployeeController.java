package com.example.EmployeeService.controller;

import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.entity.EmployeeOffers;
import com.example.EmployeeService.entity.MessageResponse;
import com.example.EmployeeService.exception.InvalidUserException;
import com.example.EmployeeService.exception.MicroserviceException;
import com.example.EmployeeService.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/viewEmployeeOffers/{id}")
    public ResponseEntity<?> viewEmployeeOffers(@RequestHeader(name = "Authorization", required = true) String token,
                                                @PathVariable("id") Integer id) throws InvalidUserException, MicroserviceException {
        log.info("Inside view employee offers");
        return new ResponseEntity<>(employeeService.viewEmpOffers(token, id), HttpStatus.OK);
    }

    @GetMapping("/viewProfile/{id}")
    public ResponseEntity<Employee> viewProfile(@RequestHeader(name = "Authorization", required = true) String token,
                                                @PathVariable("id") Integer id) throws InvalidUserException, MicroserviceException {
        log.info("Inside view employee profile");
        return new ResponseEntity<Employee>(employeeService.viewEmployee(token, id), HttpStatus.OK);
     }

    @GetMapping("/viewMostLikedOffers/{id}")
    public ResponseEntity<?> viewTopOffers(@RequestHeader(name = "Authorization", required = true) String token,
                                           @PathVariable("id") Integer id) throws InvalidUserException, MicroserviceException {
        log.info("Inside view top offers");
        return new ResponseEntity<>(employeeService.viewTopOffers(token, id), HttpStatus.OK);
    }

    @PostMapping("/savePoints/{points}")
    public ResponseEntity<MessageResponse> savePoints(@RequestHeader("Authorization") String token,
                                                      @PathVariable("points") Integer points) throws InvalidUserException, MicroserviceException {
        log.info("inside save points");
        return new ResponseEntity<>(employeeService.savePoints(token, points), HttpStatus.OK);
    }

   @GetMapping("/recentlyLiked")
    public Set<EmployeeOffers> getLikedOffers(@RequestHeader("Authorization") String token)
            throws InvalidUserException, MicroserviceException {
        return employeeService.getLikedOffers(token);
    }
}