package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(LecturerServiceImpl.class);
	@Autowired
	private LecturerRepository lecturerRepository;
	@Override
	public Lecturer create(Lecturer lecturer){
		logger.debug("Create the lecturer with name = {}", lecturer.getName());
		return lecturerRepository.create(lecturer);
	}
	@Override
	public Lecturer findById(long id){
		logger.debug("Find the lecturer by id = {}", id);
		return lecturerRepository.findById(id);
	}
	@Override
	public List<Lecturer> findByName(String name){
		logger.debug("Find the lecturer by name = {}", name);
		return lecturerRepository.findByName(name);
	}
	@Override
	public List<Lecturer> findAll(){
		logger.debug("Find all lecturers");
		return lecturerRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name) {
		logger.debug("Check if is exists the lecturer with name = {}", name);
		return lecturerRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id) {
		logger.debug("Delete the lecturer by id = {}", id);
		lecturerRepository.deleteById(id);
	}
}