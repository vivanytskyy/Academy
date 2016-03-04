package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Service interface for controllers which need a point of entry to ScheduleItemRepository
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleItemService {
	ScheduleItem create(ScheduleItem scheduleItem);
	ScheduleItem findById(long id);
	List<ScheduleItem> findByScheduleId(long scheduleId);
	List<ScheduleItem> findAll();
	void deleteById(long id);
}