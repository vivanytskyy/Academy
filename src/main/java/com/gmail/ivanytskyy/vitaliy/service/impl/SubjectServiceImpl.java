package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.SubjectRepository;
import com.gmail.ivanytskyy.vitaliy.service.SubjectService;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Task #3/2015/12/14 (web project #3)
 * SubjectServiceImpl class
 * @version 1.01 2015.12.14
 * @author Vitaliy Ivanytskyy
 */
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	private static final Logger log = Logger.getLogger(SubjectServiceImpl.class);
	@Override
	public Subject create(Subject subject){
		log.info("Creating subject with subjectName = " + subject.getName());
		Subject newSubject = subjectRepository.create(subject);
		log.trace("Subject with subjectName = " + newSubject.getName() + " was created");
		return newSubject;
	}
	@Override
	public Subject findById(long id){
		log.info("Getting subject by subjectId = " + id);
		Subject subject = subjectRepository.findById(id);
		log.trace("Subject was gotten");
		return subject;
	}
	@Override
	public List<Subject> findByName(String name){
		log.info("Getting subjects by subjectName = " + name);
		List<Subject> subjects = subjectRepository.findByName(name);
		log.trace("Subjects were gotten");
		return subjects;
	}
	@Override
	public List<Subject> findAll(){
		log.info("Getting all subjects");
		List<Subject> subjects = subjectRepository.findAll();
		log.trace("Subjects were gotten");
		return subjects;
	}
	@Override
	public boolean isExistsWithName(String name) {
		return subjectRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		log.info("Remove subject by subjectId = " + id);
		subjectRepository.deleteById(id);
		log.trace("Subject with subjectId = " + id + " was removed");
	}
}