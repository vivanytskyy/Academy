package com.gmail.ivanytskyy.vitaliy.service;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.LessonInterval;
/*
 * Service interface for controllers which need a point of entry to LessonIntervalRepository
 * @author Vitaliy Ivanytskyy
 */
public interface LessonIntervalService {
	LessonInterval create(LessonInterval lessonInterval);
	LessonInterval findById(long id);
	List<LessonInterval> findAll();
	void deleteById(long id);
	boolean isExistsWithParameters(String lessonStart, String lessonFinish);
}