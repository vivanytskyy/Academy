package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.Date;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleRepository {
	Schedule create(Schedule schedule);
	Schedule findById(long id);
	List<Schedule> findByDate(Date scheduleDate);
	List<Schedule> findAll();
	boolean isExistsWithDate(Date timeStamp);
	void deleteById(long id);	
}