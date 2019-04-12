package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.Room;

public interface RoomService {

	public void insert(Room room) throws SQLException;

	public void delete(Room room) throws SQLException;

	public Room findById(int roomId) throws SQLException;

	public List<Room> findAll() throws SQLException;

}
