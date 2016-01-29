package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Service interface for controllers which need a point of entry to LessonIntervalRepository
 * @author Vitaliy Ivanytskyy
 */
public interface LessonIntervalService {
	public LessonInterval create(LessonInterval lessonInterval);
	public LessonInterval findById(long id);
	public List<LessonInterval> findAll();
	public void deleteById(long id);
	public boolean isExistsWithParameters(String lessonStart,
			String lessonFinish);
}