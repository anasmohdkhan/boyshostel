package com.javarnd.boyshostel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * @author Anas This class contains the variables and getter setter methods used
 *         for Fees details
 *
 */
@Component
@Entity(name = "Fees")
public class Fees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feeId;
	private int roomFee;
	private int messFees;
	@OneToOne(cascade = CascadeType.ALL)
	private Room room;
	@OneToOne
	private Report report;

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public int getRoomFee() {
		return roomFee;
	}

	public void setRoomFee(int roomFee) {
		this.roomFee = roomFee;
	}

	public int getMessFees() {
		return messFees;
	}

	public void setMessFees(int messFees) {
		this.messFees = messFees;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
}
