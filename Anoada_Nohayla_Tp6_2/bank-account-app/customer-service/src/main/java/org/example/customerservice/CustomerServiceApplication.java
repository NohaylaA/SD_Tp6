package org.example.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository)
    {
        return args -> {
            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("Hiba")
                            .lastName("salmi")
                            .email("hibasalmi@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Mohammed")
                            .lastName("arabi")
                            .email("arabimohammed@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
