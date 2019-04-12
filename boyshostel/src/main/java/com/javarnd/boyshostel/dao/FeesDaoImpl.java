package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javarnd.boyshostel.model.Fees;

/**
 * @author Anas This Class is to perform all the Fees Related Operations
 *
 */
@Repository
public class FeesDaoImpl implements FeesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Fees fees;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.FeesDao#insert(com.javarnd.apnahostel.model.
	 * Fees) This method is for insert or update Fees Details into DB
	 */
	@Override
	public void insert(Fees fees) throws SQLException {

		getSession().saveOrUpdate(fees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.FeesDao#delete(com.javarnd.apnahostel.model.
	 * Fees) This method is to Delete Fees Details into DB
	 */
	@Override
	public void delete(Fees fees) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		fees= currentSession.get(Fees.class, fees.getFeeId());
		currentSession.delete(fees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.FeesDao#findById(int) This method is to
	 * Find particular Fees Details By Id
	 */
	@Override
	public Fees findById(int feeId) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Fees> criteriaQuery = criteriaBuilder.createQuery(Fees.class);
		Root<Fees> rootFees = criteriaQuery.from(Fees.class);

		criteriaQuery.select(rootFees);

		criteriaQuery.where(criteriaBuilder.equal(rootFees.get("feeId"), feeId));

		Query<Fees> query = currentSession.createQuery(criteriaQuery);

		fees = query.uniqueResult();
		return fees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.FeesDao#findAll() This method is to Find
	 * All Fees Details
	 */
	@Override
	public List<Fees> findAll() throws SQLException {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Fees> criteriaQuery = criteriaBuilder.createQuery(Fees.class);
		Root<Fees> rootFees = criteriaQuery.from(Fees.class);

		criteriaQuery.select(rootFees);

		Query<Fees> query = currentSession.createQuery(criteriaQuery);

		List<Fees> listFees = query.list();

		return listFees;
	}

}
