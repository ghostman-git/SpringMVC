package org.zpb.spring.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {
	
	@RequestMapping("upload")
	public String upload(@RequestParam("file") CommonsMultipartFile multipartFile) throws IOException{
		System.out.println("fileName---->" + multipartFile.getOriginalFilename());
		if(!multipartFile.isEmpty()){
			try {
				FileOutputStream os = new FileOutputStream("D:/" + new Date().getTime() + multipartFile.getOriginalFilename());
				InputStream in = multipartFile.getInputStream();
				int b = 0;
				while((b=in.read()) != -1){
					os.write(b);
				}
				os.flush();
				os.close();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "upload";
	}
	
	@RequestMapping("upload2")
	public String upload2(HttpServletRequest request, HttpServletResponse reponse) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			Iterator<String> iterator = multipartRequest.getFileNames();
			while(iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile(iterator.next());
				String fileName = file.getOriginalFilename();
				File localFile = new File("d:"+File.separator+fileName);
				try {
					file.transferTo(localFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
			}
		}
		return "upload";
	}
}
