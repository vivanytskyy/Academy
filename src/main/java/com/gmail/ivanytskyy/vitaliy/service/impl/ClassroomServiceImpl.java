package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ClassroomRepository;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
/*
 * Implementation of the {@link ClassroomService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
	private static final Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);
	@Autowired
	private ClassroomRepository classroomRepository;
	@Override
	public Classroom create(Classroom classroom) {
		logger.debug("Create the classroom with name = {}", classroom.getName());
		return classroomRepository.create(classroom);		
	}
	@Override	
	public Classroom findById(long id){
		logger.debug("Find the classroom by id = {}", id);
		return classroomRepository.findById(id);
	}
	@Override
	public List<Classroom> findByName(String name){
		logger.debug("Find the classroom by name = {}", name);
		return classroomRepository.findByName(name);
	}
	@Override
	public List<Classroom> findAll(){
		logger.debug("Find all classrooms");
		return classroomRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name) {
		logger.debug("Check if is exists the classroom with name = {}", name);
		return classroomRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the classroom by id = {}", id);
		classroomRepository.deleteById(id);
	}
}