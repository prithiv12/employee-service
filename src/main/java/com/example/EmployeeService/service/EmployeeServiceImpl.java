package com.example.EmployeeService.service;

import com.example.EmployeeService.client.AuthClient;
import com.example.EmployeeService.client.OfferClient;
import com.example.EmployeeService.entity.AuthResponse;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.entity.EmployeeOffers;
import com.example.EmployeeService.entity.MessageResponse;
import com.example.EmployeeService.exception.InvalidUserException;
import com.example.EmployeeService.exception.MicroserviceException;
import com.example.EmployeeService.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OfferClient offerClient;

    @Autowired
    private MessageResponse messageResponse;

    @Override
    public List<EmployeeOffers> viewEmpOffers(String token, Integer employeeId) throws MicroserviceException, InvalidUserException {
        log.info("Inside view employee offers");

        AuthResponse authResponse;
        List<EmployeeOffers> empOffers;

        try {
            authResponse = authClient.getValidity(token).getBody();
        } catch (Exception e) {
            throw new MicroserviceException(e.getMessage());
        }

        if (authResponse.isValid()) {
            if (authResponse.getEmpid() != employeeId) {
                throw new InvalidUserException("invalid token for the user");
            }
            try {
                empOffers = offerClient.getOffersById(token, employeeId);
            } catch (Exception e) {
                throw new MicroserviceException(e.getMessage());
            }
            return empOffers;
        } else {
            log.error("Token invalid");
            throw new InvalidUserException("Invalid User");
        }
    }

    @Override
    public Employee viewEmployee(String token, Integer id) throws MicroserviceException,
            InvalidUserException {
        log.info("Inside view employee");
        AuthResponse authResponse;
        try {
            authResponse = authClient.getValidity(token).getBody();
        } catch (Exception e) {
            throw new MicroserviceException(e.getMessage());
        }
        if (authResponse.isValid()) {
            if (authResponse.getEmpid() != id) {
                throw new InvalidUserException("token is invalid for the given user");
            }
            Employee employee = employeeRepository.findById(id).orElse(null);
            if (employee == null) {
                log.error("Invalid employee id");
                throw new NoSuchElementException();
            }
            return employee;
        } else {
            log.error("Token invalid");
            throw new InvalidUserException("Invalid User");
        }
    }
    @Override
    public List<EmployeeOffers> viewTopOffers(String token, Integer employeeId)
            throws MicroserviceException, InvalidUserException {
        log.info("Inside view top offers");
        AuthResponse authResponse;
        try {
            authResponse = authClient.getValidity(token).getBody();
        } catch (Exception e) {
            throw new MicroserviceException(e.getMessage());
        }
        if (authResponse.isValid()) {
            List<EmployeeOffers> empOffers;
            try {
                empOffers = offerClient.getOffersById(token, employeeId);
            } catch (Exception e) {
                throw new MicroserviceException(e.getMessage());
            }

            List<EmployeeOffers> empList = empOffers.stream()
                    .sorted(Comparator.comparing(EmployeeOffers::getLikes).reversed()).limit(3)
                    .collect(Collectors.toList());
            return empList;
        } else {
            log.error("Token invalid");
            throw new InvalidUserException("Invalid User");
        }
    }
    @Override
    public MessageResponse savePoints(String token, Integer points) throws MicroserviceException, InvalidUserException {
        log.info("Inside save points");
        AuthResponse authResponse;

        try {
            authResponse = authClient.getValidity(token).getBody();
        } catch (Exception e) {
            throw new MicroserviceException(e.getMessage());
        }

        if (authResponse.isValid()) {
            Employee emp = employeeRepository.findById(authResponse.getEmpid()).orElse(null);
            emp.setPointsGained(points);
            employeeRepository.save(emp);
            messageResponse.setMessage("points updated successfully");
            messageResponse.setStatus(HttpStatus.OK);
            messageResponse.setTimeStamp(new Date());
            return messageResponse;
        } else {
            throw new InvalidUserException("invalid user");
        }
    }

    @Override
    public Set<EmployeeOffers> getLikedOffers(String token) throws MicroserviceException, InvalidUserException {
        log.info("Inside like offer");
        AuthResponse authResponse;
        List<EmployeeOffers> emp;

        try {
            authResponse = authClient.getValidity(token).getBody();
        } catch (Exception e) {
            throw new MicroserviceException(e.getMessage());
        }

        if (authResponse.isValid()) {
            log.info("" + authResponse.getEmpid());
            emp = offerClient.getRecentlyLikedOffers(token);
            return emp.stream().collect(Collectors.toSet());
        }

        throw new InvalidUserException("invalid user");
    }

}
