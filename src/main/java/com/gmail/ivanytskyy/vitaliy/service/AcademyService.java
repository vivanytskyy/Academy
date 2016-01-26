package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
public interface AcademyService {
	List<ScheduleItem> findScheduleByClassroom(Schedule schedule, Classroom classroom);
	List<ScheduleItem> findScheduleByLecturer(Schedule schedule, Lecturer lecturer);
	List<ScheduleItem> findScheduleByGroup(Schedule schedule, Group group);
}