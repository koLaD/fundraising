package com.fundraising.service.fundraiser;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.fundraiser.FundraiserDAO;
import com.fundraising.entity.Fundraiser;
import com.fundraising.util.FundraiserDTO;
import com.fundraising.util.UserDTO;
import com.fundraising.util.common.CommonUtil;

@Service
@Transactional
public class FundraiserService {

	@Autowired
	private FundraiserDAO fundraiserDao;

	public FundraiserDTO getFundraiserById(Long id) {
		Fundraiser fundraiser = fundraiserDao.get(id);
		if (fundraiser != null) {
			return new FundraiserDTO(fundraiser);
		}
		return null;
	}

	public Long manageFundraiser(FundraiserDTO fundraiserDTO, UserDTO loggedInUser) {
		Fundraiser fundraiser = new Fundraiser();
		try {
			if (CommonUtil.isValidLong(fundraiserDTO.getId())) {
				fundraiser = fundraiserDao.get(fundraiserDTO.getId());
				fundraiser.setUpdatedUserId(loggedInUser.getId());
				fundraiser.setUpdatedDate(new Date());
			} else {
				fundraiser.setCreatedUserId(loggedInUser.getId());
				fundraiser.setCreatedDate(new Date());
			}
			fundraiser = fundraiserDTO.changeToEntity(fundraiser);
			fundraiserDao.saveOrUpdate(fundraiser);
		} catch (Exception e) {
			throw e;
		}
		return fundraiser.getId();
	}

}
