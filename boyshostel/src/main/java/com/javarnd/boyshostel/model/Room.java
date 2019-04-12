package com.javarnd.boyshostel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * @author Anas This class contains the variables and getter setter methods used
 *         for Room details
 *
 */
@Component
@Entity(name = "Room")
public class Room {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	private String roomNo;
	private String buildingNo;
	private String blockNo;
	private String roomType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Report> report;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "room")
	private Fees fees;
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="room", fetch=FetchType.LAZY)
	private List<RoomAllotment> roomAllotment;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	
	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		this.fees = fees;
	}

	public List<Report> getReport() {
		return report;
	}

	public void setReport(List<Report> report) {
		this.report = report;
	}

	public List<RoomAllotment> getRoomAllotment() {
		return roomAllotment;
	}

	public void setRoomAllotment(List<RoomAllotment> roomAllotment) {
		this.roomAllotment = roomAllotment;
	}


}
