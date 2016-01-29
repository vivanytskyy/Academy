package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Service interface for controllers which need a point of entry to SubjectRepository
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