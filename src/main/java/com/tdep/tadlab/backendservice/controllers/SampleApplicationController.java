package com.tdep.tadlab.backendservice.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SampleApplicationController {
  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello World!";
  }
}
