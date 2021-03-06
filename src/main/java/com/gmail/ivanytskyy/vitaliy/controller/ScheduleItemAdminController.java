package com.gmail.ivanytskyy.vitaliy.controller;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomClassroomEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomGroupEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomLecturerEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomLessonIntervalEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomScheduleEditor;
import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomSubjectEditor;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.model.ScheduleItem;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
import com.gmail.ivanytskyy.vitaliy.service.LessonIntervalService;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleItemService;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
import com.gmail.ivanytskyy.vitaliy.service.SubjectService;
/*
 * ScheduleItemAdminController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
@RequestMapping("/scheduleitems")
public class ScheduleItemAdminController {
	@Autowired
	private ScheduleItemService scheduleItemService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private LecturerService lecturerService;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private LessonIntervalService lessonIntervalService;
	@Autowired
	private CustomGroupEditor groupEditor;
	@Autowired
	private CustomLecturerEditor lecturerEditor;
	@Autowired
	private CustomClassroomEditor classroomEditor;
	@Autowired
	private CustomSubjectEditor subjectEditor;
	@Autowired
	private CustomLessonIntervalEditor lessonIntervalEditor;
	@Autowired
	private CustomScheduleEditor scheduleEditor;
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Group.class, this.groupEditor);
        binder.registerCustomEditor(Lecturer.class, this.lecturerEditor);
        binder.registerCustomEditor(Classroom.class, this.classroomEditor);
        binder.registerCustomEditor(Subject.class, this.subjectEditor);
        binder.registerCustomEditor(LessonInterval.class, this.lessonIntervalEditor);
        binder.registerCustomEditor(Schedule.class, this.scheduleEditor);
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllScheduleItems(Model model){
		List<ScheduleItem> scheduleItems = scheduleItemService.findAll();
		model.addAttribute("scheduleItems", scheduleItems);
		return "scheduleItems/scheduleItemsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createScheduleItem(Model model){
		ScheduleItem scheduleItem = new ScheduleItem();
		List<Schedule> schedulesList = scheduleService.findAll();
		Collections.sort(schedulesList);
		List<Group> groupsList = groupService.findAll();
		Collections.sort(groupsList);
		List<Lecturer> lecturersList = lecturerService.findAll();
		Collections.sort(lecturersList);
		List<Classroom> classroomsList = classroomService.findAll();
		Collections.sort(classroomsList);
		List<Subject> subjectsList = subjectService.findAll();
		Collections.sort(subjectsList);
		List<LessonInterval> lessonIntervalsList = lessonIntervalService.findAll();
		Collections.sort(lessonIntervalsList);
		model.addAttribute("scheduleItem", scheduleItem);
		model.addAttribute("schedulesList", schedulesList);
		model.addAttribute("groupsList", groupsList);
		model.addAttribute("lecturersList", lecturersList);
		model.addAttribute("classroomsList", classroomsList);
		model.addAttribute("subjectsList", subjectsList);
		model.addAttribute("lessonIntervalsList", lessonIntervalsList);
		return "scheduleItems/createScheduleItem";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createScheduleItem(
			@Valid @ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "scheduleItems/createScheduleItem";
		}else{
			scheduleItemService.create(scheduleItem);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateScheduleItem(@PathVariable("id") Long id, Model model){
		ScheduleItem scheduleItem = scheduleItemService.findById(id);
		if(scheduleItem == null){
			return "redirect:/scheduleitems/list.html";
		}else{
			List<Schedule> schedulesList = scheduleService.findAll();
			Collections.sort(schedulesList);
			List<Group> groupsList = groupService.findAll();
			Collections.sort(groupsList);
			List<Lecturer> lecturersList = lecturerService.findAll();
			Collections.sort(lecturersList);
			List<Classroom> classroomsList = classroomService.findAll();
			Collections.sort(classroomsList);
			List<Subject> subjectsList = subjectService.findAll();
			Collections.sort(subjectsList);
			List<LessonInterval> lessonIntervalsList = lessonIntervalService.findAll();
			Collections.sort(lessonIntervalsList);
			model.addAttribute("schedulesList", schedulesList);
			model.addAttribute("groupsList", groupsList);
			model.addAttribute("lecturersList", lecturersList);
			model.addAttribute("classroomsList", classroomsList);
			model.addAttribute("subjectsList", subjectsList);
			model.addAttribute("lessonIntervalsList", lessonIntervalsList);
			model.addAttribute("scheduleItem", scheduleItem);
			return "scheduleItems/updateScheduleItem";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateScheduleItem(
			@Valid @ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		System.out.println(scheduleItem.getId());
		if(result.hasErrors()){
			return "scheduleItems/updateScheduleItem";
		}else{
			scheduleItemService.create(scheduleItem);
			return "redirect:/scheduleitems/{id}/edit";
		}
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteScheduleItem(@RequestParam("id") Long id, Model model){
		scheduleItemService.deleteById(id);
		return "redirect:list.html";
	}
}