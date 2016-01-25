package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Task #4/2016/01/03 (web project #4)
 * GroupService interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface GroupService {
	public Group create(Group group);
	public Group findById(long id);
	public List<Group> findByName(String name);
	public List<Group> findAll();
	public boolean isExistsWithName(String name);
	public void deleteById(long id);
}