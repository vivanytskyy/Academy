package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;
@Component
public class CustomClassroomEditor extends PropertyEditorSupport{
	@Autowired
	private ClassroomService classroomService;
	@Override
	public void setAsText(String text){
		Classroom classroom = this.classroomService.findById(Long.parseLong(text));
		this.setValue(classroom);
	}
}