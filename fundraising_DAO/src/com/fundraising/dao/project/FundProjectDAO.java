package com.fundraising.dao.project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.DateType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.FundraisingProject;
import com.fundraising.util.FundraisingProjectDTO;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;
import com.fundraising.util.enumeration.ProjectStatus;

@Repository
@Transactional
public class FundProjectDAO extends GenericDAO<FundraisingProject, Long> {

	public List<FundraisingProject> searchProjectByCriteria(FundraisingProjectDTO criteria) {
		Criteria c = getCurrentSession().createCriteria(FundraisingProject.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (CommonUtil.isValidString(criteria.getTitle())) {
			c.add(Restrictions.like("title", criteria.getTitle(), MatchMode.ANYWHERE));
		}

		if (CommonUtil.isValidString(criteria.getProjectStatus())) {
			c.add(Restrictions.eq("projectStatus", criteria.getProjectStatus()));
		}

		if (CommonUtil.isValidString(criteria.getFromDate()) && CommonUtil.isValidString(criteria.getToDate())) {
			Date fromDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getFromDate());
			Date toDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getToDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') >= ?", fromDate, DateType.INSTANCE));
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') <= ?", toDate, DateType.INSTANCE));

		} else if (CommonUtil.isValidString(criteria.getFromDate())) {
			Date fromDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getFromDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') >= ?", fromDate, DateType.INSTANCE));

		} else if (CommonUtil.isValidString(criteria.getToDate())) {
			Date toDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getToDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') <= ?", toDate, DateType.INSTANCE));

		}

		if (CommonUtil.isValidInteger(criteria.getPageNo())) {
			Integer startIndex = (criteria.getPageNo() - 1) * CommonConstant.ROW_PER_PAGE;
			if (startIndex > -1) {
				c.setFirstResult(startIndex);
				c.setMaxResults(CommonConstant.ROW_PER_PAGE);
			}
		}

		c.addOrder(Order.desc("createdDate"));

		List<FundraisingProject> results = c.list();
		return (results.isEmpty() || results == null) ? null : results;
	}

	public Integer getAllRowCount(FundraisingProjectDTO criteria) {
		Criteria c = getCurrentSession().createCriteria(FundraisingProject.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (CommonUtil.isValidString(criteria.getTitle())) {
			c.add(Restrictions.like("title", criteria.getTitle(), MatchMode.ANYWHERE));
		}

		if (CommonUtil.isValidString(criteria.getProjectStatus())) {
			c.add(Restrictions.eq("projectStatus", criteria.getProjectStatus()));
		}

		if (CommonUtil.isValidString(criteria.getFromDate()) && CommonUtil.isValidString(criteria.getToDate())) {
			Date fromDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getFromDate());
			Date toDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getToDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') >= ?", fromDate, DateType.INSTANCE));
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') <= ?", toDate, DateType.INSTANCE));

		} else if (CommonUtil.isValidString(criteria.getFromDate())) {
			Date fromDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getFromDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') >= ?", fromDate, DateType.INSTANCE));

		} else if (CommonUtil.isValidString(criteria.getToDate())) {
			Date toDate = CommonUtil.stringToDate(CommonConstant.STD_DATE_FORMAT, criteria.getToDate());
			c.add(Restrictions.sqlRestriction("DATE_FORMAT({alias}.CreatedTime, '%Y-%m-%d') <= ?", toDate, DateType.INSTANCE));

		}
		c.setProjection(Projections.rowCount());
		Long count = (Long) c.uniqueResult();
		return count != null ? count.intValue() : null;
	}

	public List<FundraisingProjectDTO> getAllProject() {
		try {
			StringBuilder sqlbuilder = new StringBuilder();
			sqlbuilder.append(" SELECT DISTINCT a.Id ,a.Title");
			sqlbuilder.append(" FROM `fundraising_project` a");
			sqlbuilder.append(" WHERE a.Status = :status ");
			sqlbuilder.append(" ORDER BY a.createdDate DESC");

			Query query = this.getCurrentSession().createSQLQuery(sqlbuilder.toString());
			query.setParameter("status", ProjectStatus.OPEN.getCode());
			List<FundraisingProjectDTO> result = new ArrayList<>();
			List<Object[]> objList = query.list();
			objList.stream().forEach(obj -> {
				result.add(new FundraisingProjectDTO((BigInteger) obj[0], (String) obj[1]));
			});
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

}
