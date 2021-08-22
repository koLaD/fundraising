package com.banbann.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banbann.api.common.CommonAPI;
import com.banbann.api.common.Response;
import com.banbann.api.request.ItemRequest;
import com.banbann.service.item.ItemService;
import com.banbann.util.ItemDTO;
import com.banbann.util.common.CommonConstant;
import com.banbann.util.common.CommonUtil;
import com.banbann.util.common.FieldError;
import com.banbann.util.common.FieldError.ErrorMessage;
import com.banbann.util.common.FieldError.FieldCode;
import com.banbann.util.common.ProcessException;
import com.banbann.util.common.ProcessException.ErrorType;

@RestController
@RequestMapping(value = "/item")
public class ItemAPI extends CommonAPI {

	@Autowired
	private ItemService itemService;

	@PostMapping(value = "/addItems")
	public String addItems(HttpServletRequest request, @RequestBody ItemRequest itemRequest) {
		String result = "";
		ProcessException pe = null;
		List<FieldError> errorList = new ArrayList<FieldError>();
		Response<String> apiResponse = new Response<String>();
		Long userId = Long.parseLong(request.getHeader(CommonConstant.API_REQUEST_HEADER_USER_ID));
		try {
			if (isValidItem(itemRequest, errorList)) {
				ItemDTO itemDTO = changeToDTO(itemRequest);
				itemDTO.setCreatedUserId(userId);
				List<String> imageList = itemRequest.getImageList();
				itemService.addItems(itemDTO, imageList);
			} else {
				pe = new ProcessException(ErrorType.MULTIPLE_ERROR);
				pe.setFieldErrorList(errorList);
			}
		} catch (Exception e) {
			pe = new ProcessException(ErrorType.GENERAL);
		}
		result = formatJsonResponse(apiResponse, pe);
		return result;
	}

	@GetMapping(value = "/getItemCode")
	public String generateItemCode(HttpServletRequest request) {
		String result = "";
		ProcessException pe = null;
		Response<String> apiResponse = new Response<String>();
		Long userId = Long.parseLong(request.getHeader(CommonConstant.API_REQUEST_HEADER_USER_ID));
		try {
			String itemCode = itemService.generateItemCode();
			apiResponse.setData(itemCode);
		} catch (Exception e) {
			pe = new ProcessException(ErrorType.GENERAL);
		}
		result = formatJsonResponse(apiResponse, pe);
		return result;
	}

	private ItemDTO changeToDTO(ItemRequest itemRequest) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItemCode(itemRequest.getItemCode());
		itemDTO.setItemName(itemRequest.getItemName());
		itemDTO.setItemLink(itemRequest.getItemLink());
		itemDTO.setOriginalPrice(itemRequest.getOriginalPrice());
		itemDTO.setSellPrice(itemRequest.getSellPrice());
		return itemDTO;
	}

	private boolean isValidItem(ItemRequest itemRequest, List<FieldError> errorList) {
		boolean result = true;
		if (CommonUtil.isNullOrEmpty(itemRequest.getItemCode())) {
			setErrorMessage(FieldCode.ITEM_CODE.getCode(), ErrorMessage.ITEM_CODE_REQUIRED.getMessage(), errorList);
			result = false;
		}

		if (CommonUtil.isNullOrEmpty(itemRequest.getItemLink())) {
			setErrorMessage(FieldCode.ITEM_LINK.getCode(), ErrorMessage.ITEM_LINK_REQUIRED.getMessage(), errorList);
			result = false;
		}

		if (CommonUtil.isNullOrEmpty(itemRequest.getItemName())) {
			setErrorMessage(FieldCode.ITEM_NAME.getCode(), ErrorMessage.ITEM_NAME_REQUIRED.getMessage(), errorList);
			result = false;
		}
		if (CommonUtil.isNullOrZero(itemRequest.getOriginalPrice())) {
			setErrorMessage(FieldCode.ITEM_ORIGINAL_PRICE.getCode(),
					ErrorMessage.ITEM_ORIGINAL_PRICE_REQUIRED.getMessage(), errorList);
			result = false;
		}

		if (CommonUtil.isNullOrZero(itemRequest.getSellPrice())) {
			setErrorMessage(FieldCode.ITEM_SELL_PRICE.getCode(), ErrorMessage.ITEM_SELL_PRICE_REQUIRED.getMessage(),
					errorList);
			result = false;
		}

		if (CommonUtil.isNullOrEmpty(itemRequest.getImageList())) {
			setErrorMessage(FieldCode.ITEM_IMAGE_LIST.getCode(), ErrorMessage.ITEM_IMAGE_LIST_REQUIRED.getMessage(),
					errorList);
			result = false;
		}
		return result;
	}
}
