package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Service interface for controllers which need a point of entry to LecturerRepository
 * @author Vitaliy Ivanytskyy
 */
public interface LecturerService {
	public Lecturer create(Lecturer lecturer);
	public Lecturer findById(long id);
	public List<Lecturer> findByName(String name);
	public List<Lecturer> findAll();
	public boolean isExistsWithName(String name);
	public void deleteById(long id);	
}