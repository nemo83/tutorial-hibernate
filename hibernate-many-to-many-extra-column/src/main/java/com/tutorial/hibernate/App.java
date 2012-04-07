package com.tutorial.hibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorial.hibernate.model.Item;
import com.tutorial.hibernate.model.Product;
import com.tutorial.hibernate.model.ProductItem;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hibernate-tutorial");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Item item = new Item();
		item.setName("item0");

		Product product = new Product();
		product.setName("prod0");

//		Item item = em.find(Item.class, 1);
//		Product prod = em.find(Product.class, 10);
		
		ProductItem pi = new ProductItem();
		pi.setItem(item);
		pi.setProduct(product);
		
		item.setProductItems(new ArrayList<ProductItem>());
		
		item.getProductItems().add(pi);
		
		em.persist(product);
		em.persist(item);
		
//		ProductItem pi = new ProductItem();
//		pi.setProduct(product);
//		pi.setItem(item);

//		item.getProductItems().add(pi);

//		em.persist(item);
//		em.persist(product);

		tx.commit();
		em.close();

		// Session session = HibernateUtil.getSessionFactory().openSession();
		//
		// session.beginTransaction();
		//
		// Item item = new Item();
		// item.setName("item0");
		//
		// Product product = new Product();
		// product.setName("prod0");
		//
		// ProductItem pi = new ProductItem();
		// pi.setProduct(product);
		// pi.setItem(item);
		//
		// item.getProductItems().add(pi);
		//
		// session.save(item);
		// session.save(product);
		//
		// session.getTransaction().commit();
	}
}
