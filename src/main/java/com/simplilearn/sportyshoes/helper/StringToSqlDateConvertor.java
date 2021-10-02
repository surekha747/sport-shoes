package com.simplilearn.sportyshoes.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.DozerConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to convert String format date to database format date and
 * vice-versa
 * 
 * @author Surekha 
 * @since 30-09-2021
 */
@Configuration
public class StringToSqlDateConvertor extends DozerConverter<String, Date> {

	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.sql.Date date=null;
	public StringToSqlDateConvertor() {
		super(String.class, Date.class);
	}

	@Override
	public Date convertTo(String source, Date destination) {
		try {
			destination = formatter.parse(source);
			 date= new java.sql.Date(destination.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String convertFrom(Date source, String destination) {
		String parseValue = null;
		if (null != source) {
			parseValue = formatter.format(source);
		}
		return parseValue;
	}

	
}
