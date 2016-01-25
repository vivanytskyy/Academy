package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Task #4/2016/01/03 (web project #4)
 * ClassroomService interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface ClassroomService {
	public Classroom create(Classroom classroom);
	public Classroom findById(long id);
	public List<Classroom> findByName(String name);
	public List<Classroom> findAll();
	public void deleteById(long id);	
	public boolean isExistsWithName(String name);
}