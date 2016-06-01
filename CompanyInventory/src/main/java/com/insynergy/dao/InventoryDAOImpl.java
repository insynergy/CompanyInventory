package com.insynergy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.annotations.QueryBinder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.insynergy.model.Inventory;
import com.insynergy.model.Login;

@Repository
public class InventoryDAOImpl implements InventoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addInventory(Inventory i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(i);
		logger.info("Inventory saved successfully, Inventory Details="+i);
	}

	@Override
	public void updateInventory(Inventory i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(i);
		logger.info("Person updated successfully, Person Details="+i);
	}
	
	/*@Override
	public void enterOtp(Inventory p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		logger.info("OTP entered successfully, Person Details="+p);
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> listInventories() {
		System.out.println("===========List DAO class");
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Inventory> inventoriesList = session.createQuery("from Inventory").list();
		for(Inventory i : inventoriesList){
			logger.info("Inventory List::"+i);
		}
		return inventoriesList;
	}

	@Override
	public Inventory getInventoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Inventory i = (Inventory) session.load(Inventory.class, new Integer(id));
		logger.info("Inventory loaded successfully, Person details="+i);
		return i;
	}

	@Override
	public void removeInventory(int id) {
		System.out.println("=========== remove DAO class");
		
		Session session = this.sessionFactory.getCurrentSession();
		Inventory i = (Inventory) session.load(Inventory.class, new Integer(id));
		if(null != i){
			session.delete(i);
		}
		logger.info("Inventory deleted successfully, person details="+i);
	}

	@Override
	public void sendNotification(Inventory i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(i);
		logger.info("OTP entered successfully, Person Details="+i);
		
	}

	

	/*@Override
	public List<Inventory> searchForInventory(String searchText) {
		Session session = this.sessionFactory.getCurrentSession();
		
		
		
		
		
		 FullTextSession fullTextSession = Search.getFullTextSession(session);
		 
		 QueryBuilder qb = fullTextSession.getSearchFactory()
		           .buildQueryBuilder().forEntity(Inventory.class).get();
		         org.apache.lucene.search.Query query = qb
		           .keyword().onFields("name", "count", "model","serialNo","make","price","date","remarks")
		           .matching(searchText)
		           .createQuery();
		         org.hibernate.Query hibQuery = 
		                 fullTextSession.createFullTextQuery(query, Inventory.class);
		         
		         List<Inventory> results = hibQuery.list();
		         return results;

		
		
	}*/
	
	
	@Override
	public List<Inventory> doSearch( String searchIteam) {
		 Session session = this.sessionFactory.getCurrentSession();
		
		 List<Inventory> inventoriesList;
		// String s="name";
		// if(nameModelMake.equals("name")){
			 System.out.println("Please enter the search");
			 inventoriesList=this.doSearchByName(searchIteam);
			 System.out.println("enter the search name called");
			 if(inventoriesList.isEmpty()){
				 inventoriesList=this.doSearchByModel(searchIteam);
				 System.out.println("enter the search name called list is empty and model called");
				 
				 if(inventoriesList.isEmpty()){
					 inventoriesList=this.doSearchByMake(searchIteam);
					 System.out.println("enter the search name/model  called and make model called"); 
				 }
				 else {
					 System.out.println(" return the model wisecalled");
					 return inventoriesList ; 
				 } 
			 }
			 else {
				 System.out.println(" returnthe search name wise called");
				 return inventoriesList ; 
			 }
			return inventoriesList;
			 
			 
			 
			 
		/*	 
		 return inventoriesList ; 
		 }
		 else if(nameModelMake.equals("model")){
			 inventoriesList=this.doSearchByModel(searchIteam);
			 
			 
			 return inventoriesList ;
		 }
		 
		 else if(nameModelMake.equals("make")){
			 inventoriesList=this.doSearchByMake(searchIteam);
			 
			 
			return inventoriesList ;
		 }
		 else{*/
			 //inventoriesList=this.
			
		// List <Inventory>  listinventary=this.doSearchByMake(searchIteam);
			
			// listinventary.clear();
			// return listinventary;
		// }
         //List<Inventory> inventoriesList = session.createQuery("from Inventory").list();
           /**/
        /* Criteria cr = session.createCriteria(Inventory.class);
         cr.add(Restrictions.eq("name", "laptop"));
          inventoriesList = cr.list();
      */
           //return inventoriesList ;
			 
	}

	public List<Inventory> doSearchByName(String searchIteam) {
		 Session session = this.sessionFactory.getCurrentSession();
		
        //List<Inventory> inventoriesList = session.createQuery("from Inventory").list();
          /**/
        Criteria cr = session.createCriteria(Inventory.class);
        cr.add(Restrictions.eq("name", searchIteam));
        List inventoriesList = cr.list();
     
          return inventoriesList ;
	}
	public List<Inventory> doSearchByModel(String searchIteam) {
		 Session session = this.sessionFactory.getCurrentSession();
		
        //List<Inventory> inventoriesList = session.createQuery("from Inventory").list();
          /**/
        Criteria cr = session.createCriteria(Inventory.class);
        cr.add(Restrictions.eq("model", searchIteam));
        List inventoriesList = cr.list();
     
          return inventoriesList ;
	}

	public List<Inventory> doSearchByMake(String searchIteam) {
		 Session session = this.sessionFactory.getCurrentSession();
		
        //List<Inventory> inventoriesList = session.createQuery("from Inventory").list();
          /**/
        Criteria cr = session.createCriteria(Inventory.class);
        cr.add(Restrictions.eq("make", searchIteam));
        List inventoriesList = cr.list();
     
          return inventoriesList ;
	}




	

}
