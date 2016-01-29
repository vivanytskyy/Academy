package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Repository interface for Lecturer domain objects
 * @author Vitaliy Ivanytskyy
 */
public interface LecturerRepository {
	Lecturer create(Lecturer lecturer);
	Lecturer findById(long id);
	List<Lecturer> findByName(String name);
	List<Lecturer> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);
}