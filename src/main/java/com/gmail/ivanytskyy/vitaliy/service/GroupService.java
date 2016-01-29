package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Service interface for controllers which need a point of entry to GroupRepository
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