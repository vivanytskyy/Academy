package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Service interface for controllers which need a point of entry to ScheduleItemRepository
 * @author Vitaliy Ivanytskyy
 */
public interface ScheduleItemService {
	public ScheduleItem create(ScheduleItem scheduleItem);
	public ScheduleItem findById(long id);
	public List<ScheduleItem> findByScheduleId(long scheduleId);
	public List<ScheduleItem> findAll();
	public void deleteById(long id);
}