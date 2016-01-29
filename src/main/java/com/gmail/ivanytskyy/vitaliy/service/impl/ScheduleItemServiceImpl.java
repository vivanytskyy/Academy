package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleItemService;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
/*
 * Implementation of the {@link ScheduleItemService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleItemService")
@Transactional
public class ScheduleItemServiceImpl implements ScheduleItemService {
	@Autowired
	private ScheduleItemRepository scheduleItemRepository;
	@Override
	public ScheduleItem create(ScheduleItem scheduleItem){
		return scheduleItemRepository.create(scheduleItem);
	}
	@Override
	public ScheduleItem findById(long id){
		return scheduleItemRepository.findById(id);
	}
	@Override
	public List<ScheduleItem> findByScheduleId(long scheduleId) {
		return scheduleItemRepository.findByScheduleId(scheduleId);
	}
	@Override
	public List<ScheduleItem> findAll(){
		return scheduleItemRepository.findAll();
	}
	@Override
	public void deleteById(long id){
		scheduleItemRepository.deleteById(id);
	}
}