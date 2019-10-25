package com.aphelion;

import com.aphelion.pojo.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);
	private static Wrapper rt;
	@Value("${api_key}")
	private String key;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			rt = restTemplate.getForObject(
					"https://api.nasa.gov/insight_weather/?api_key=" + key +
							"&feedtype=json&ver=1.0", Wrapper.class);
		};
	}

	public static Wrapper getWrapper() {
		return rt;
	}

}
