package com.zcc.microservice.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class JsonLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>{

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String source = p.getText();
		try
	    {
	      String[] dateStrArr = source.split(" ");
	      if (dateStrArr.length == 1)
	      {
	        source = source.trim() + " 00:00:00";
	      }
	      else
	      {
	        String[] hsmArr = dateStrArr[1].split(":");
	        if (hsmArr.length == 1) {
	          source = source + ":00:00";
	        } else if (hsmArr.length == 2) {
	          source = source + ":00";
	        }
	      }
	      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	      return LocalDateTime.parse(source, df);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	}
	
}
