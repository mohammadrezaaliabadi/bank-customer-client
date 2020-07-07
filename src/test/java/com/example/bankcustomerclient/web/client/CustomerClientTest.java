package com.example.bankcustomerclient.web.client;

import com.example.bankcustomerclient.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        Customer customer = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }
}