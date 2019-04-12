package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.Room;

public interface RoomDao {

	public void insert(Room room) throws SQLException;

	public void delete(Room room) throws SQLException;

	public Room findById(int roomId) throws SQLException;

	public List<Room> findAll() throws SQLException;

}
