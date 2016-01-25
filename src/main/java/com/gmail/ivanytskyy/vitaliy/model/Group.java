package com.gmail.ivanytskyy.vitaliy.model;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/*
 * Task #4/2016/01/09 (web project #4)
 * Group class
 * @version 1.01 2016.01.09
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size
	private String name;
	@OneToMany(mappedBy = "group", orphanRemoval=true, /*cascade = CascadeType.ALL,*/ fetch = FetchType.EAGER)
	private Set<Student> students = new TreeSet<Student>();
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
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}