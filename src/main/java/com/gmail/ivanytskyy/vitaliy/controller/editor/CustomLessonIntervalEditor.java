package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
import com.gmail.ivanytskyy.vitaliy.service.LessonIntervalService;
@Component
public class CustomLessonIntervalEditor extends PropertyEditorSupport{
	@Autowired
	private LessonIntervalService lessonIntervalService;
	@Override
	public void setAsText(String text){
		LessonInterval lessonInterval = this.lessonIntervalService.findById(Long.parseLong(text));
		this.setValue(lessonInterval);
	}
}