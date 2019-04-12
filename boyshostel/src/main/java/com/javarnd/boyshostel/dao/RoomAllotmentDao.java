package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.RoomAllotment;

public interface RoomAllotmentDao {

	public void insert(RoomAllotment roomAllotment) throws SQLException;

	public void delete(RoomAllotment roomAllotment) throws SQLException;

	public RoomAllotment findById(int roomAllotmentId) throws SQLException;

	public List<RoomAllotment> findAll() throws SQLException;

}
