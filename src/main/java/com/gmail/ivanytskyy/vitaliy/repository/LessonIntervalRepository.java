package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;

import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Task #4/2016/01/03 (web project #4)
 * LessonIntervalRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface LessonIntervalRepository {
	LessonInterval create(LessonInterval lessonInterval);
	LessonInterval findById(long id);
	List<LessonInterval> findAll();
	void deleteById(long id);
	boolean isExistsWithParameters(String lessonStart, String lessonFinish);
}