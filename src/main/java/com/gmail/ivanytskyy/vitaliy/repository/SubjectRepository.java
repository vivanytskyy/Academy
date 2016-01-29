package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Repository interface for Subject domain objects
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