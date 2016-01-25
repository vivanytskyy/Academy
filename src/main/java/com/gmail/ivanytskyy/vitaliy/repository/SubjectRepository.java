package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Task #4/2016/01/03 (web project #4)
 * SubjectRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface SubjectRepository {
	Subject create(Subject subject);
	Subject findById(long id);
	List<Subject> findByName(String name);
	List<Subject> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);
}