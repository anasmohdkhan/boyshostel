package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.Fees;

public interface FeesDao {

	public void insert(Fees fees) throws SQLException;

	public void delete(Fees fees) throws SQLException;

	public Fees findById(int feeId) throws SQLException;

	public List<Fees> findAll() throws SQLException ;

}
