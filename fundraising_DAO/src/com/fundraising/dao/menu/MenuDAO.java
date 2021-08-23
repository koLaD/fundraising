package com.fundraising.dao.menu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.Menu;

@Repository
@Transactional
public class MenuDAO extends GenericDAO<Menu, Long> {

	public List<Menu> getAllMenu() {
		try {
			Criteria c = getCurrentSession().createCriteria(Menu.class);
			c.addOrder(Order.asc("orderNo"));
			List<Menu> menuList = c.list();
			return menuList;
		} catch (Exception e) {
			throw e;
		}
	}

}
