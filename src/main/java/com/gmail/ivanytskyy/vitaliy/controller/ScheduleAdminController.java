package com.gmail.ivanytskyy.vitaliy.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
@Controller
@RequestMapping("/schedules")
public class ScheduleAdminController {
	@Autowired
	private ScheduleService scheduleService;
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllSchedules(Model model){
		List<Schedule> schedules = scheduleService.findAll();
		model.addAttribute("schedules", schedules);
		return "schedules/schedulesList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createSchedule(Model model){
		Schedule schedule = new Schedule();
		Date date = new Date();
		schedule.setTimeStamp(date);
		model.addAttribute("schedule", schedule);
		return "schedules/createSchedule";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createSchedule(
			@Valid @ModelAttribute(value="schedule") Schedule schedule,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "schedules/createSchedule";
		}else if(scheduleService.isExistsWithDate(schedule.getTimeStamp())){
			result.reject("notUniqueScheduleDate");
			return "schedules/createSchedule";
		}else {
			scheduleService.create(schedule);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateSchedule(@PathVariable("id") Long id, Model model){
		Schedule schedule = scheduleService.findById(id);
		if(schedule == null){
			return "redirect:/schedules/list.html";
		}else{
			model.addAttribute("schedule", schedule);
			return "schedules/updateSchedule";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateSchedule(
			@Valid @ModelAttribute(value="schedule") Schedule schedule,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "schedules/createSchedule";
		}else if(scheduleService.isExistsWithDate(schedule.getTimeStamp())){
			result.reject("notUniqueScheduleDate");
			return "schedules/createSchedule";
		}else {
			scheduleService.create(schedule);
			return "redirect:/schedules/{id}/edit.html";
		}
	}
	@RequestMapping(value="/{id}/scheduleitemslist", method=RequestMethod.GET)
	public String showScheduleItemsList(@PathVariable("id") Long id, Model model){
		Schedule schedule = scheduleService.findById(id);			
		if(schedule == null){
			return "redirect:/schedules/list.html";
		}else{
			model.addAttribute("schedule", schedule);
			return "schedules/scheduleContent";
		}
	}
	@RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
	public String deleteSchedule(@PathVariable("id") Long id, Model model){
		Schedule schedule = scheduleService.findById(id);
		if(schedule == null){
			return "redirect:/schedules/list.html";
		}else{
			model.addAttribute("schedule", schedule);
			return "schedules/deleteSchedule";
		}
	}
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String deleteSchedule(
			@Valid @ModelAttribute("schedule") Schedule schedule,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "schedules/deleteSchedule";
		}
		// control presence schedule items into current schedule
		/*else if(!schedule.getScheduleItems().isEmpty()){
			result.reject("notEmpty", "schedule contains the schedule items");
			return "schedules/deleteSchedule";
		}*/		
		else{			
			scheduleService.deleteById(id);
			return "redirect:/schedules/list.html";
		}		
	}
}