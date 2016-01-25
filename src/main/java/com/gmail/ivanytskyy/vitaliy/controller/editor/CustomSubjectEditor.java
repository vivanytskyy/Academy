package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Subject;
import com.gmail.ivanytskyy.vitaliy.service.SubjectService;
@Component
public class CustomSubjectEditor extends PropertyEditorSupport{
	@Autowired
	private SubjectService subjectService;
	@Override
	public void setAsText(String text){
		Subject subject = this.subjectService.findById(Long.parseLong(text));
		this.setValue(subject);
	}
}