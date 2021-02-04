package com.example.fsm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("FieldCanBeLocal")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    private final String prefix = "http://localhost:";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void homeShouldReturnDefaultMessage() {
        assertThat(
                this.restTemplate
                        .getForObject(prefix + port + "/", String.class)
                        .contains("home")
        );
    }

}
