package com.fundraising.dao.project;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.generics.GenericDAO;
import com.fundraising.entity.FundraisingProject;

@Repository
@Transactional
public class FundProjectDAO extends GenericDAO<FundraisingProject, Long> {

}
