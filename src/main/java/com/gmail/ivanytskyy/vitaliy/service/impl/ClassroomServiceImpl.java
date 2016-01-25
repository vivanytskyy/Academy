package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.ivanytskyy.vitaliy.repository.ClassroomRepository;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Task #4/2016/01/03 (web project #4)
 * ClassroomServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomRepository classroomRepository;
	private static final Logger log = Logger.getLogger(ClassroomServiceImpl.class);
	public void setClassroomRepository(ClassroomRepository classroomRepository){
		this.classroomRepository = classroomRepository;
	}
	@Override
	public Classroom create(Classroom classroom) {
		return classroomRepository.create(classroom);		
	}
	@Override	
	public Classroom findById(long id){
		log.info("Getting classroom by classroomId = " + id);		
		Classroom classroom = classroomRepository.findById(id);
		log.trace("Classroom was gotten");
		return classroom;
	}
	@Override
	public List<Classroom> findByName(String name){
		log.info("Getting classrooms by classroomName = " + name);
		List<Classroom> classrooms = classroomRepository.findByName(name);
		log.trace("Classrooms were gotten");
		return classrooms;
	}
	@Override
	public List<Classroom> findAll(){
		log.info("Getting all classrooms");
		List<Classroom> classrooms = classroomRepository.findAll();
		log.trace("Classrooms were gotten");
		return classrooms;
	}
	@Override
	public void deleteById(long id){
		log.info("Remove classroom by classroomId = " + id);
		classroomRepository.deleteById(id);
		log.trace("Classroom with classroomId = " + id + " was removed");
	}
	@Override
	public boolean isExistsWithName(String name) {		
		return classroomRepository.isExistsWithName(name);
	}
}