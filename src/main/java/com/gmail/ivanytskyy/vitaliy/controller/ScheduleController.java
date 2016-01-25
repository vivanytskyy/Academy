package com.gmail.ivanytskyy.vitaliy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/getSchedule")
public class ScheduleController {
	@RequestMapping(value="/getScheduleByClassroom")
	public String getScheduleByClassroom(Model model){
		model.addAttribute("greetingUser", "Enter initial parameters for obtaining the schedule by classroom name");
		return "getSchedule/scheduleByClassroom";
	}
	@RequestMapping(value="/getScheduleByLecturer")
	public String getScheduleByLecturer(Model model){
		model.addAttribute("greetingUser", "Enter initial parameters for obtaining the schedule by lecturer name");
		return "getSchedule/scheduleByLecturer";
	}
	@RequestMapping(value="/getScheduleByGroup")
	public String getScheduleByGroup(Model model){
		model.addAttribute("greetingUser", "Enter initial parameters for obtaining the schedule by group name");
		return "getSchedule/scheduleByGroup";
	}
}