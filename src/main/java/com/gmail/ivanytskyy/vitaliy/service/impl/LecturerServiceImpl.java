package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.LecturerRepository;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
/*
 * Task #4/2016/01/03 (web project #4)
 * LecturerServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("lecturerService")
@Transactional
public class LecturerServiceImpl implements LecturerService {
	@Autowired
	private LecturerRepository lecturerRepository;
	private static final Logger log = Logger.getLogger(LecturerServiceImpl.class);
	@Override
	public Lecturer create(Lecturer lecturer){
		log.info("Creating lecturer with lecturerName = " + lecturer.getName());
		Lecturer newLecturer = lecturerRepository.create(lecturer);
		log.trace("Lecturer was created");
		return newLecturer;
	}
	@Override
	public Lecturer findById(long id){
		log.info("Getting lecturer by lecturerId = " + id);
		Lecturer lecturer = lecturerRepository.findById(id);
		log.trace("Lecturer was gotten");
		return lecturer;
	}
	@Override
	public List<Lecturer> findByName(String name){
		log.info("Getting lecturers by lecturerName = " + name);
		List<Lecturer> lecturers = lecturerRepository.findByName(name);
		log.trace("Lecturers were gotten");
		return lecturers;
	}
	@Override
	public List<Lecturer> findAll(){
		log.info("Getting all lecturers");
		List<Lecturer> lecturers = lecturerRepository.findAll();
		log.trace("Lecturers were gotten");
		return lecturers;
	}
	@Override
	public boolean isExistsWithName(String name) {		
		return lecturerRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id) {
		log.info("Remove lecturer by lecturerId = " + id);
		lecturerRepository.deleteById(id);
		log.trace("Lecturer with lecturerId = " + id + " was removed");
	}
}