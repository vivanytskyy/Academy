package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Task #4/2016/01/03 (web project #4)
 * ClassroomRepository interface
 * @version 1.01 2016.01.03
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