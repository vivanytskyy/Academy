package com.gmail.ivanytskyy.vitaliy.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
/*
 * Simple JavaBean domain object representing a classroom
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name="classrooms")
public class Classroom implements Comparable<Classroom>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Classroom o) {
		return name.compareTo(o.getName());
	}	
}