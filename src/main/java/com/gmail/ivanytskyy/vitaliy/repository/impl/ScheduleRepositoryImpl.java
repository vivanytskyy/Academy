package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleRepository;
/*
 * JPA implementation of the {@link ScheduleRepository} interface.
 * @author Vitaliy Ivanytskyy
 */
@Repository("scheduleRepository")
public class ScheduleRepositoryImpl implements ScheduleRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Schedule create(Schedule schedule) {
		if(schedule.getId() == null){
			entityManager.persist(schedule);
		}else{
			entityManager.merge(schedule);
		}
		entityManager.flush();
		return schedule;
	}
	@Override
	public Schedule findById(long id) {
		return entityManager.find(Schedule.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> findByDate(Date scheduleDate) {
		return entityManager.createQuery(
				"SELECT s FROM Schedule s WHERE s.timeStamp=:timestamp")
				.setParameter("timestamp", scheduleDate)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> findAll() {
		return entityManager.createQuery(
				"SELECT s FROM Schedule s")
				.getResultList();
	}
	@Override
	public boolean isExistsWithDate(Date timeStamp) {
		long result = (long) entityManager.createQuery(
				"SELECT COUNT(s) FROM Schedule s WHERE s.timeStamp=:timestamp")
				.setParameter("timestamp", timeStamp)
				.getSingleResult();
		return result > 0;
	}
	@Override
	public void deleteById(long id) {
		Schedule schedule = findById(id);
		entityManager.remove(schedule);
	}
}