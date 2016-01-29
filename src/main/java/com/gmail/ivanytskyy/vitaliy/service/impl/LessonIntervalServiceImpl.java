package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.LessonIntervalRepository;
import com.gmail.ivanytskyy.vitaliy.service.LessonIntervalService;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Implementation of the {@link LessonIntervalService} interface.
 * @author Vitaliy Ivanytskyy
 */
@Service("lessonIntervalService")
@Transactional
public class LessonIntervalServiceImpl implements LessonIntervalService {
	@Autowired
	private LessonIntervalRepository lessonIntervalRepository;
	@Override
	public LessonInterval create(LessonInterval lessonInterval){
		return lessonIntervalRepository.create(lessonInterval);
	}
	@Override
	public LessonInterval findById(long id){
		return lessonIntervalRepository.findById(id);
	}
	@Override
	public List<LessonInterval> findAll(){
		return lessonIntervalRepository.findAll();
	}
	@Override
	public boolean isExistsWithParameters(String lessonStart,
			String lessonFinish) {
		return lessonIntervalRepository.isExistsWithParameters(lessonStart, lessonFinish);
	}	
	@Override
	public void deleteById(long id){
		lessonIntervalRepository.deleteById(id);
	}
}