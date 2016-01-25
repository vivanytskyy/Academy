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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ScheduleItem> findByScheduleId(long scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findAll() {
		return entityManager.createQuery("SELECT si FROM ScheduleItem si").getResultList();
	}
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
}