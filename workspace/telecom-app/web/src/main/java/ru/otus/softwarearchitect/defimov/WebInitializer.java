package ru.otus.softwarearchitect.defimov;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "ru.otus.softwarearchitect.defimov")
@PropertySource(value = {"classpath:application.properties", "classpath:datasource.properties"})
class WebInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebInitializer.class);
	}

	@Bean
	RestTemplate restTemplate(ClientHttpRequestInterceptor loggingRequestInterceptor) {
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new
				SimpleClientHttpRequestFactory()));

		final List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(loggingRequestInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
}
