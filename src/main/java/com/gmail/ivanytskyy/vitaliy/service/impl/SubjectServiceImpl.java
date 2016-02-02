package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.SubjectRepository;
import com.gmail.ivanytskyy.vitaliy.service.SubjectService;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
/*
 * Implementation of the {@link SubjectService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);
	@Autowired
	private SubjectRepository subjectRepository;
	@Override
	public Subject create(Subject subject){
		logger.debug("Create the subject with name = {}", subject.getName());
		return subjectRepository.create(subject);
	}
	@Override
	public Subject findById(long id){
		logger.debug("Find the subject by id = {}", id);
		return subjectRepository.findById(id);
	}
	@Override
	public List<Subject> findByName(String name){
		logger.debug("Find the subject by name = {}", name);
		return subjectRepository.findByName(name);
	}
	@Override
	public List<Subject> findAll(){
		logger.debug("Find all subjects");
		return subjectRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name) {
		logger.debug("Check if is exists the subject with name = {}", name);
		return subjectRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the subject by id = {}", id);
		subjectRepository.deleteById(id);
	}
}