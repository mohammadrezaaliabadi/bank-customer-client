package com.example.bankcustomerclient.web.client;

import com.example.bankcustomerclient.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    void saveCustomer(){
        Customer customer = Customer.builder().name("Ali").build();
        URI uri = client.saveCustomer(customer);
        System.out.println(uri);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void putCustomer(){
        Customer customer = Customer.builder().name("Ali").build();
        client.updateCustomer(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());

    }


}