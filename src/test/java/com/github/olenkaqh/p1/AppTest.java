package com.github.olenkaqh.p1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringJUnitConfig(classes = AppConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {
    @Autowired
    ApplicationContext context;

    WebTestClient rest;
    //NOT WORKING
    @BeforeAll
    public void setup(){
        this.rest = WebTestClient
                .bindToApplicationContext(this.context)
                .configureClient()
                .build();
    }

    //NOT WORKING
    @Test
    public void getAllUsersOK() throws Exception {
        this.rest
                .get()
                .uri("/users")
                .exchange()
                .expectStatus().isOk();
    }
}
