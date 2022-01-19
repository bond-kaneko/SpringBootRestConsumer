package com.example.springbootrestconsumer;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.springbootrestconsumer.consumingrest.Quote;

@SpringBootApplication
public class SpringBootRestConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootRestConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("http://localhost:3000/quotes", Quote.class);
            log.info(Objects.requireNonNull(quote).toString());
        };
    }
}
