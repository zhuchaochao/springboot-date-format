package com.zcc.microservice.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class String2LocalDateConverter implements Converter<String, LocalDate>
{
	  @Nullable
	  public LocalDate convert(String source){
	    try{
	      String[] dateStrArr = source.split(" ");
	      if (dateStrArr.length > 1){
	        source = dateStrArr[0];
	      }
	      else{
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
	    catch (Exception e){
	      e.printStackTrace();
	    }
	    return null;
	 }
}
