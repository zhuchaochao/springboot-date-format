package com.zcc.microservice.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class DateTimeConverter {

	@Bean
	public Converter<String, Date> formatDate() {
		return new String2DateConverter();
	}
	
	@Bean
	public Converter<String, LocalDate> formatLocalDate() {
		return new String2LocalDateConverter();
	}
	
	@Bean
	public Converter<String, LocalDateTime> formatLocalDateTime() {
		return new String2LocalDateTimeConverter();
	}
}
