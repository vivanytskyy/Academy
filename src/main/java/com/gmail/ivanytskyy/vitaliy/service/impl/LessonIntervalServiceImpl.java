package com.gmail.ivanytskyy.vitaliy.service.impl;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.ivanytskyy.vitaliy.repository.LessonIntervalRepository;
import com.gmail.ivanytskyy.vitaliy.service.LessonIntervalService;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Task #4/2016/01/03 (web project #4)
 * LessonIntervalServiceImpl class
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
@Service("lessonIntervalService")
@Transactional
public class LessonIntervalServiceImpl implements LessonIntervalService {
	@Autowired
	private LessonIntervalRepository lessonIntervalRepository;
	private static final Logger log = Logger.getLogger(LessonIntervalServiceImpl.class);
	@Override
	public LessonInterval create(LessonInterval lessonInterval){
		log.info("Creating lessonInterval with lessonStart = " + lessonInterval.getLessonStart() 
				+ " and lessonFinish = " + lessonInterval.getLessonFinish());
		LessonInterval newLessonInterval = lessonIntervalRepository.create(lessonInterval);
		log.trace("LessonInterval was created");
		return newLessonInterval;
	}
	@Override
	public LessonInterval findById(long id){
		log.info("Getting lessonInterval by lessonIntervalId = " + id);
		LessonInterval lessonInterval = lessonIntervalRepository.findById(id);
		log.trace("LessonInterval was gotten");
		return lessonInterval;
	}
	@Override
	public List<LessonInterval> findAll(){
		log.info("Getting all lessonIntervals");
		List<LessonInterval> lessonIntervals = lessonIntervalRepository.findAll();
		log.trace("LessonIntervals were gotten");
		return lessonIntervals;
	}
	@Override
	public void deleteById(long id){
		log.info("Remove lessonInterval by lessonIntervalId = " + id);
		lessonIntervalRepository.deleteById(id);
		log.trace("LessonInterval with lessonIntervalId = " + id + " was removed");
	}	
}