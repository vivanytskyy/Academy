package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	private static final Logger log = Logger.getLogger(ScheduleServiceImpl.class.getName());
	@Override
	public Schedule create(Schedule schedule){
		log.info("Creating schedule for scheduleDate = " + dateToString(schedule.getTimeStamp()));
		Schedule newSchedule = scheduleRepository.create(schedule);
		log.trace("Schedule was created");
		return newSchedule;
	}
	@Override
	public Schedule findById(long id){
		log.info("Getting schedule by scheduleId = " + id);
		Schedule schedule = scheduleRepository.findById(id);
		log.trace("Schedule was gotten");
		return schedule;
	}
	@Override
	public List<Schedule> findByDate(Date scheduleDate){
		log.info("Getting schedule by scheduleDate = " + dateToString(scheduleDate));
		List<Schedule> schedules = scheduleRepository.findByDate(scheduleDate);
		log.trace("Schedules were gotten");
		return schedules;
	}
	@Override
	public List<Schedule> findAll(){
		log.info("Getting all schedules");
		List<Schedule> schedules = scheduleRepository.findAll();
		log.trace("Schedules were gotten");
		return schedules;
	}
	@Override
	public boolean isExistsWithDate(Date timeStamp) {
		return scheduleRepository.isExistsWithDate(timeStamp);
	}
	@Override
	public void deleteById(long id){
		/*log.info("Remove schedule by scheduleId = " + id);
		log.trace("Try get information about scheduleItems of schedule "
				+ "with scheduleId = " + id);
		List<ScheduleItem> scheduleItems = scheduleItemRepository.findByScheduleId(id);
		log.trace("Information about scheduleItems of schedule "
				+ "with scheduleId = " + id + " was gotten");
		if(scheduleItems.isEmpty()){
			log.trace("Remove schedule with scheduleId = " + id);
			scheduleRepository.deleteById(id);
			log.trace("Schedule with scheduleId = " + id + " was deleted");
		}else{
			log.trace("Can not delete schedule with the scheduleItems");
		}*/
		scheduleRepository.deleteById(id);
	}
	private String dateToString(Date timeStamp){
		Calendar date = new GregorianCalendar();
		date.setTime(timeStamp);
		return date.get(Calendar.DAY_OF_MONTH) + 
				"/" + (date.get(Calendar.MONTH) + 1) + 
				"/" + date.get(Calendar.YEAR);
	}
}