package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Service interface for controllers which need a point of entry to GroupRepository
 * @author Vitaliy Ivanytskyy
 */
public interface GroupService {
	Group create(Group group);
	Group findById(long id);
	List<Group> findByName(String name);
	List<Group> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);
}