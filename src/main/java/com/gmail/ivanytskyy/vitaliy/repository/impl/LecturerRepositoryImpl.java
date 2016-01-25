package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.repository.LecturerRepository;
@Repository("lecturerRepository")
public class LecturerRepositoryImpl implements LecturerRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Lecturer create(Lecturer lecturer) {
		if(lecturer.getId() == null){
			entityManager.persist(lecturer);
		}else{
			entityManager.merge(lecturer);
		}
		entityManager.flush();
		return lecturer;
	}
	@Override
	public Lecturer findById(long id) {
		Lecturer lecturer = entityManager.find(Lecturer.class, id);
		return lecturer;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Lecturer> findByName(String name) {		
		return entityManager.createQuery(
				"SELECT l FROM Lecturer l WHERE l.name=:name")
				.setParameter("name", name)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Lecturer> findAll() {		
		return entityManager.createQuery(
				"SELECT l FROM Lecturer l")
				.getResultList();
	}
	@Override
	public boolean isExistsWithName(String name) {
		Long result = (long) entityManager.createQuery(
				"SELECT COUNT(l) FROM Lecturer l WHERE l.name=:name")
				.setParameter("name", name)				
				.getSingleResult();
		return result > 0;
	}
	@Override
	public void deleteById(long id) {
		Lecturer lecturer = findById(id);
		entityManager.remove(lecturer);
	}
}