package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleItemService;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Implementation of the {@link ScheduleItemService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleItemService")
@Transactional
public class ScheduleItemServiceImpl implements ScheduleItemService {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleItemServiceImpl.class);
	@Autowired
	private ScheduleItemRepository scheduleItemRepository;
	@Override
	public ScheduleItem create(ScheduleItem scheduleItem){
		logger.debug("Create the schedule item with:"
				+ " schedule (id={}), classroom (id={}),"
				+ " lecturer(id={}), group (id={}),"
				+ " subject (id={}), lessonInterval (id={})",
				scheduleItem.getSchedule().getId(), scheduleItem.getClassroom().getId(),
				scheduleItem.getLecturer().getId(), scheduleItem.getGroup().getId(),
				scheduleItem.getSubject().getId(), scheduleItem.getLessonInterval().getId());
		return scheduleItemRepository.create(scheduleItem);
	}
	@Override
	public ScheduleItem findById(long id){
		logger.debug("Find the schedule item by id = {}", id);
		return scheduleItemRepository.findById(id);
	}
	@Override
	public List<ScheduleItem> findByScheduleId(long scheduleId) {
		logger.debug("Find the schedule item by scheduleId = {}", scheduleId);
		return scheduleItemRepository.findByScheduleId(scheduleId);
	}
	@Override
	public List<ScheduleItem> findAll(){
		logger.debug("Find all schedule items");
		return scheduleItemRepository.findAll();
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the schedule item by id = {}", id);
		scheduleItemRepository.deleteById(id);
	}
}