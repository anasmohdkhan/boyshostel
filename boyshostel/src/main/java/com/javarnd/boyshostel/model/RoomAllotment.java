package com.javarnd.boyshostel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

/**
 * @author Anas This class contains the variables and getter setter methods used
 *         for RoomAllotment details
 *
 */
@Component
@Entity(name = "RoomAllotment")
public class RoomAllotment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomAllotmentId;
	private String endDate;
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Room room;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="roomAllotment")
	private List<Student> student;

	public int getRoomAllotmentId() {
		return roomAllotmentId;
	}

	public void setRoomAllotmentId(int roomAllotmentId) {
		this.roomAllotmentId = roomAllotmentId;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	

}
