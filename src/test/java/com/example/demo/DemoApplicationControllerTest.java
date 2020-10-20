package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(restTemplate.getForEntity("http://localhost:" + port + "/test",
                CollectionModel.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(SpringDataRestConfig.entityModelDemoEntityCounter).isEqualTo(3);
        assertThat(SpringDataRestConfig.collectionModelDemoEntityCounter).isEqualTo(1);
        assertThat(SpringDataRestConfig.entityModelSecondEntityCounter).isEqualTo(0);
        assertThat(SpringDataRestConfig.collectionModelSecondEntityCounter).isEqualTo(0);
    }
}
