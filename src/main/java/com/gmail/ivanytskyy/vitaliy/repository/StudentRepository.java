package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Repository interface for Student domain objects
 * @author Vitaliy Ivanytskyy
 */
public interface StudentRepository {
	Student create(Student student);
	Student findById(long id);
	List<Student> findByGroupId(long id);
	List<Student> findByName(String name);
	List<Student> findAll();
	void deleteById(long id);
}