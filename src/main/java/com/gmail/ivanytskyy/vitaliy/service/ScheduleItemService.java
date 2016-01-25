package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Task #4/2016/01/03 (web project #4)
 * ScheduleItemService interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleItemService {
	public ScheduleItem create(ScheduleItem scheduleItem);
	public ScheduleItem findById(long id);
	public List<ScheduleItem> findByScheduleId(long scheduleId);
	public List<ScheduleItem> findAll();
	public void deleteById(long id);
}