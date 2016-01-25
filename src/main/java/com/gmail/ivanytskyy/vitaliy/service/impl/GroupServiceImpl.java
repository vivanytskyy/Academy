package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.GroupRepository;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Task #3/2015/12/14 (web project #3)
 * GroupServiceImpl class
 * @version 1.01 2015.12.14
 * @author Vitaliy Ivanytskyy
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupRepository groupRepository;
	/*//@Autowired
	private StudentRepository studentRepository;*/
	private static final Logger log = Logger.getLogger(GroupServiceImpl.class.getName());
	@Override
	public Group create(Group group){
		log.info("Creating group with groupName = " + group.getName());
		Group newGroup = groupRepository.create(group);
		log.trace("Group with groupName = " + group.getName() + " was created");
		return newGroup;
	}
	@Override
	public Group findById(long id){
		log.info("Getting group by groupId = " + id);
		Group group = groupRepository.findById(id);
		log.trace("Group was gotten");
		return group;
	}
	@Override
	public List<Group> findByName(String name){
		log.info("Getting groups by groupName=" + name);
		List<Group> groups = groupRepository.findByName(name);
		log.trace("Groups were gotten");
		return groups;
	}
	@Override
	public List<Group> findAll(){
		log.info("Getting all groups");
		List<Group> groups = groupRepository.findAll();
		log.trace("Groups were gotten");
		return groups;
	}
	@Override
	public boolean isExistsWithName(String name){
		log.info("Checking if exists the group with name = " + name);
		boolean result = groupRepository.isExistsWithName(name);
		log.trace("Existence was checked, result = " + result);
		return result;
	}
	@Override
	public void deleteById(long id){
		/*log.info("Remove group by groupId = " + id);
		log.trace("Try get information about students of group with groupId=" + id);
		List<Student> students = studentRepository.findByGroupId(id);
		log.trace("Information about students of group with groupId = " + id + " was gotten");
		if(students.isEmpty() || students == null){
			log.trace("Remove group with groupId = " + id);
			groupRepository.deleteById(id);
			log.trace("Group with groupId = " + id + " was deleted");
		}else{
			log.trace("Can not delete group with the students");
		}*/
		groupRepository.deleteById(id);
	}
}