package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.VisitorDao;
import com.javarnd.boyshostel.model.Visitor;

/**
 * @author Anas This is a service layer for visitor operation
 *
 */
@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private Visitor visitor ;
	
	@Autowired
	private	VisitorDao visitorDao;

	@Override
	public void insert(Visitor visitor) throws SQLException {

		visitorDao.insert(visitor);

	}

	@Override
	public List<Visitor> findAll() throws SQLException {

		List<Visitor> listVisitor = new ArrayList<Visitor>();

		listVisitor = visitorDao.findAll();

		return listVisitor;
	}

}
