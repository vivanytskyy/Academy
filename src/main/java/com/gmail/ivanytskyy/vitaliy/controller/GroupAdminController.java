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
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
/*
 * GroupAdminController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
@RequestMapping("/groups")
public class GroupAdminController {
	@Autowired
	private GroupService groupService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAllGroups(Model model){
		List<Group> groups = groupService.findAll();
		model.addAttribute("groups", groups);
		return "groups/groupsList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createGroup(Model model){
		Group group = new Group();
		group.setName("name");
		model.addAttribute("group", group);
		return "groups/createGroup";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createGroup(
			@Valid @ModelAttribute("group") Group group,
			BindingResult result,
			Model model){
		if(result.hasErrors()){
			return "groups/createGroup";
		}else if(groupService.isExistsWithName(group.getName())){
			result.reject("notUniqueName");
			return "groups/createGroup";
		}else{
			groupService.create(group);
			return "redirect:create.html";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String updateGroup(@PathVariable("id") Long id, Model model){
		Group group = groupService.findById(id);
		if(group == null){
			return "redirect:/groups/list.html";
		}else{
			model.addAttribute("group", group);
			return "groups/updateGroup";
		}
	}
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String updateGroup(
			@Valid @ModelAttribute("group") Group group,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "groups/updateGroup";
		}else if(groupService.isExistsWithName(group.getName())){
			result.reject("notUniqueName");
			return "groups/updateGroup";
		}
		// control presence students into current group
		else{
			groupService.create(group);
			return "redirect:/groups/{id}/edit";
		}		
	}
	@RequestMapping(value="/{id}/studentslist", method=RequestMethod.GET)
	public String showStudentsList(@PathVariable("id") Long id, Model model){
		Group group = groupService.findById(id);
		if(group == null){
			return "redirect:/groups/list.html";
		}else{
			model.addAttribute("group", group);
			return "groups/groupContent";
		}
	}
	@RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
	public String deleteGroup(@PathVariable("id") Long id, Model model){
		Group group = groupService.findById(id);
		if(group == null){
			return "redirect:/groups/list.html";
		}else{
			model.addAttribute("group", group);
			return "groups/deleteGroup";
		}
	}
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String deleteGroup(
			@Valid @ModelAttribute("group") Group group,
			BindingResult result,
			@PathVariable("id") Long id,
			Model model){
		if(result.hasErrors()){
			return "groups/deleteGroup";
		}
		// control presence students into current group
		/*else if(!group.getStudents().isEmpty()){
			result.reject("notEmpty", "group contains the students");
			return "groups/deleteGroup";
		}*/		
		else{			
			groupService.deleteById(id);
			return "redirect:/groups/list.html";
		}		
	}
}