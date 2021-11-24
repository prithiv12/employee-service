package com.example.EmployeeService.client;

import com.example.EmployeeService.entity.EmployeeOffers;
import com.example.EmployeeService.entity.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "${offer.feign.client}", name = "${offer.feign.name}")
public interface OfferClient {

    @GetMapping("/getOffers/{emp_id}")
    public List<EmployeeOffers> getOffersById(@RequestHeader(name = "Authorization", required = true) String token,
                                              @PathVariable("emp_id") Integer id);

    @GetMapping("/getOfferDetails/{offer_id}")
    public EmployeeOffers getOfferDetailsById(@RequestHeader(name = "Authorization") String token,
                                              @PathVariable("offer_id") Integer id);

    @PostMapping("/updateLikes/{offer_id}")
    public MessageResponse updateLikes(@RequestHeader(name = "Authorization") String token,
                                       @PathVariable("offer_id") Integer id);
    
    @GetMapping("/getRecentlyLikedOffers")
    public List<EmployeeOffers> getRecentlyLikedOffers(@RequestHeader(name = "Authorization") String token);
}