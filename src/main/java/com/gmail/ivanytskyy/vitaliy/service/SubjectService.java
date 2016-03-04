package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Service interface for controllers which need a point of entry to SubjectRepository
 * @author Vitaliy Ivanytskyy
 */
public interface SubjectService {
	Subject create(Subject subject);
	Subject findById(long id);
	List<Subject> findByName(String name);
	List<Subject> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);
}