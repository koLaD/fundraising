package com.fundraising.util.common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static String uploadBase64File(String clientFileData, String subFolder, String prefixFileName, Long id)
			throws Exception {
		if (!CommonUtil.isNullOrEmpty(clientFileData)) {
			String fileName = generateFileNameForBase64(prefixFileName, id);
			byte[] decoded = Base64.decodeBase64(clientFileData);
			File dest = new File(ImageConstant.IMAGE_SAVE_DIRECTORY + subFolder, fileName);
			FileUtils.writeByteArrayToFile(dest, decoded);
			return subFolder + fileName;
		}
		return "";
	}

	private static String generateFileNameForBase64(String prefixFileName, Long id) {
		String nano_time = String.valueOf(System.nanoTime());
		String fileName = (prefixFileName != null && !prefixFileName.isEmpty()) ? prefixFileName + "_" : "";
		fileName = id + "_" + fileName + nano_time + ImageConstant.IMAGE_SUFFIX;
		return fileName;
	}

	public static void deleteImage(String subDirectory, String imageName) {
		if (!CommonUtil.isValidString(subDirectory) || !CommonUtil.isValidString(imageName)) {
			return;
		}
		File image = new File(ImageConstant.IMAGE_SAVE_DIRECTORY + subDirectory + imageName);
		if (image.exists()) {
			image.delete();
		}
	}

	public static void writeMultipartFile(MultipartFile multipartFile, String subDirectory, String imageName) {

		if (multipartFile == null || multipartFile.getSize() <= 0 || !CommonUtil.isValidString(subDirectory)
				|| !CommonUtil.isValidString(imageName)) {
			return;
		}

		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				File dir = new File(ImageConstant.IMAGE_SAVE_DIRECTORY + subDirectory);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				multipartFile.transferTo(new File(ImageConstant.IMAGE_SAVE_DIRECTORY + subDirectory + imageName));
			} catch (Exception e) {
			}
		}
	}

	public static String getBasePath(HttpServletRequest req) {
		return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + ImageConstant.IMAGE_CONTEXT_PATH;
	}
}
