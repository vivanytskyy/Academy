package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Task #4/2016/01/03 (web project #4)
 * SubjectService interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface SubjectService {
	public Subject create(Subject subject);
	public Subject findById(long id);
	public List<Subject> findByName(String name);
	public List<Subject> findAll();
	public boolean isExistsWithName(String name);
	public void deleteById(long id);
}