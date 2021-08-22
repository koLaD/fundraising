package com.fundraising.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.user.UserDao;
import com.fundraising.entity.User;
import com.fundraising.util.UserDTO;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserDTO checkAuthentication(String phoneNo, String password) {
		User user = userDao.checkAuthentication(phoneNo, password);
		UserDTO dto = null;
		if (user != null) {
			dto = new UserDTO(user);
		}
		return dto;
	}

}
