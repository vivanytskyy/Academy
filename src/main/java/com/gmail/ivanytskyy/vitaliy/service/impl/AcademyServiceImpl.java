package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
/*
 * Implementation of the {@link AcademyService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("academyService")
@Transactional
public class AcademyServiceImpl implements AcademyService {
	private static final Logger logger = LoggerFactory.getLogger(AcademyServiceImpl.class);
	@Autowired
	private ScheduleItemRepository scheduleItemRepository;
	@Override
	public List<ScheduleItem> findScheduleByClassroom(Schedule schedule,
			Classroom classroom) {
		logger.debug("Find the schedule by schedule (id={}) and classroom (id={})",
				schedule.getId(), classroom.getId());
		return scheduleItemRepository.findScheduleByClassroom(schedule, classroom);
	}
	@Override
	public List<ScheduleItem> findScheduleByLecturer(Schedule schedule,
			Lecturer lecturer) {
		logger.debug("Find the schedule by schedule (id={}) and lecturer (id={})",
				schedule.getId(), lecturer.getId());
		return scheduleItemRepository.findScheduleByLecturer(schedule, lecturer);
	}
	@Override
	public List<ScheduleItem> findScheduleByGroup(Schedule schedule, Group group) {
		logger.debug("Find the schedule by schedule (id={}) and group (id={})",
				schedule.getId(), group.getId());
		return scheduleItemRepository.findScheduleByGroup(schedule, group);
	}
}