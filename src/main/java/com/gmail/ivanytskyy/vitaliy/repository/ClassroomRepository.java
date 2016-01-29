package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Repository interface for Classroom domain objects
 * @author Vitaliy Ivanytskyy
 */
public interface ClassroomRepository {
	Classroom create(Classroom classroom);
	Classroom findById(long id);
	List<Classroom> findByName(String name);
	List<Classroom> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);	
}