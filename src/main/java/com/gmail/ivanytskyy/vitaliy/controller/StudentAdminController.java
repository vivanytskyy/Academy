package com.gmail.ivanytskyy.vitaliy.controller;
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

import com.gmail.ivanytskyy.vitaliy.controller.editor.CustomGroupEditor;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.model.Student;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
import com.gmail.ivanytskyy.vitaliy.service.StudentService;
@Controller
@RequestMapping("/students")
public class StudentAdminController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private CustomGroupEditor groupEditor;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Group.class, this.groupEditor);
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllStudents(Model model){
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "students/studentsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createStudent(Model model){
		Student student = new Student();
		student.setName("name");
		List<Group> groupsList = groupService.findAll();
		model.addAttribute("groupsList", groupsList);
		model.addAttribute("student", student);
		return "students/createStudent";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createStudent(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "students/createStudent";
		}else if(!groupService.isExistsWithName(student.getGroup().getName())){
			result.reject("notExists", "group with this name doesn't exists");
			return "students/createStudent";
		}else{
			studentService.create(student);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateStudent(@PathVariable("id") Long id, Model model){
		Student student = studentService.findById(id);
		List<Group> groupsList = groupService.findAll();
		model.addAttribute("groupsList", groupsList);
		if(student == null){
			return "redirect:/students/list.html";
		}else{
			model.addAttribute("student", student);
			return "students/updateStudent";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateStudent(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "students/updateStudent";
		}else if(!groupService.isExistsWithName(student.getGroup().getName())){
			result.reject("notExists", "group with this name doesn't exists");
			return "students/createStudent";
		}
		else{
			studentService.create(student);
			return "redirect:/students/{id}/edit";
		}		
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteStudent(@RequestParam("id") Long id, Model model){
		studentService.deleteById(id);
		return "redirect:list.html";
	}
}