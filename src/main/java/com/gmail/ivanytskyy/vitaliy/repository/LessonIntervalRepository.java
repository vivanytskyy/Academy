package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;

import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Repository interface for LessonInterval domain objects
 * @author Vitaliy Ivanytskyy
 */
public interface LessonIntervalRepository {
	LessonInterval create(LessonInterval lessonInterval);
	LessonInterval findById(long id);
	List<LessonInterval> findAll();
	void deleteById(long id);
	boolean isExistsWithParameters(String lessonStart, String lessonFinish);
}