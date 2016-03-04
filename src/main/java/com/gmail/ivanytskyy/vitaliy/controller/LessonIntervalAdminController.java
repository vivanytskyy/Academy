package com.gmail.ivanytskyy.vitaliy.controller;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
import com.gmail.ivanytskyy.vitaliy.service.LessonIntervalService;
/*
 * LessonIntervalAdminController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
@RequestMapping("/lessonintervals")
public class LessonIntervalAdminController {
	@Autowired
	private LessonIntervalService lessonIntervalService;
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllLessonIntervals(Model model){
		List<LessonInterval> lessonIntervals = lessonIntervalService.findAll();
		Collections.sort(lessonIntervals);
		model.addAttribute("lessonIntervals", lessonIntervals);
		return "lessonIntervals/lessonIntervalsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createLessonInterval(Model model){
		LessonInterval lessonInterval = new LessonInterval();
		lessonInterval.setLessonStart("HH.mm");
		lessonInterval.setLessonFinish("HH.mm");
		model.addAttribute("lessonInterval", lessonInterval);
		return "lessonIntervals/createLessonInterval";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createLessonInterval(
			@Valid @ModelAttribute("lessonInterval") LessonInterval lessonInterval,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "lessonIntervals/createLessonInterval";
		}else if(lessonIntervalService
				.isExistsWithParameters(
						lessonInterval.getLessonStart(), lessonInterval.getLessonFinish())){
			result.reject("notUniqueLessonInterval");
			return "lessonIntervals/createLessonInterval";
		}else{
			lessonIntervalService.create(lessonInterval);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateLessonInterval(@PathVariable("id") Long id, Model model){
		LessonInterval lessonInterval = lessonIntervalService.findById(id);
		if(lessonInterval == null){
			return "redirect:/lessonintervals/list.html";
		}else{
			model.addAttribute("lessonInterval", lessonInterval);
			return "lessonIntervals/updateLessonInterval";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateLessonInterval(
			@Valid @ModelAttribute("lessonInterval") LessonInterval lessonInterval,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "lessonIntervals/updateLessonInterval";
		}else if(lessonIntervalService
				.isExistsWithParameters(
						lessonInterval.getLessonStart(), lessonInterval.getLessonFinish())){
			result.reject("notUniqueLessonInterval");
			return "lessonIntervals/updateLessonInterval";
		}else{
			lessonIntervalService.create(lessonInterval);
			return "redirect:/lessonintervals/{id}/edit";
		}		
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteLessonInterval(@RequestParam("id") Long id, Model model){
		lessonIntervalService.deleteById(id);
		return "redirect:list.html";
	}
}