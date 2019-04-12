package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.RoomAllotment;

public interface RoomAllotmentService {

	public void insert(RoomAllotment roomAllotment) throws SQLException;

	public void delete(RoomAllotment roomAllotment) throws SQLException;

	public RoomAllotment findById(int roomAllotmentId) throws SQLException;

	public List<RoomAllotment> findAll() throws SQLException;

}
