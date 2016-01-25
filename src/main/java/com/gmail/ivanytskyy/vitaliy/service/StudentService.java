package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Task #4/2016/01/03 (web project #4)
 * StudentService interface
 * @version 1.01 2016.01.03
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