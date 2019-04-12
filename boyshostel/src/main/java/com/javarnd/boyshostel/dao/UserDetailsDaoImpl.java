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

import com.javarnd.boyshostel.model.UserDetails;

/**
 * @author Anas This class handles all the user related operations
 *
 */
@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private UserDetails userDetails;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.UserDetailsDao#insert(com.javarnd.apnahostel.
	 * model.UserDetails) This method is to insert and update the user details
	 * in database
	 */

	@Override
	public void insert(UserDetails userDetails) throws SQLException {

		getSession().saveOrUpdate(userDetails);
		//getSession().merge(userDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.UserDetailsDao#delete(com.javarnd.apnahostel.
	 * model.UserDetails) This method is used to delete all the details of a
	 * particular user
	 */
	@Override
	public void delete(UserDetails userDetails) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		userDetails = currentSession.get(UserDetails.class, userDetails.getUserId());
		currentSession.delete(userDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.UserDetailsDao#findById(int) This method
	 * will belong to admin to see all the details of a particular user with
	 * using join on student table.
	 */
	@Override
	public UserDetails findById(int userId) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
		Root<UserDetails> rootUser = criteriaQuery.from(UserDetails.class);

		criteriaQuery.select(rootUser);

		criteriaQuery.where(criteriaBuilder.equal(rootUser.get("userId"), userId));

		Query<UserDetails> query = currentSession.createQuery(criteriaQuery);

		userDetails = query.uniqueResult();
		return userDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.UserDetailsDao#findAll() This method will
	 * belong to admin to see all the details of all the users
	 */
	@Override
	public List<UserDetails> findAll() throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		List<UserDetails> listUser = new ArrayList<UserDetails>();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
		Root<UserDetails> rootUser = criteriaQuery.from(UserDetails.class);
		criteriaQuery.select(rootUser);

		Query<UserDetails> query = currentSession.createQuery(criteriaQuery);

		listUser = query.list();
		return listUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.UserDetailsDao#findByName(java.lang.String)
	 * Using this method you can search a user by Name.
	 */
	@Override
	public List<UserDetails> findByName(String name) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		List<UserDetails> listUser = new ArrayList<UserDetails>();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
		Root<UserDetails> rootUser = criteriaQuery.from(UserDetails.class);

		criteriaQuery.select(rootUser);

		criteriaQuery.where(criteriaBuilder.equal(rootUser.get("userName"), name));

		Query<UserDetails> query = currentSession.createQuery(criteriaQuery);

		listUser = query.list();
		return listUser;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.UserDetailsDao#checkAuthentication(java.lang.
	 * String, java.lang.String) This method will be used for login. Using this
	 * method the admin/user will be login and send to there respective
	 * dashboard.
	 */
	@Override
	public UserDetails checkAuthentication(String email, String password) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from UserDetails where email= :email and password = :password ");
		query.setParameter("email", email);
		query.setParameter("password", password);

		userDetails = (UserDetails) query.uniqueResult();
		System.out.println("here"+userDetails.getUserName());
		System.out.println("here"+userDetails.getUserId());
		
		return userDetails;
	}

}
