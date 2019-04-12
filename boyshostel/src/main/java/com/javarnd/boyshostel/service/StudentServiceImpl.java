package com.javarnd.boyshostel.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.StudentDao;
import com.javarnd.boyshostel.model.Student;

/**
 * @author Anas Service Layer For Student Operations
 *
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private Student student;
	
	@Autowired
	private	StudentDao studentDao;

	@Override
	public void insert(Student student) throws SQLException {

		studentDao.insert(student);

	}

	@Override
	public void delete(Student student) throws SQLException {

		studentDao.delete(student);

	}

}
