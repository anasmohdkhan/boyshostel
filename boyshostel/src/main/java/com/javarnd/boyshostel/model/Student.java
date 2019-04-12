package com.javarnd.boyshostel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

/**
 * @author Anas This class contains the variables and getter setter methods used
 *         for Student details
 *
 */
@Component
@Entity(name = "Student")
@PrimaryKeyJoinColumn(name="userId") 
public class Student extends UserDetails {

	private String courseName;
	private String courseDuration;
	@OneToOne(cascade = CascadeType.ALL)
	private Report report;
	@ManyToOne(cascade = CascadeType.ALL)
	private RoomAllotment roomAllotment;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public RoomAllotment getRoomAllotment() {
		return roomAllotment;
	}

	public void setRoomAllotment(RoomAllotment roomAllotment) {
		this.roomAllotment = roomAllotment;
	}

}
