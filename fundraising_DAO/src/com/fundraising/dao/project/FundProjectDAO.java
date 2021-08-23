package com.fundraising.dao.project;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.FundraisingProject;
import com.fundraising.util.FundraisingProjectDTO;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

@Repository
@Transactional
public class FundProjectDAO extends GenericDAO<FundraisingProject, Long> {

	public List<FundraisingProject> searchProjectByCriteria(FundraisingProjectDTO criteria) {
		Criteria c = getCurrentSession().createCriteria(FundraisingProject.class);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.createAlias("category", "c", JoinType.LEFT_OUTER_JOIN);

		if (CommonUtil.isValidString(criteria.getTitle())) {
			c.add(Restrictions.like("title", criteria.getTitle(), MatchMode.ANYWHERE));
		}

		if (CommonUtil.isValidLong(criteria.getCategoryId())) {
			c.add(Restrictions.eq("c.id", criteria.getCategoryId()));
		}

		if (CommonUtil.isValidString(criteria.getProjectStatus())) {
			c.add(Restrictions.eq("projectStatus", criteria.getProjectStatus()));
		}

		if (criteria.getPageNo() > 0) {
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
		c.createAlias("category", "c", JoinType.LEFT_OUTER_JOIN);

		if (CommonUtil.isValidString(criteria.getTitle())) {
			c.add(Restrictions.like("title", criteria.getTitle(), MatchMode.ANYWHERE));
		}

		if (CommonUtil.isValidLong(criteria.getCategoryId())) {
			c.add(Restrictions.eq("c.id", criteria.getCategoryId()));
		}

		if (CommonUtil.isValidString(criteria.getProjectStatus())) {
			c.add(Restrictions.eq("projectStatus", criteria.getProjectStatus()));
		}
		c.setProjection(Projections.rowCount());
		Long count = (Long) c.uniqueResult();
		return count != null ? count.intValue() : null;
	}

}
