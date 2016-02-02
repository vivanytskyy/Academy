package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.StudentRepository;
import com.gmail.ivanytskyy.vitaliy.service.StudentService;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Implementation of the {@link StudentService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student create(Student student) {
		logger.debug("Create the student with name = {}", student.getName());
		return studentRepository.create(student);
	}
	@Override
	public Student findById(long id){
		logger.debug("Find the student by id = {}", id);
		return studentRepository.findById(id);
	}
	@Override
	public List<Student> findByName(String name){
		logger.debug("Find the students by name = {}", name);
		return studentRepository.findByName(name);
	}
	@Override
	public List<Student> findByGroupId(long groupId){
		logger.debug("Find all students by groupId = {}", groupId);
		return studentRepository.findByGroupId(groupId);
	}
	@Override
	public List<Student> findAll(){
		logger.debug("Find all students");
		return studentRepository.findAll();
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the student by id = {}", id);
		studentRepository.deleteById(id);
	}
}