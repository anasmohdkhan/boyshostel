package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.FeesDao;
import com.javarnd.boyshostel.model.Fees;

/**
 * @author Anas This is Service layer for Fees Opertaion
 *
 */
@Service
@Transactional
public class FeesServiceImpl implements FeesService {

	@Autowired
	private Fees fees;
	@Autowired
	private FeesDao feesDao;

	@Override
	public void insert(Fees fees) throws SQLException {

		feesDao.insert(fees);

	}

	@Override
	public void delete(Fees fees) throws SQLException {

		feesDao.delete(fees);

	}

	@Override
	public Fees findById(int feeId) throws SQLException {

		fees = feesDao.findById(feeId);

		return fees;
	}

	@Override
	public List<Fees> findAll() throws SQLException {

		List<Fees> listFees = new ArrayList<Fees>();
		listFees = feesDao.findAll();

		return listFees;
	}

}
