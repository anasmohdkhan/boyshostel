package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.ReportDao;
import com.javarnd.boyshostel.model.Report;

/**
 * @author Anas This is a service layer for Operations on report entity
 *
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private Report report;

	@Autowired
	private ReportDao reportDao;

	@Override
	public void insert(Report report) throws SQLException {

		reportDao.insert(report);

	}

	@Override
	public void delete(Report report) throws SQLException {

		reportDao.delete(report);

	}

	@Override
	public Report findById(int reportId) throws SQLException {

		report = reportDao.findById(reportId);

		return report;
	}

	@Override
	public List<Report> findAll() throws SQLException {

		List<Report> listReport = new ArrayList<Report>();
		listReport = reportDao.findAll();

		return listReport;
	}

}
