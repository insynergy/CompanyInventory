package com.insynergy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public boolean login(String userName, String userPassword) {
		System.out.println("In Check login");
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String sql=" from Login as o where  o.uname=? and o.pwd=?";
		Query query=session.createQuery(sql);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list=query.list();
		
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		return userFound;
	}
     
}
