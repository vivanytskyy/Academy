package com.gmail.ivanytskyy.vitaliy.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.gmail.ivanytskyy.vitaliy.annotation.LessonIntervalFormat;
/*
 * Task #4/2016/01/09 (web project #4)
 * LessonInterval class
 * @version 1.01 2016.01.09
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "lesson_intervals")
public class LessonInterval {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@LessonIntervalFormat
	@Column(name = "lesson_start", columnDefinition="char(5)")
	private String lessonStart;
	@NotEmpty
	@LessonIntervalFormat
	@Column(name = "lesson_finish", columnDefinition="char(5)")
	private String lessonFinish;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLessonStart() {
		return lessonStart;
	}
	public void setLessonStart(String lessonStart) {
		this.lessonStart = lessonStart;
	}
	public String getLessonFinish() {
		return lessonFinish;
	}
	public void setLessonFinish(String lessonFinish) {
		this.lessonFinish = lessonFinish;
	}
}