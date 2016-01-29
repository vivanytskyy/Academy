package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
/*
 * JPA implementation of the {@link ScheduleItemRepository} interface.
 * @author Vitaliy Ivanytskyy
 */
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
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findScheduleByClassroom(Schedule schedule,
			Classroom classroom) {
		return entityManager.createQuery(
				"SELECT si FROM ScheduleItem si WHERE si.schedule.id=:scheduleId AND si.classroom.id=:classroomId")
				.setParameter("scheduleId", schedule.getId())
				.setParameter("classroomId", classroom.getId())
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findScheduleByLecturer(Schedule schedule,
			Lecturer lecturer) {
		return entityManager.createQuery(
				"SELECT si FROM ScheduleItem si WHERE si.schedule.id=:scheduleId AND si.lecturer.id=:lecturerId")
				.setParameter("scheduleId", schedule.getId())
				.setParameter("lecturerId", lecturer.getId())
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleItem> findScheduleByGroup(Schedule schedule, Group group) {
		return entityManager.createQuery(
				"SELECT si FROM ScheduleItem si WHERE si.schedule.id=:scheduleId AND si.group.id=:groupId")
				.setParameter("scheduleId", schedule.getId())
				.setParameter("groupId", group.getId())
				.getResultList();
	}	
}