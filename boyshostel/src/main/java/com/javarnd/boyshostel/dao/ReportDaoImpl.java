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

import com.javarnd.boyshostel.model.Report;

/**
 * @author Anas This Class is to perform all the Report relatted operation
 *
 */
@Repository
public class ReportDaoImpl implements ReportDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private Report report;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.apnahostel.dao.ReportDao#insert(com.javarnd.apnahostel.model.
	 * Report) This method is for insert and update Reports details into DB
	 */
	@Override
	public void insert(Report report) throws SQLException {
		getSession().saveOrUpdate(report);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.ReportDao#delete(com.javarnd.apnahostel.
	 * model. Report) This method is to update Reports details into DB
	 */
	@Override
	public void delete(Report report) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		report = currentSession.get(Report.class, report.getReportId());
		currentSession.delete(report);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.ReportDao#findById(int) This method is to
	 * find a particular report by its Id
	 */
	@Override
	public Report findById(int Report) throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Report> criteriaQuery = criteriaBuilder.createQuery(Report.class);
		Root<Report> rootReport = criteriaQuery.from(Report.class);

		criteriaQuery.select(rootReport);

		criteriaQuery.where(criteriaBuilder.equal(rootReport.get("Report"), Report));

		Query<Report> query = currentSession.createQuery(criteriaQuery);

		report = query.uniqueResult();
		return report;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.apnahostel.dao.ReportDao#findAll() This method is to get
	 * all the details of available reports
	 * 
	 */
	@Override
	public List<Report> findAll() throws SQLException {

		Session currentSession = sessionFactory.getCurrentSession();

		List<Report> listReport = new ArrayList<Report>();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Report> criteriaQuery = criteriaBuilder.createQuery(Report.class);
		Root<Report> rootReport = criteriaQuery.from(Report.class);

		criteriaQuery.select(rootReport);

		Query<Report> query = currentSession.createQuery(criteriaQuery);

		listReport = query.list();
		return listReport;
	}

}
