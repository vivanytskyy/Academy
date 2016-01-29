package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
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
	@Autowired
	private ClassroomRepository classroomRepository;
	@Override
	public Classroom create(Classroom classroom) {
		return classroomRepository.create(classroom);		
	}
	@Override	
	public Classroom findById(long id){
		return classroomRepository.findById(id);
	}
	@Override
	public List<Classroom> findByName(String name){
		return classroomRepository.findByName(name);
	}
	@Override
	public List<Classroom> findAll(){
		return classroomRepository.findAll();
	}
	@Override
	public void deleteById(long id){
		classroomRepository.deleteById(id);
	}
	@Override
	public boolean isExistsWithName(String name) {		
		return classroomRepository.isExistsWithName(name);
	}
}