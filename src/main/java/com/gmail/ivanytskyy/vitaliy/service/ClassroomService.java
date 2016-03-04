package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Service interface for controllers which need a point of entry to ClassroomRepository
 * @author Vitaliy Ivanytskyy
 */
public interface ClassroomService {
	Classroom create(Classroom classroom);
	Classroom findById(long id);
	List<Classroom> findByName(String name);
	List<Classroom> findAll();
	void deleteById(long id);	
	boolean isExistsWithName(String name);
}