package com.gmail.ivanytskyy.vitaliy.service;
import java.util.Date;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Service interface for controllers which need a point of entry to ScheduleRepository
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