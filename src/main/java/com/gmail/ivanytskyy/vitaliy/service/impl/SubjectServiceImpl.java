package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
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
	@Autowired
	private SubjectRepository subjectRepository;
	@Override
	public Subject create(Subject subject){
		return subjectRepository.create(subject);
	}
	@Override
	public Subject findById(long id){
		return subjectRepository.findById(id);
	}
	@Override
	public List<Subject> findByName(String name){
		return subjectRepository.findByName(name);
	}
	@Override
	public List<Subject> findAll(){
		return subjectRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name) {
		return subjectRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		subjectRepository.deleteById(id);
	}
}