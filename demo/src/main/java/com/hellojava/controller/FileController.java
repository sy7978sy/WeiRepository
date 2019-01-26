package com.hellojava.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FileController {
	@RequestMapping("/file")
	public String file() {
		return "upload";
	}
	@ResponseBody
	@RequestMapping("/uploadFileHandler")
	public boolean fileUpload(@RequestParam("uploadfile")MultipartFile uploadfile,String fileName,HttpServletRequest request) {
		String path=request.getServletContext().getRealPath("/upload");
		File fileRoot=new File(path);
		if(!fileRoot.exists()) {
			fileRoot.mkdirs();
		}
		boolean bool=false;
		try {
			InputStream file=uploadfile.getInputStream();
			byte[] bs=new byte[file.available()];
			file.read(bs, 0, bs.length);
			file.close();
			FileOutputStream out=new FileOutputStream(path+"/"+uploadfile.getOriginalFilename());
			out.write(bs, 0, bs.length);
			out.flush();
			out.close();
			bool=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bool;
	}
}
