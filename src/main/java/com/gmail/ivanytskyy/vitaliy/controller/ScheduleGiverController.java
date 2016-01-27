package com.gmail.ivanytskyy.vitaliy.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomClassroomEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomGroupEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomLecturerEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomScheduleEditor;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
import com.gmail.ivanytskyy.vitaliy.service.AcademyService;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
@Controller
@RequestMapping("/getSchedule")
public class ScheduleGiverController {
	@Autowired
	private AcademyService academyService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private LecturerService lecturerService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private CustomClassroomEditor classroomEditor;
	@Autowired
	private CustomLecturerEditor lecturerEditor;
	@Autowired
	private CustomGroupEditor groupEditor;
	@Autowired
	private CustomScheduleEditor scheduleEditor;
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Classroom.class, this.classroomEditor);
        binder.registerCustomEditor(Lecturer.class, this.lecturerEditor);
        binder.registerCustomEditor(Group.class, this.groupEditor);
        binder.registerCustomEditor(Schedule.class, this.scheduleEditor);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
	@RequestMapping(value="/getScheduleByClassroom", method=RequestMethod.GET)
	public String getScheduleByClassroom(Model model){
		ScheduleItem scheduleItem = new ScheduleItem();
		List<Classroom> classroomsList = classroomService.findAll();
		List<Schedule> schedulesList = scheduleService.findAll();
		model.addAttribute(
				"greetingUser",
				"Select the initial parameters for obtaining the schedule by classroom name");
		model.addAttribute("scheduleItem", scheduleItem);
		model.addAttribute("classroomsList", classroomsList);
		model.addAttribute("schedulesList", schedulesList);
		return "getSchedule/scheduleByClassroom";
	}
	@RequestMapping(value="/getScheduleByClassroom", method=RequestMethod.POST)
	public String getScheduleByClassroom(
			@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
			BindingResult result,			
			Model model){
		Classroom classroom = scheduleItem.getClassroom();
		Schedule schedule = scheduleItem.getSchedule();
		List<ScheduleItem> resultScheduleItems = academyService.findScheduleByClassroom(schedule, classroom);
		if(result.hasErrors()){
			return "redirect:getScheduleByClassroom.html";
		}else{
			model.addAttribute("parameter", classroom);
			model.addAttribute("schedule", schedule);
			model.addAttribute("resultScheduleItems", resultScheduleItems);
			return "getSchedule/scheduleResult";
		}
	}
	@RequestMapping(value="/getScheduleByLecturer", method=RequestMethod.GET)
	public String getScheduleByLecturer(Model model){
		ScheduleItem scheduleItem = new ScheduleItem();
		List<Lecturer> lecturersList = lecturerService.findAll();
		List<Schedule> schedulesList = scheduleService.findAll();
		model.addAttribute(
				"greetingUser",
				"Select the initial parameters for obtaining the schedule by lecturer name");
		model.addAttribute("scheduleItem", scheduleItem);
		model.addAttribute("lecturersList", lecturersList);
		model.addAttribute("schedulesList", schedulesList);
		return "getSchedule/scheduleByLecturer";
	}
	@RequestMapping(value="/getScheduleByLecturer", method=RequestMethod.POST)
	public String getScheduleByLecturer(
			@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
			BindingResult result,			
			Model model){
		Lecturer lecturer = scheduleItem.getLecturer();
		Schedule schedule = scheduleItem.getSchedule();
		List<ScheduleItem> resultScheduleItems = academyService.findScheduleByLecturer(schedule, lecturer);
		if(result.hasErrors()){
			return "redirect:getScheduleByLecturer.html";
		}else{
			model.addAttribute("parameter", lecturer);
			model.addAttribute("schedule", schedule);
			model.addAttribute("resultScheduleItems", resultScheduleItems);
			return "getSchedule/scheduleResult";
		}
	}
	@RequestMapping(value="/getScheduleByGroup", method=RequestMethod.GET)
	public String getScheduleByGroup(Model model){
		ScheduleItem scheduleItem = new ScheduleItem();
		List<Group> groupsList = groupService.findAll();
		List<Schedule> schedulesList = scheduleService.findAll();
		model.addAttribute(
				"greetingUser",
				"Select the initial parameters for obtaining the schedule by group name");
		model.addAttribute("scheduleItem", scheduleItem);
		model.addAttribute("groupsList", groupsList);
		model.addAttribute("schedulesList", schedulesList);
		return "getSchedule/scheduleByGroup";
	}
	@RequestMapping(value="/getScheduleByGroup", method=RequestMethod.POST)
	public String getScheduleByGroup(
			@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
			BindingResult result,			
			Model model){
		Group group = scheduleItem.getGroup();
		Schedule schedule = scheduleItem.getSchedule();
		List<ScheduleItem> resultScheduleItems = academyService.findScheduleByGroup(schedule, group);
		if(result.hasErrors()){
			return "redirect:getScheduleByGroup.html";
		}else{
			model.addAttribute("parameter", group);
			model.addAttribute("schedule", schedule);
			model.addAttribute("resultScheduleItems", resultScheduleItems);
			return "getSchedule/scheduleResult";
		}
	}
}