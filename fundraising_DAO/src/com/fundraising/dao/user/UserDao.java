package com.fundraising.dao.user;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.User;

@Repository
@Transactional
public class UserDao extends GenericDAO<User, Long> {

	@Autowired
	SessionFactory sessionFactory;

	public User checkAuthentication(String phoneNumber, String password) {
		try {
			Criteria c = getCurrentSession().createCriteria(User.class);
			c.add(Restrictions.eq("phoneNo", phoneNumber));
			c.add(Restrictions.eq("password", password));
			c.add(Restrictions.eq("userStatus", 1));
			User user = (User) c.uniqueResult();
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

}
