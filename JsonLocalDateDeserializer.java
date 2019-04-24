package com.zcc.microservice.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class JsonLocalDateDeserializer extends JsonDeserializer<LocalDate>{

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String source = p.getText();
		try
	    {
	      String[] dateStrArr = source.split(" ");
	      if (dateStrArr.length > 1)
	      {
	        source = dateStrArr[0];
	      }
	      else
	      {
	        String[] hsmArr = source.split("-");
	        if (hsmArr.length == 1) {
	          source = source + "-01-01";
	        } else if (hsmArr.length == 2) {
	          source = source + "-01";
	        }
	      }
	      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      return LocalDate.parse(source, df);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	}
	
}
