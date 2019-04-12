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

import com.javarnd.boyshostel.model.RoomAllotment;

@Repository
public class RoomAllotmentDaoImpl implements RoomAllotmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private RoomAllotment roomAllotment;

	@Override
	public void insert(RoomAllotment roomAllotment) throws SQLException {

		getSession().saveOrUpdate(roomAllotment);
	}

	@Override
	public void delete(RoomAllotment roomAllotment) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		roomAllotment = currentSession.get(RoomAllotment.class, roomAllotment.getRoomAllotmentId());
		currentSession.delete(roomAllotment);
	}

	@Override
	public RoomAllotment findById(int roomAllotmentId) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<RoomAllotment> criteriaQuery = criteriaBuilder.createQuery(RoomAllotment.class);
		Root<RoomAllotment> rootRoomAllotment = criteriaQuery.from(RoomAllotment.class);

		criteriaQuery.select(rootRoomAllotment);

		criteriaQuery.where(criteriaBuilder.equal(rootRoomAllotment.get("roomAllotmentId"), roomAllotmentId));

		Query<RoomAllotment> query = currentSession.createQuery(criteriaQuery);

		roomAllotment = query.uniqueResult();
		return roomAllotment;

	}

	@Override
	public List<RoomAllotment> findAll() throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		List<RoomAllotment> listRoomAllotment = new ArrayList<RoomAllotment>();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<RoomAllotment> criteriaQuery = criteriaBuilder.createQuery(RoomAllotment.class);
		Root<RoomAllotment> rootRoomAllotment = criteriaQuery.from(RoomAllotment.class);

		criteriaQuery.select(rootRoomAllotment);

		Query<RoomAllotment> query = currentSession.createQuery(criteriaQuery);

		listRoomAllotment = query.list();
		return listRoomAllotment;

	}

}
