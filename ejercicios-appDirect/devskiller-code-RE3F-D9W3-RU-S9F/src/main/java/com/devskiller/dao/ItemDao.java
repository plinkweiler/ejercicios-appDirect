package com.devskiller.dao;

import com.devskiller.model.Item;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class ItemDao extends HibernateDaoSupport {

	public Page<Item> findItems(PageRequest pageRequest) {
		  Session session = ItemDao.this.getSessionFactory().openSession();
		  int pageNumber = pageRequest.getPageNumber();
		  int pageSize = pageRequest.getCount();
		  List <Item> itemList = new ArrayList<Item>();
		  try {
		  
		  Query query = session.createQuery("From Item");
		  
		  query.setFirstResult((pageNumber-1) * pageSize); 
		  query.setMaxResults(pageSize);
		  itemList = query.list();
		  
		  } catch (HibernateException e) {
	          e.printStackTrace();
	      } finally {
	          session.close();
	      }
		  return new Page<>(itemList, pageNumber, pageSize);
	    
	  }

	  public List<Item> findItemsWithAverageRatingLowerThan(Integer rating) {
		  
		  Session session = ItemDao.this.getSessionFactory().openSession();
		  List <Item> itemList = new ArrayList<Item>();
		  try {
		  String avgHql = "select item From Item item, Review review where item.id = review.item.id group by item having avg(review.rating) <:rating";
		  Query query = session.createQuery(avgHql);
		  query.setParameter("rating", rating.doubleValue());
		  
		  itemList = query.list();
		  } catch (HibernateException e) {
	          e.printStackTrace();
	      } finally {
	          session.close();
	      }
		  
	    return itemList;
	  }


}
