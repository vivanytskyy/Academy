package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.repository.ClassroomRepository;
@Repository("classroomRepository")
public class ClassroomRepositoryImpl implements ClassroomRepository {
	@PersistenceContext
	private EntityManager entityManager;	
	@Override
	public Classroom create(Classroom classroom) {
		if (classroom.getId() == null) {
			entityManager.persist(classroom);
        } else {
        	entityManager.merge(classroom);
        }
		entityManager.flush();
		return classroom;
	}
	@Override
	public Classroom findById(long id) {
		Classroom classroom = entityManager.find(Classroom.class, id);
		return classroom;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> findByName(String name) {
		return entityManager.createQuery(
				"SELECT c FROM Classroom c WHERE c.name=:name")
				.setParameter("name", name)
				.getResultList();
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Classroom> findAll() {
		Query query = entityManager.createQuery("Select g from Classroom g");
		List classrooms = query.getResultList();
		return classrooms;
	}
	@Override
	public boolean isExistsWithName(String name) {
		long result = (long) entityManager.createQuery
				("SELECT COUNT(c) FROM Classroom c WHERE c.name=:name")
				.setParameter("name", name)
				.getSingleResult();
		return result > 0;
	}
	@Override
	public void deleteById(long id) {
		Classroom classroom = findById(id);
		entityManager.remove(classroom);		
	}	
}