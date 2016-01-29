package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
/*
 * Editor for the conversion between a Schedule object and his id (as the String). 
 * @author Vitaliy Ivanytskyy
 */
@Component
public class CustomScheduleEditor extends PropertyEditorSupport{
	@Autowired
	private ScheduleService scheduleService;
	// Converts a String to a Schedule (when submitting form)
	@Override
	public void setAsText(String text){
		Schedule schedule = this.scheduleService.findById(Long.parseLong(text));
		this.setValue(schedule);
	}	
}