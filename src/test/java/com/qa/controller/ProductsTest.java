package com.qa.controller;

import com.qa.controllers.HomeController;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;