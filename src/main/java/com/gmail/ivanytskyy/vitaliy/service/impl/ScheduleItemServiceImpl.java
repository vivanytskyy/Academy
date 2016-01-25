package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleItemService;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleItemServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleItemService")
@Transactional
public class ScheduleItemServiceImpl implements ScheduleItemService {
	@Autowired
	private ScheduleItemRepository scheduleItemRepository;
	private static final Logger log = Logger.getLogger(ScheduleItemServiceImpl.class);
	@Override
	public ScheduleItem create(ScheduleItem scheduleItem){
		log.info("Creating new scheduleItem with"
				+ " groupId/lecturerId/classroomId/subjectId/lessonIntervalId/scheduleId = " 
				+ scheduleItem.getGroup().getId() + "/" 
				+ scheduleItem.getLecturer().getId() + "/" 
				+ scheduleItem.getClassroom().getId() + "/" 
				+ scheduleItem.getSubject().getId() + "/" 
				+ scheduleItem.getLessonInterval().getId() + "/" 
				+ scheduleItem.getSchedule().getId());
		ScheduleItem newScheduleItem = scheduleItemRepository.create(scheduleItem);
		log.trace("scheduleItem was created");
		return newScheduleItem;
	}
	@Override
	public ScheduleItem findById(long id){
		log.info("Getting scheduleItem by scheduleItemId = " + id);
		ScheduleItem scheduleItem = scheduleItemRepository.findById(id);
		log.trace("ScheduleItem was gotten");
		return scheduleItem;
	}
	@Override
	public List<ScheduleItem> findByScheduleId(long scheduleId) {
		log.info("Getting scheduleItems by scheduleId = " + scheduleId);
		List<ScheduleItem> scheduleItems = scheduleItemRepository.findByScheduleId(scheduleId);
		log.trace("scheduleItems were gotten");
		return scheduleItems;
	}
	@Override
	public List<ScheduleItem> findAll(){
		log.info("Getting all scheduleItems");
		List<ScheduleItem> scheduleItems = scheduleItemRepository.findAll();
		log.trace("ScheduleItems were gotten");
		return scheduleItems;
	}
	@Override
	public void deleteById(long id){
		log.info("Remove scheduleItem by scheduleItemId = " + id);
		scheduleItemRepository.deleteById(id);
		log.trace("ScheduleItem with scheduleItemId = " + id + " was removed");
	}
}