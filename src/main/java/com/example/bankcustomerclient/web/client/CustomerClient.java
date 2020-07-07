package com.example.bankcustomerclient.web.client;

import com.example.bankcustomerclient.web.model.Customer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@ConfigurationProperties(prefix="bank.customer",ignoreUnknownFields = false)
@Component
public class CustomerClient {
    private final String Customer_PATH_V1 = "/api/v1/customer/";

    private String apihost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
    public Customer getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost+Customer_PATH_V1+uuid.toString(),Customer.class);
    }
}
