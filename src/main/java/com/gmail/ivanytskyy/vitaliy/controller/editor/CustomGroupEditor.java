package com.gmail.ivanytskyy.vitaliy.controller.editor;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
@Component
public class CustomGroupEditor extends PropertyEditorSupport{
	@Autowired
	private GroupService groupService;
    // Converts a String to a Group (when submitting form)
    @Override
    public void setAsText(String text) {
        Group group = this.groupService.findById(Long.valueOf(text));
        this.setValue(group);
    }
}