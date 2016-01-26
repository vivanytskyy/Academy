package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
import com.gmail.ivanytskyy.vitaliy.repository.ScheduleItemRepository;
import com.gmail.ivanytskyy.vitaliy.service.AcademyService;
@Service("academyService")
@Transactional
public class AcademyServiceImpl implements AcademyService {
	@Autowired
	private ScheduleItemRepository scheduleItemRepository;
	@Override
	public List<ScheduleItem> findScheduleByClassroom(Schedule schedule,
			Classroom classroom) {
		return scheduleItemRepository.findScheduleByClassroom(schedule, classroom);
	}
	@Override
	public List<ScheduleItem> findScheduleByLecturer(Schedule schedule,
			Lecturer lecturer) {
		return scheduleItemRepository.findScheduleByLecturer(schedule, lecturer);
	}
	@Override
	public List<ScheduleItem> findScheduleByGroup(Schedule schedule, Group group) {
		return scheduleItemRepository.findScheduleByGroup(schedule, group);
	}
}