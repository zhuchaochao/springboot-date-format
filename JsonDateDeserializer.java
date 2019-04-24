package com.zcc.microservice.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class JsonDateDeserializer extends JsonDeserializer<Date>{
	private String[] parsePatterns = { 
			"yyyy-MM-dd HH:mm:ss", 
			"yyyy-MM-dd HH:mm", 
			"yyyy-MM-dd", 
			"yyyy-MM", 
			"yyyy/MM/dd HH:mm:ss", 
			"yyyy/MM/dd HH:mm", 
			"yyyy/MM/dd",
			"yyyy/MM", 
			"yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", 
			"yyyy.MM.dd", 
			"yyyy.MM",
			"yyyy"
		};
	
	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String source = p.getText();
		if (!StringUtils.isEmpty(source)) {
			for (String pattern : parsePatterns) {
				try {
					Date date = new SimpleDateFormat(pattern).parse(source);
					return date;
				} catch (Exception e) {
					continue;
				}
			}
		}
		return null;
	}
	
}
