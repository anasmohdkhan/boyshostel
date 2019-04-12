package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.RoomDao;
import com.javarnd.boyshostel.model.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private Room room;

	@Autowired
	private RoomDao roomDao;

	@Override
	public void insert(Room room) throws SQLException {

		roomDao.insert(room);

	}

	@Override
	public void delete(Room room) throws SQLException {

		roomDao.delete(room);

	}

	@Override
	public Room findById(int roomId) throws SQLException {

		room = roomDao.findById(roomId);

		return room;
	}

	@Override
	public List<Room> findAll() throws SQLException {

		List<Room> listRoom = new ArrayList<Room>();
		listRoom = roomDao.findAll();

		return listRoom;
	}

}
