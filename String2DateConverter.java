package com.zcc.microservice.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

public class String2DateConverter implements Converter<String, Date>{
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
	
	  @Nullable
	  public Date convert(String source){
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
