package com.insynergy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.insynergy.dao.FileUploadDAO;
import com.insynergy.model.UploadFile;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadDAO fileUploadDAO;
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "upload";
    }
	
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                UploadFile uploadFile = new UploadFile();
                
                System.out.println("Saving fileddddddddddddddddddddddddddddddd: " );
                
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                System.out.println("Saving fileddddddddddddddddddddddddddddddd111111111111111: " +aFile.getBytes());
                
                fileUploadDAO.save(uploadFile);  
                
                System.out.println("Saving fileddddddddddddddddddddddddddddddd22222222222222222222: " );
            }
        }
  
        return "success";
    }  

}
