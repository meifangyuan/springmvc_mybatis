/**  
* @Title: FileOperater.java
* @Package com.org.meify.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author fymei  
* @date 2017年7月17日 下午3:52:00
* @version V1.0  
*/
package com.org.meify.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
* @ClassName: FileOperater
* @Description: 文件上传下载
* @author fymei
* @date 2017年7月17日 下午3:52:00
*
*/
@Controller
public class MultipartFileController {
	
	/**
	* @Title: toUpload
	* @Description: 进入文件上传页面
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("toUpload")
	public String toUpload(HttpServletRequest request) {
		return "file/upload";
	}
	
	/**
	* @Title: upload
	* @Description: 上传文件
	* @param @param request
	* @param @param file
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception{
		// 将上传文件保存至目标文件中
		if(!file.isEmpty()) {
			
			// 获取MultipartFile文件对象的相关属性
			String fileName = file.getName();
			System.out.println("fileName:" +fileName);
			String fileOriginName = file.getOriginalFilename();
			System.out.println("file origin name:" + fileOriginName);
			String contentType = file.getContentType();
			System.out.println("contentType:" + contentType);
			long size = file.getSize();
			System.out.println("file size:" + size);
			
			// 获取工程的绝对路径
			String projectAbsolutePath = request.getServletContext().getRealPath("");
			String destPath = projectAbsolutePath + "/images/" + file.getOriginalFilename();
			
			File destFile = new File(destPath);
			System.out.println("saveFile path:" + destFile.getAbsolutePath());
			file.transferTo(destFile);
			
			return "/common/success";
		}
		return "/common/fail";
	}
	
	/**
	* @Title: toDownload
	* @Description: 进入文件下载页面
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("toDownload")
	public String toDownload(HttpServletRequest request) {
		return "file/download";
	}

	/**
	* @Title: downLoad
	* @Description: 下载文件
	* @param @param request
	* @param @param fileName
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件
	* @return ResponseEntity<byte[]>    返回类型
	* @throws
	*/ 
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downLoad(HttpServletRequest request, @RequestParam("fileName") String fileName, Model model) throws Exception{
		// 下载的文件对象
		String filePath = request.getServletContext().getRealPath("/") + "WEB-INF/images/" + fileName;
		File file = new File(filePath);
		
		// 以附件的形式下载图片文件
		HttpHeaders httpHeader = new HttpHeaders();
		String downLoadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		httpHeader.setContentDispositionFormData("attachment", downLoadFileName);
		httpHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeader, HttpStatus.CREATED);
	}

}
