package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.Date;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Repository interface for Schedule domain objects
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