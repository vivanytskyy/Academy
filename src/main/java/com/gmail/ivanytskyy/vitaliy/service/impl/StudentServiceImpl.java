package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
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
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student create(Student student) {		
		return studentRepository.create(student);
	}
	@Override
	public Student findById(long id){
		return studentRepository.findById(id);
	}
	@Override
	public List<Student> findByName(String name){
		return studentRepository.findByName(name);
	}
	@Override
	public List<Student> findByGroupId(long groupId){
		return studentRepository.findByGroupId(groupId);
	}
	@Override
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	@Override
	public void deleteById(long id){
		studentRepository.deleteById(id);
	}
}