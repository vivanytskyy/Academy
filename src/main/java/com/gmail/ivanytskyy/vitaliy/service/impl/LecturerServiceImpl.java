package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.LecturerRepository;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Implementation of the {@link LecturerService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("lecturerService")
@Transactional
public class LecturerServiceImpl implements LecturerService {
	@Autowired
	private LecturerRepository lecturerRepository;
	@Override
	public Lecturer create(Lecturer lecturer){
		return lecturerRepository.create(lecturer);
	}
	@Override
	public Lecturer findById(long id){
		return lecturerRepository.findById(id);
	}
	@Override
	public List<Lecturer> findByName(String name){
		return lecturerRepository.findByName(name);
	}
	@Override
	public List<Lecturer> findAll(){
		return lecturerRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name) {		
		return lecturerRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id) {
		lecturerRepository.deleteById(id);
	}
}