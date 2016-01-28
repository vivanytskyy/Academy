package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;

import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Task #4/2016/01/03 (web project #4)
 * LessonIntervalService interface
 * @version 1.01 2016.01.03
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