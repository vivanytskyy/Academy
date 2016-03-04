package com.gmail.ivanytskyy.vitaliy.model;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
/*
 * Simple JavaBean domain object representing a schedule
 * @author Vitaliy Ivanytskyy
 */
@Entity
@Table(name = "schedules")
public class Schedule implements Comparable<Schedule>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date timeStamp = new Date();
	@OneToMany(mappedBy = "schedule", orphanRemoval=true, fetch = FetchType.LAZY)
	private Set<ScheduleItem> scheduleItems = new TreeSet<ScheduleItem>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Set<ScheduleItem> getScheduleItems() {
		return scheduleItems;
	}
	public void setScheduleItems(Set<ScheduleItem> scheduleItems) {
		this.scheduleItems = scheduleItems;
	}
	@Override
	public int compareTo(Schedule o) {
		return timeStamp.compareTo(o.getTimeStamp());
	}	
}