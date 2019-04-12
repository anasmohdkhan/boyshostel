package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javarnd.boyshostel.model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private Room room;

	@Override
	public void insert(Room room) throws SQLException {
		getSession().saveOrUpdate(room);

	}

	@Override
	public void delete(Room room) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		room = currentSession.get(Room.class, room.getRoomId());
		currentSession.delete(room);
	}

	@Override
	public Room findById(int roomId) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> rootRoom = criteriaQuery.from(Room.class);

		criteriaQuery.select(rootRoom);

		criteriaQuery.where(criteriaBuilder.equal(rootRoom.get("roomId"), roomId));

		Query<Room> query = currentSession.createQuery(criteriaQuery);

		room = query.uniqueResult();
		return room;

	}

	@Override
	public List<Room> findAll() throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		List<Room> listRoom = new ArrayList<Room>();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> rootRoom = criteriaQuery.from(Room.class);

		criteriaQuery.select(rootRoom);

		Query<Room> query = currentSession.createQuery(criteriaQuery);

		listRoom = query.list();
		return listRoom;

	}

}
