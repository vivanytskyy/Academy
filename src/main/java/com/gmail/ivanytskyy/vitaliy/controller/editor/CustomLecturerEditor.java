package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Lecturer;
import com.gmail.ivanytskyy.vitaliy.service.LecturerService;
/*
 * Editor for the conversion between a Lecturer object and his id (as the String). 
 * @author Vitaliy Ivanytskyy
 */
@Component
public class CustomLecturerEditor extends PropertyEditorSupport{
	@Autowired
	private LecturerService lecturerService;
	// Converts a String to a Lecturer (when submitting form)
	@Override
	public void setAsText(String text){
		Lecturer lecturer = this.lecturerService.findById(Long.parseLong(text));
		this.setValue(lecturer);
	}	
}