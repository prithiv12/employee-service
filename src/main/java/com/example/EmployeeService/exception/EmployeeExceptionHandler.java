package com.example.EmployeeService.exception;

import com.example.EmployeeService.entity.MessageResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleUserNotFoundException(NullPointerException ce) {
        log.error("Bad request:Employee Details not found");
        return ResponseEntity.badRequest().body(new MessageResponse("Employee Details not Found",HttpStatus.UNAUTHORIZED));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ResponseEntity<?> handleStringIndexOutOfBoundException(StringIndexOutOfBoundsException sie) {
        log.error("Bad Request:Not a valid token");
        return ResponseEntity.badRequest().body(new MessageResponse("Not a valid token", HttpStatus.UNAUTHORIZED));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleFeignException(FeignException fe) {
        log.error("Bad request:Service Unavailable");
        return ResponseEntity.badRequest().body(new MessageResponse("Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException ere) {
        log.error("Bad request:Employee ID not exist");
        return ResponseEntity.badRequest().body(new MessageResponse("Employee ID not exist", HttpStatus.NOT_FOUND));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException nsee) {
        log.error("Bad request:Employee ID not exist");
        return ResponseEntity.badRequest().body(new MessageResponse("Employee ID not exist", HttpStatus.NOT_FOUND));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<?> handleServiceDownException(ConnectException ce) {
        log.error("Bad request:Check your Connection");
        return ResponseEntity.badRequest().body(new MessageResponse("Check your Connection", HttpStatus.SERVICE_UNAVAILABLE));

    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<?> handleInvalidUserException(InvalidUserException ie) {
        log.error("Bad request:Invalid User");
        return ResponseEntity.badRequest().body(new MessageResponse(ie.getMessage(), HttpStatus.UNAUTHORIZED));
    }

    @ExceptionHandler(MicroserviceException.class)
    public ResponseEntity<MessageResponse> handleMicroserviceException(MicroserviceException ex){
        log.error("error in a microservice");
        return new ResponseEntity<MessageResponse>(new MessageResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}