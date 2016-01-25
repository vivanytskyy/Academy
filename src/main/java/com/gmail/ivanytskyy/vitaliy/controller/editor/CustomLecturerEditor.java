package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
@Component
public class CustomLecturerEditor extends PropertyEditorSupport{
	@Autowired
	private LecturerService lecturerService;
	@Override
	public void setAsText(String text){
		Lecturer lecturer = this.lecturerService.findById(Long.parseLong(text));
		this.setValue(lecturer);
	}	
}