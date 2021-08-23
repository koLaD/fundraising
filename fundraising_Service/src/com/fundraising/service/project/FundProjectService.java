package com.fundraising.service.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundraising.dao.project.FundProjectDAO;
import com.fundraising.entity.FundraisingProject;
import com.fundraising.util.FundraisingProjectDTO;
import com.fundraising.util.UserDTO;
import com.fundraising.util.common.CommonUtil;
import com.fundraising.util.common.ImageConstant;
import com.fundraising.util.common.ImageUtil;

@Service
@Transactional
public class FundProjectService {

	@Autowired
	private FundProjectDAO fundProjectDAO;

	public Long manageProject(FundraisingProjectDTO projectDTO, UserDTO loggedInUser) {
		FundraisingProject fundraisingProject = new FundraisingProject();
		String oldImage = "";
		try {
			if (CommonUtil.isValidLong(projectDTO.getId())) {
				fundraisingProject = fundProjectDAO.get(projectDTO.getId());
				fundraisingProject.setUpdatedUserId(loggedInUser.getId());
				fundraisingProject.setUpdatedDate(new Date());
				oldImage = fundraisingProject.getImage();
			} else {
				fundraisingProject.setCreatedUserId(loggedInUser.getId());
				fundraisingProject.setCreatedDate(new Date());
			}
			fundraisingProject = projectDTO.changeToEntity(fundraisingProject);

			if (projectDTO.getProjectImageFile() != null && projectDTO.getProjectImageFile().getSize() > 0) {
				fundraisingProject.setImage(System.currentTimeMillis() + ".jpg");
			}

			fundProjectDAO.saveOrUpdate(fundraisingProject);

			if (CommonUtil.isValidLong(fundraisingProject.getId())) {
				if (CommonUtil.isValidString(oldImage)
						&& (projectDTO.getProjectImageFile() != null && projectDTO.getProjectImageFile().getSize() > 0)) {
					ImageUtil.deleteImage(ImageConstant.FUND_PROJECT_DIRECTORY, oldImage);
				}
				if (projectDTO.getProjectImageFile() != null && projectDTO.getProjectImageFile().getSize() > 0) {
					ImageUtil.writeMultipartFile(projectDTO.getProjectImageFile(), ImageConstant.FUND_PROJECT_DIRECTORY,
							fundraisingProject.getImage());
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return fundraisingProject.getId();
	}

	public FundraisingProjectDTO getProjectById(Long projectId) {
		return new FundraisingProjectDTO(fundProjectDAO.get(projectId));
	}

	public List<FundraisingProjectDTO> searchProjectByCriteria(FundraisingProjectDTO criteria) {
		List<FundraisingProjectDTO> dtoList = new ArrayList<>();
		List<FundraisingProject> list =  fundProjectDAO.searchProjectByCriteria(criteria);
		if(CommonUtil.isValidList(list)) {
			for(FundraisingProject fp: list) {
				dtoList.add(new FundraisingProjectDTO(fp,criteria.getBasePath()));
			}
		}
		return dtoList;
	}

	public Integer getAllRowCount(FundraisingProjectDTO criteria) {
		return fundProjectDAO.getAllRowCount(criteria);
	}

}
