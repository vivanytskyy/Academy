package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Task #4/2016/01/03 (web project #4)
 * LecturerRepository interface
 * @version 1.01 2016.01.03
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