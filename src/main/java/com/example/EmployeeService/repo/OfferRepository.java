package com.example.EmployeeService.repo;

import com.example.EmployeeService.entity.EmployeeOffers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<EmployeeOffers, Integer> {

}