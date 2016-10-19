package com.rohit.order.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.rohit.order.model.Item;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Item getItemDetails(long id) throws Exception {
		session = sessionFactory.openSession();
		Item item = (Item) session.load(Item.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return item;
	}

}
