package com.fundraising.service.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.menu.MenuDAO;
import com.fundraising.entity.Menu;
import com.fundraising.util.MenuDTO;
import com.fundraising.util.common.CommonUtil;

@Service
@Transactional
public class MenuService {

	@Autowired
	private MenuDAO menuDao;

	public List<MenuDTO> getAllMenu() {
		List<Menu> list = menuDao.getAllMenu();
		List<MenuDTO> dtoList = new ArrayList<>();
		if (CommonUtil.isValidList(list)) {
			for (Menu menu : list) {
				dtoList.add(new MenuDTO(menu));
			}
		}
		return dtoList;
	}

}
