package io.github.llmagentbuilder.example.chineseidiomsgame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  public IdiomsChatHistoryCustomizer idiomsChatHistoryCustomizer() {
    return new IdiomsChatHistoryCustomizer();
  }
}
