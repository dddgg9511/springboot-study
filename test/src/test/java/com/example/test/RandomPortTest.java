package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomPortTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SampleService sampleservice;

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void hello() throws Exception{
        when(sampleservice.getName()).thenReturn("choo");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello choo");
    }

    @Test
    public void WebTestClientTest(){
        when(sampleservice.getName()).thenReturn("choo");
        webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello choo");
    }
}
