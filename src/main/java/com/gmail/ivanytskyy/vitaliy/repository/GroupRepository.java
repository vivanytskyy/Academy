package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Task #4/2016/01/03 (web project #4)
 * GroupRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface GroupRepository {
	Group create(Group group);
	Group findById(long id);
	List<Group> findByName(String name);
	List<Group> findAll();
	boolean isExistsWithName(String name);
	void deleteById(long id);
}