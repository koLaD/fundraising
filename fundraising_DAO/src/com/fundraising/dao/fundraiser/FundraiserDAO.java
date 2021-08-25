package com.fundraising.dao.fundraiser;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.Fundraiser;

@Repository
@Transactional
public class FundraiserDAO extends GenericDAO<Fundraiser, Long> {

}
