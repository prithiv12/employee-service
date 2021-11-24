package com.example.EmployeeService.service;

import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.entity.EmployeeOffers;
import com.example.EmployeeService.entity.MessageResponse;
import com.example.EmployeeService.exception.InvalidUserException;
import com.example.EmployeeService.exception.MicroserviceException;

import java.util.List;
import java.util.Set;

public interface IEmployeeService {

    public List<EmployeeOffers> viewEmpOffers(String token, Integer employeeId) throws MicroserviceException,InvalidUserException;

    public List<EmployeeOffers> viewTopOffers(String token,Integer employeeId) throws MicroserviceException, InvalidUserException;

    public Employee viewEmployee(String token, Integer id) throws MicroserviceException, InvalidUserException;

    public MessageResponse savePoints(String token, Integer points) throws MicroserviceException, InvalidUserException;

    public Set<EmployeeOffers> getLikedOffers(String token) throws MicroserviceException,InvalidUserException;

}
