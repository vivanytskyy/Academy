package com.gmail.ivanytskyy.vitaliy.model;
import org.springframework.stereotype.Component;
/*
 * Simple JavaBean domain object representing an academy
 * @author Vitaliy Ivanytskyy
 */
@Component("academy")
public class Academy {
	private String name;
	public Academy(){
		this("Java EE Academy");
	}
	public Academy(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}