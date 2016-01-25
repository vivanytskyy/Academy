package com.gmail.ivanytskyy.vitaliy.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/*
 * Task #4/2016/01/09 (web project #4)
 * ScheduleItem class
 * @version 1.01 2016.01.09
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "schedule_items")
public class ScheduleItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	private Group group;
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "lecturer_id", referencedColumnName = "id")
	private Lecturer lecturer;
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "classroom_id", referencedColumnName = "id")
	private Classroom classroom;
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;
	@NotNull
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "lesson_interval_id", referencedColumnName = "id")
	private LessonInterval lessonInterval;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "schedule_id", referencedColumnName = "id")
	private Schedule schedule;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public LessonInterval getLessonInterval() {
		return lessonInterval;
	}
	public void setLessonInterval(LessonInterval lessonInterval) {
		this.lessonInterval = lessonInterval;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}	
}