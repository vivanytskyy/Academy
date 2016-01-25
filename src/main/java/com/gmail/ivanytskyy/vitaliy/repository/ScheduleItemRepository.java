package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleItemRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleItemRepository {
	ScheduleItem create(ScheduleItem scheduleItem);
	ScheduleItem findById(long id);
	List<ScheduleItem> findByScheduleId(long scheduleId);
	List<ScheduleItem> findAll();
	void deleteById(long id);
}