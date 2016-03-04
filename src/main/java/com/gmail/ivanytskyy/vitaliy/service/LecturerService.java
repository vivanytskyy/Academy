package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Service interface for controllers which need a point of entry to LecturerRepository
 * @author Vitaliy Ivanytskyy
 */
public interface LecturerService {
	Lecturer create(Lecturer lecturer);
	Lecturer findById(long id);
	List<Lecturer> findByName(String name);
	List<Lecturer> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);	
}