package com.demo.config;

import org.jooq.conf.RenderNameCase;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.RenderQuotedNames;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {

  @Bean
  public DefaultConfigurationCustomizer configurationCustomizer() {
    return configuration -> configuration.settings()
          .withRenderNameStyle(RenderNameStyle.LOWER)
          .withRenderNameCase(RenderNameCase.LOWER).withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED);

  }
}
