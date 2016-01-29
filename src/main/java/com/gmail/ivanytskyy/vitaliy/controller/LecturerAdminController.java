package com.gmail.ivanytskyy.vitaliy.controller;
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
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
/*
 * LecturerAdminController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
@RequestMapping("/lecturers")
public class LecturerAdminController {
	@Autowired
	private LecturerService lecturerService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllLecturers(Model model){
		List<Lecturer> lecturers = lecturerService.findAll();
		model.addAttribute("lecturers", lecturers);
		return "lecturers/lecturersList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addLecturer(Model model){
		Lecturer lecturer = new Lecturer();
		lecturer.setName("name");
		model.addAttribute("lecturer", lecturer);
		return "lecturers/createLecturer";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addLecturer(@Valid @ModelAttribute("lecturer") Lecturer lecturer, BindingResult result, Model model){
		if(result.hasErrors()){
			return "lecturers/createLecturer";
		}else if(lecturerService.isExistsWithName(lecturer.getName())){
			result.reject("notUniqueName");
			return "lecturers/createLecturer";
		}else{
			lecturerService.create(lecturer);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateLecturer(@PathVariable("id") Long id, Model model){
		Lecturer lecturer = lecturerService.findById(id);
		if(lecturer == null){
			return "redirect:lecturers/list.html";
		}else{
			model.addAttribute("lecturer", lecturer);
			return "lecturers/updateLecturer";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateLecturer(
			@Valid @ModelAttribute("lecturer") Lecturer lecturer,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "lecturers/updateLecturer";
		}else if(lecturerService.isExistsWithName(lecturer.getName())){
			result.reject("notUniqueName");
			return "lecturers/updateLecturer";
		}else{
			lecturerService.create(lecturer);
			return "redirect:/lecturers/{id}/edit";
		}
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteLecturer(@RequestParam(value="id") Long id, Model model){
		lecturerService.deleteById(id);
		return "redirect:list.html";
	}
}