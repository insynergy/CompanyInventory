package com.insynergy.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.insynergy.model.UploadFile;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
	
    @Autowired
	private SessionFactory sessionFactory;
	
    public FileUploadDAOImpl() {
    }
 
    public FileUploadDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
		 
		sessionFactory.getCurrentSession().save(uploadFile);
		
		
    }
	

	}


