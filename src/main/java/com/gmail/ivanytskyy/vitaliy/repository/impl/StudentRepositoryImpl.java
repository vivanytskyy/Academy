package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Student;
import com.gmail.ivanytskyy.vitaliy.repository.StudentRepository;
/*
 * JPA implementation of the {@link StudentRepository} interface.
 * @author Vitaliy Ivanytskyy
 */
@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Student create(Student student) {
		if(student.getId() == null){
			entityManager.persist(student);
		}else{
			entityManager.merge(student);
		}
		entityManager.flush();
		return student;
	}
	@Override
	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByGroupId(long id) {
		return entityManager.createQuery(
				"SELECT s FROM Student s WHERE s.group_id=:id")
				.setParameter("id", id)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByName(String name) {
		return entityManager.createQuery(
				"SELECT s FROM Student s WHERE s.name=:name").
				setParameter("name", name)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		return entityManager.createQuery(
				"SELECT s FROM Student s")
				.getResultList();
	}
	@Override
	public void deleteById(long id) {
		Student student = findById(id);
		System.out.println(student.getName());
		entityManager.remove(student);
	}
}