package com.javarnd.boyshostel.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.model.Student;

/**
 * @author Anas This class will handel operations on Student table
 *
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private Student student;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.StudentDao#insert(com.javarnd.apnahostel.model
	 * .Student) This is a method to insert and update Student Details
	 */
	@Override
	public void insert(Student student) throws SQLException {

		getSession().saveOrUpdate(student);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.StudentDao#delete(com.javarnd.apnahostel.model
	 * .Student) This method is to delete a particular student
	 */
	@Override
	public void delete(Student student) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		student = currentSession.get(Student.class, student.getUserId());
		currentSession.delete(student);
	}

}
