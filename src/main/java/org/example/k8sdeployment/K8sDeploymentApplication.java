package org.example.k8sdeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class K8sDeploymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(K8sDeploymentApplication.class, args);
  }
}

@RestController
class DataController {

  @GetMapping("/data")
  String data() {
    return "data";
  }
}
