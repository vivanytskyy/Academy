package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleRepository;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
/*
 * Implementation of the {@link ScheduleService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Override
	public Schedule create(Schedule schedule){
		return scheduleRepository.create(schedule);
	}
	@Override
	public Schedule findById(long id){
		return scheduleRepository.findById(id);
	}
	@Override
	public List<Schedule> findByDate(Date scheduleDate){
		return scheduleRepository.findByDate(scheduleDate);
	}
	@Override
	public List<Schedule> findAll(){
		return scheduleRepository.findAll();
	}
	@Override
	public boolean isExistsWithDate(Date timeStamp) {
		return scheduleRepository.isExistsWithDate(timeStamp);
	}
	@Override
	public void deleteById(long id){
		scheduleRepository.deleteById(id);
	}
}