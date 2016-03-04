package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Service interface for controllers which need a point of entry to StudentRepository
 * @author Vitaliy Ivanytskyy
 */
public interface StudentService {
	Student create(Student student);
	Student findById(long id);
	List<Student> findByName(String name);
	List<Student> findByGroupId(long groupId);
	List<Student> findAll();
	void deleteById(long id);	
}