package com.tdep.tadlab.backendservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
  @GetMapping("/")
  public String index() {
    return "This is a string, you dolt.";
  }
}
