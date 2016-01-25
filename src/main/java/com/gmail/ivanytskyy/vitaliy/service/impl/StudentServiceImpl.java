package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.StudentRepository;
import com.gmail.ivanytskyy.vitaliy.service.StudentService;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Task #4/2016/01/03 (web project #4)
 * StudentServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	private static final Logger log = Logger.getLogger(StudentServiceImpl.class);
	@Override
	public Student create(Student student) {		
		return studentRepository.create(student);
	}
	@Override
	public Student findById(long id){
		log.info("Getting student by studentId = " + id);
		Student student = studentRepository.findById(id);
		log.trace("Student was gotten");
		return student;
	}
	@Override
	public List<Student> findByName(String name){
		log.info("Getting students by studentName = " + name);
		List<Student> students = studentRepository.findByName(name);
		log.trace("Students were gotten");
		return students;
	}
	@Override
	public List<Student> findByGroupId(long groupId){
		log.info("Getting students of group with groupId = " + groupId);
		List<Student> students = studentRepository.findByGroupId(groupId);
		log.trace("Students were gotten");
		return students;
	}
	@Override
	public List<Student> findAll(){
		log.info("Getting all students");
		List<Student> students = studentRepository.findAll();
		log.trace("Students were gotten");
		return students;
	}
	@Override
	public void deleteById(long id){
		log.info("Remove student by studentId = " + id);
		studentRepository.deleteById(id);
		log.trace("Student with studentId = " + id + " was removed");
	}
}