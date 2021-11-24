package com.example.EmployeeService.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OfferClientTest {

    private OfferClient offerClient;


    @Test
    @DisplayName("Checking if [OfferClient] is loading or not.")
    void packagingClientIsLoaded(){
        assertThat(offerClient).isNull();
    }
}