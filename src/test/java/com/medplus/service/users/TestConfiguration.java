package com.medplus.service.users;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {
    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }
}
