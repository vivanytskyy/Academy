package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
import com.gmail.ivanytskyy.vitaliy.repository.SubjectRepository;
/*
 * JPA implementation of the {@link SubjectRepository} interface.
 * @author Vitaliy Ivanytskyy
 */
@Repository("subjectRepository")
public class SubjectRepositoryImpl implements SubjectRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Subject create(Subject subject) {
		if(subject.getId() == null){
			entityManager.persist(subject);
		}else{
			entityManager.merge(subject);
		}
		entityManager.flush();
		return subject;
	}
	@Override
	public Subject findById(long id) {
		return entityManager.find(Subject.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findByName(String name) {
		return entityManager.createQuery(
				"SELECT s FROM Subject s WHERE s.name=:name")
				.setParameter("name", name)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findAll() {		
		return entityManager.createQuery(
				"SELECT s FROM Subject s")
				.getResultList();
	}
	@Override
	public boolean isExistsWithName(String name) {
		long result = (long) entityManager.createQuery(
				"SELECT COUNT(s) FROM Subject s WHERE s.name=:name")
				.setParameter("name", name)
				.getSingleResult();
		return result > 0;
	}
	@Override
	public void deleteById(long id) {
		Subject subject = findById(id);
		entityManager.remove(subject);
	}
}