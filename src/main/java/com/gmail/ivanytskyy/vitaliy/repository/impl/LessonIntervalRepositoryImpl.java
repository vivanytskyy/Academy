package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
import com.gmail.ivanytskyy.vitaliy.repository.LessonIntervalRepository;
@Repository("lessonIntervalRepository")
public class LessonIntervalRepositoryImpl implements LessonIntervalRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public LessonInterval create(LessonInterval lessonInterval) {
		if(lessonInterval.getId() == null){
			entityManager.persist(lessonInterval);
		}else{
			entityManager.merge(lessonInterval);
		}
		entityManager.flush();
		return lessonInterval;
	}
	@Override
	public LessonInterval findById(long id) {		
		return entityManager.find(LessonInterval.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LessonInterval> findAll() {		
		return entityManager.createQuery(
				"SELECT l FROM LessonInterval l")
				.getResultList();
	}
	@Override
	public void deleteById(long id) {
		LessonInterval lessonInterval = findById(id);
		entityManager.remove(lessonInterval);		
	}
}