package com.tdep.tadlab.backendservice.it;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleControllerIT {

  @Autowired
  private TestRestTemplate template;

  @Test
  public void getHello() throws Exception {
    ResponseEntity<String> response = template.getForEntity("/", String.class);
    assertThat(response.getBody()).isEqualTo("This is a string, you dolt.");
  }
}
