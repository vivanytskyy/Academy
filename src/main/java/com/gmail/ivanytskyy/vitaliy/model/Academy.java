package com.gmail.ivanytskyy.vitaliy.model;
import org.springframework.stereotype.Component;
/*
 * Task #4/2016/01/09 (web project #4)
 * Academy class
 * @version 1.01 2016.01.09
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