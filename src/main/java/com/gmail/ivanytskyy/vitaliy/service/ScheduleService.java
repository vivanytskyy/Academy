package com.gmail.ivanytskyy.vitaliy.service;
import java.util.Date;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleService interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleService {
	public Schedule create(Schedule schedule);
	public Schedule findById(long id);
	public List<Schedule> findByDate(Date scheduleDate);
	public List<Schedule> findAll();
	public boolean isExistsWithDate(Date timeStamp);
	public abstract void deleteById(long id);
}