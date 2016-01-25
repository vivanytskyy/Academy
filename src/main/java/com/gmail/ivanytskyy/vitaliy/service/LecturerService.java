package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Task #4/2016/01/03 (web project #4)
 * LecturerService interface
 * @version 1.01 2016.01.03
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