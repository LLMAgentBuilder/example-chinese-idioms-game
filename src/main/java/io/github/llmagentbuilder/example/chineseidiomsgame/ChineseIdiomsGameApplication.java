package io.github.llmagentbuilder.example.chineseidiomsgame;

import io.github.llmagentbuilder.spring.dev.AgentDevConfiguration;
import io.github.llmagentbuilder.spring.spring.agentcontroller.AgentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AgentDevConfiguration.class, AgentController.class})
public class ChineseIdiomsGameApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChineseIdiomsGameApplication.class, args);
  }
}
