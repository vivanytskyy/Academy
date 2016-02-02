package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.GroupRepository;
import com.gmail.ivanytskyy.vitaliy.service.GroupService;
import com.gmail.ivanytskyy.vitaliy.model.Group;
/*
 * Implementation of the {@link GroupService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
	private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	@Autowired
	private GroupRepository groupRepository;
	@Override
	public Group create(Group group){
		logger.debug("Create the group with name = {}", group.getName());
		return groupRepository.create(group);
	}
	@Override
	public Group findById(long id){
		logger.debug("Find the group by id = {}", id);
		return groupRepository.findById(id);
	}
	@Override
	public List<Group> findByName(String name){
		logger.debug("Find the groups by name = {}", name);
		return groupRepository.findByName(name);
	}
	@Override
	public List<Group> findAll(){
		logger.debug("Find all groups");
		return groupRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name){
		logger.debug("Check if is exists the group with name = {}", name);
		return groupRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		logger.debug("Delete the group by id = {}", id);
		groupRepository.deleteById(id);
	}
}