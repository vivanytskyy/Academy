package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
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
	@Autowired
	private GroupRepository groupRepository;
	@Override
	public Group create(Group group){
		return groupRepository.create(group);
	}
	@Override
	public Group findById(long id){
		return groupRepository.findById(id);
	}
	@Override
	public List<Group> findByName(String name){
		return groupRepository.findByName(name);
	}
	@Override
	public List<Group> findAll(){
		return groupRepository.findAll();
	}
	@Override
	public boolean isExistsWithName(String name){
		return groupRepository.isExistsWithName(name);
	}
	@Override
	public void deleteById(long id){
		groupRepository.deleteById(id);
	}
}