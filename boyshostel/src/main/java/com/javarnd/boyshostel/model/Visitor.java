package com.javarnd.boyshostel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * @author Anas This class contains the variables and getter setter methods used
 *         for Visitor details
 *
 */
@Component
@Entity(name = "Visitor")
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitorId;
	private String visitorName;
	private String visitorContactNo;
	private String studentName;
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorContactNo() {
		return visitorContactNo;
	}

	public void setVisitorContactNo(String visitorContactNo) {
		this.visitorContactNo = visitorContactNo;
	}

	
}
