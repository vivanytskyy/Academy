package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Schedule;
import com.gmail.ivanytskyy.vitaliy.service.ScheduleService;
@Component
public class CustomScheduleEditor extends PropertyEditorSupport{
	@Autowired
	private ScheduleService scheduleService;
	@Override
	public void setAsText(String text){
		Schedule schedule = this.scheduleService.findById(Long.parseLong(text));
		this.setValue(schedule);
	}	
}