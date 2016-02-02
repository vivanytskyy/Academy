package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Implementation of the {@link ScheduleService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Override
	public Schedule create(Schedule schedule){
		logger.debug("Create the schedule with timeStamp = {}", schedule.getTimeStamp());
		return scheduleRepository.create(schedule);
	}
	@Override
	public Schedule findById(long id){
		logger.debug("Find the schedule by id = {}", id);
		return scheduleRepository.findById(id);
	}
	@Override
	public List<Schedule> findByDate(Date scheduleDate){
		logger.debug("Find the schedule by timeStamp = {}", scheduleDate);
		return scheduleRepository.findByDate(scheduleDate);
	}
	@Override
	public List<Schedule> findAll(){
		logger.debug("Find all schedules");
		return scheduleRepository.findAll();
	}
	@Override
	public boolean isExistsWithDate(Date timeStamp) {
		logger.debug("Check if is exists the schedule with timeStamp = {}", timeStamp);
		return scheduleRepository.isExistsWithDate(timeStamp);
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the schedule by id = {}", id);
		scheduleRepository.deleteById(id);
	}
}