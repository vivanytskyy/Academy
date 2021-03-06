package com.gmail.ivanytskyy.vitaliy.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
/*
 * Simple JavaBean domain object representing a lecturer
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "lecturers")
public class Lecturer implements Comparable<Lecturer>{
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
	public int compareTo(Lecturer o) {
		return name.compareTo(o.getName());
	}
}