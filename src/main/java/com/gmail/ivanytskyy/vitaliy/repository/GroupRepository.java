package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Repository interface for Group domain objects
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