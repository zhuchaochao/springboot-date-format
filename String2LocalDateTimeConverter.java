package com.zcc.microservice.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class String2LocalDateTimeConverter implements Converter<String, LocalDateTime>{
	  @Nullable
	  public LocalDateTime convert(String source){
	    try{
	      String[] dateStrArr = source.split(" ");
	      if (dateStrArr.length == 1){
	        source = source.trim() + " 00:00:00";
	      }else{
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
	    catch (Exception e){
	      e.printStackTrace();
	    }
	    return null;
	}
}