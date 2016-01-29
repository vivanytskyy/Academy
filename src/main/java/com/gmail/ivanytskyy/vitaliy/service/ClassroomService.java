package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Service interface for controllers which need a point of entry to ClassroomRepository
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