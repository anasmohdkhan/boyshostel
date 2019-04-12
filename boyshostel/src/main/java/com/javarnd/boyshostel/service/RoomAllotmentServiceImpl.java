package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.RoomAllotmentDao;
import com.javarnd.boyshostel.model.RoomAllotment;

@Service
@Transactional
public class RoomAllotmentServiceImpl implements RoomAllotmentService {

	@Autowired
	private RoomAllotment roomAllotment;

	@Autowired
	private RoomAllotmentDao roomAllotmentDao;

	@Override
	public void insert(RoomAllotment roomAllotment) throws SQLException {

		roomAllotmentDao.insert(roomAllotment);

	}

	@Override
	public void delete(RoomAllotment roomAllotment) throws SQLException {

		roomAllotmentDao.delete(roomAllotment);

	}

	@Override
	public RoomAllotment findById(int roomAllotmentId) throws SQLException {
		roomAllotment = roomAllotmentDao.findById(roomAllotmentId);
		return roomAllotment;
	}

	@Override
	public List<RoomAllotment> findAll() throws SQLException {

		List<RoomAllotment> listRoomAllotment = new ArrayList<RoomAllotment>();
		listRoomAllotment = roomAllotmentDao.findAll();

		return listRoomAllotment;
	}

}
