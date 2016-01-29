package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Service interface for controllers which need a point of entry to StudentRepository
 * @author Vitaliy Ivanytskyy
 */
public interface StudentService {
	public Student create(Student student);
	public Student findById(long id);
	public List<Student> findByName(String name);
	public List<Student> findByGroupId(long groupId);
	public List<Student> findAll();
	public void deleteById(long id);	
}