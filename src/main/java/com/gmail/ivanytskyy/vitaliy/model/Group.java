package com.gmail.ivanytskyy.vitaliy.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
/*
 * Simple JavaBean domain object representing a group
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "groups")
public class Group implements Comparable<Group>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@OneToMany(mappedBy = "group", orphanRemoval=true, fetch = FetchType.LAZY)
	private Set<Student> students = new HashSet<Student>();
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
	@Override
	public int compareTo(Group o) {
		return name.compareTo(o.getName());
	}
}