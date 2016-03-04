package com.gmail.ivanytskyy.vitaliy.service;
import java.util.Date;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Service interface for controllers which need a point of entry to ScheduleRepository
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleService {
	Schedule create(Schedule schedule);
	Schedule findById(long id);
	List<Schedule> findByDate(Date scheduleDate);
	List<Schedule> findAll();
	boolean isExistsWithDate(Date timeStamp);
	abstract void deleteById(long id);
}