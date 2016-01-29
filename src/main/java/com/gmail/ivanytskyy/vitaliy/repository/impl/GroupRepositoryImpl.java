package com.gmail.ivanytskyy.vitaliy.repository.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gmail.ivanytskyy.vitaliy.model.Group;
import com.gmail.ivanytskyy.vitaliy.repository.GroupRepository;
/*
 * JPA implementation of the {@link GroupRepository} interface.
 * @author Vitaliy Ivanytskyy
 */
@Repository("groupRepository")
public class GroupRepositoryImpl implements GroupRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Group create(Group group) {
		if(group.getId() == null){
			entityManager.persist(group);
		}else{
			entityManager.merge(group);
		}
		entityManager.flush();
		return group;
	}
	@Override
	public Group findById(long id) {
		return entityManager.find(Group.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> findByName(String name) {
		return entityManager.createQuery(
				"SELECT g FROM Group g WHERE g.name=:name")
				.setParameter("name", name)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> findAll() {
		return entityManager.createQuery(
				"SELECT g FROM Group g")
				.getResultList();
	}
	@Override
	public boolean isExistsWithName(String name) {
		long result = (long) entityManager.createQuery(
				"SELECT COUNT(g) FROM Group g WHERE g.name=:name")
				.setParameter("name", name)
				.getSingleResult();
		return result > 0;
	}
	@Override
	public void deleteById(long id) {
		Group group = findById(id);
		entityManager.remove(group);
	}
}