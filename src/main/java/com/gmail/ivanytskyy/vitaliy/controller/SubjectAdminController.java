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
import com.gmail.ivanytskyy.vitaliy.model.Subject;
import com.gmail.ivanytskyy.vitaliy.service.SubjectService;
@Controller
@RequestMapping("/subjects")
public class SubjectAdminController {
	@Autowired
	private SubjectService subjectService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllSubjects(Model model){
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		return "subjects/subjectsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createSubject(Model model){
		Subject subject = new Subject();
		subject.setName("name");
		model.addAttribute("subject", subject);
		return "subjects/createSubject";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createSubject(
			@Valid @ModelAttribute("subject") Subject subject,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "subjects/createSubject";
		}else if(subjectService.isExistsWithName(subject.getName())){
			result.reject("notUnique", "value must be unique");
			return "subjects/createSubject";
		}else{
			subjectService.create(subject);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateSubject(@PathVariable(value="id") Long id, Model model){
		Subject subject = subjectService.findById(id);
		if(subject == null){
			return "redirect:/subjects/list.html";
		}else{
			model.addAttribute("subject", subject);
			return "subjects/updateSubject";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateSubject(
			@Valid @ModelAttribute(value="subject") Subject subject,
			BindingResult result,
			@PathVariable(value="id") Long id,
			Model model){
		if(result.hasErrors()){
			return "subjects/updateSubject";
		}else if(subjectService.isExistsWithName(subject.getName())){
			result.reject("notUnique", "value must be unique");
			return "subjects/updateSubject";
		}else{
			subjectService.create(subject);
			return "redirect:/subjects/{id}/edit";
		}
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteSubject(@RequestParam(value="id") Long id, Model model){
		subjectService.deleteById(id);
		return "redirect:list.html";
	}
}