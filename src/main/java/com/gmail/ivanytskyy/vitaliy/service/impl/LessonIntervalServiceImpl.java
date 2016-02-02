package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(LessonIntervalServiceImpl.class);
	@Autowired
	private LessonIntervalRepository lessonIntervalRepository;
	@Override
	public LessonInterval create(LessonInterval lessonInterval){
		logger.debug("Create the lesson interval with start={} and finish={}",
				lessonInterval.getLessonStart(), lessonInterval.getLessonFinish());
		return lessonIntervalRepository.create(lessonInterval);
	}
	@Override
	public LessonInterval findById(long id){
		logger.debug("Find the lesson interval by id = {}", id);
		return lessonIntervalRepository.findById(id);
	}
	@Override
	public List<LessonInterval> findAll(){
		logger.debug("Find all lesson intervals");
		return lessonIntervalRepository.findAll();
	}
	@Override
	public boolean isExistsWithParameters(String lessonStart,
			String lessonFinish) {
		logger.debug("Check if is exists the lesson interval with start={} and finish={}",
				lessonStart, lessonFinish);
		return lessonIntervalRepository.isExistsWithParameters(lessonStart, lessonFinish);
	}	
	@Override
	public void deleteById(long id){
		logger.debug("Delete the lesson interval by id = {}", id);
		lessonIntervalRepository.deleteById(id);
	}
}