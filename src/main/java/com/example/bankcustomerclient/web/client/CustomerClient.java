package com.example.bankcustomerclient.web.client;

import com.example.bankcustomerclient.web.model.Customer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix="bank.customer",ignoreUnknownFields = false)
@Component
public class CustomerClient {
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apihost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
    public Customer getCustomerById(UUID customerId){
        return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+customerId.toString(),Customer.class);
    }

    public URI saveCustomer(Customer customer){
        return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1,customer);
    }

    public void updateCustomer(UUID customerId,Customer customer){
        restTemplate.put(apihost + CUSTOMER_PATH_V1+customerId.toString(),customer);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 +customerId.toString());
    }
}
