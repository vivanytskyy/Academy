package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
@Repository("scheduleItemRepository")
public class ScheduleItemRepositoryImpl implements ScheduleItemRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public ScheduleItem create(ScheduleItem scheduleItem) {
		if(scheduleItem.getId() == null){
			entityManager.persist(scheduleItem);
		}else{
			entityManager.merge(scheduleItem);
		}
		entityManager.flush();
		return scheduleItem;
	}
	@Override
	public ScheduleItem findById(long id) {
		return entityManager.find(ScheduleItem.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findByScheduleId(long scheduleId) {
		return entityManager.createQuery(
				"SELECT si FROM ScheduleItem si WHERE si.schedule_id=:id")
				.setParameter("id", scheduleId)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findAll() {
		return entityManager.createQuery("SELECT si FROM ScheduleItem si").getResultList();
	}
	@Override
	public void deleteById(long id) {
		ScheduleItem scheduleItem = findById(id);
		System.out.println("id (from repository) = " + scheduleItem.getId());
		entityManager.remove(scheduleItem);
	}
}