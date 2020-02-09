package ru.otus.softwarearchitect.defimov;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ContextConfigurator {
	@Value("${app.context}")
	private String contextPath;

	@Bean
	WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
	webServerFactoryCustomizer() {
		return factory -> factory.setContextPath("/" + contextPath);
	}
}
