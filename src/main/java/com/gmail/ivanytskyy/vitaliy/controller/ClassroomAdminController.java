package com.gmail.ivanytskyy.vitaliy.controller;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
/*
 * ClassroomAdminController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
@RequestMapping("/classrooms")
public class ClassroomAdminController {
	@Autowired
	private ClassroomService classroomService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllClassrooms(Model model){
		List<Classroom> classrooms = classroomService.findAll();
		Collections.sort(classrooms);
		model.addAttribute("classrooms", classrooms);
		return "classrooms/classroomsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addClassroom(Model model){
		Classroom classroom = new Classroom();
		classroom.setName("name");
		model.addAttribute("classroom", classroom);
		return "classrooms/createClassroom";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addClassroom(
			@Valid @ModelAttribute("classroom") Classroom classroom,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "classrooms/createClassroom";
		}else if(classroomService.isExistsWithName(classroom.getName())){
			result.reject("notUniqueName");
			return "classrooms/createClassroom";
		}else{
			classroomService.create(classroom);
			return "redirect:create.html";
		}		
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateClassroom(@PathVariable("id") Long id, Model model){		
		Classroom classroom = classroomService.findById(id);
		if(classroom != null){
			model.addAttribute("classroom", classroom);
			return "classrooms/updateClassroom";
		}else{
			return "redirect:/classrooms/list.html";
		}		
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateClassroom(
			@Valid @ModelAttribute("classroom") Classroom classroom,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "classrooms/updateClassroom";
		}else if(classroomService.isExistsWithName(classroom.getName())){			
			result.reject("notUniqueName");
			return "classrooms/updateClassroom";
		}else{
			classroomService.create(classroom);
	        return "redirect:/classrooms/{id}/edit";
		}        
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteClassroom(@RequestParam(value = "id") Long id, Model model){
		classroomService.deleteById(id);
		return "redirect:list.html";
	}
}