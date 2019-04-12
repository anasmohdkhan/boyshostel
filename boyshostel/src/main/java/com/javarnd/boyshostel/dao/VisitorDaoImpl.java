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

import com.javarnd.boyshostel.model.Visitor;

/**
 * @author Developer Class to handle all Visitors related operation
 *
 */
@Repository
public class VisitorDaoImpl implements VisitorDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private Visitor visitor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.VisitorDao#insert(com.javarnd.apnahostel.model
	 * .Visitor) This method is to insert and Update all the visitor related
	 * data
	 * 
	 * 
	 */
	@Override
	public void insert(Visitor visitor) throws SQLException {

		getSession().saveOrUpdate(visitor);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.VisitorDao#findAll()
	 * 
	 * This method is to view all the visitor record
	 */
	@Override
	public List<Visitor> findAll() throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		List<Visitor> listVisitor = new ArrayList<Visitor>();

		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Visitor> criteriaQuery = criteriaBuilder.createQuery(Visitor.class);
		Root<Visitor> rootUser = criteriaQuery.from(Visitor.class);
		rootUser.join("");

		Query<Visitor> query = currentSession.createQuery(criteriaQuery);

		listVisitor = query.list();
		return listVisitor;
	}

}
