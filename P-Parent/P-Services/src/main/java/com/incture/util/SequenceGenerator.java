package com.incture.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {

	volatile static int n = 1;

	public static synchronized int nextNum() {
		return n++;
	}

	@Autowired
	private static SessionFactory sessionFactory;


	public static Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e){
			e.printStackTrace();
			return sessionFactory.openSession();
		}

	}

	public static String getLatestKey(Object o,String column ){

		String queryString = "Select max( cls."+column+") from "+o.getClass()+" cls ";

		Query q = getSession().createQuery(queryString);
		return (String) q.uniqueResult();

	}

	public static String getNextKey(Object o,String column){
		String current = getLatestKey( o, column );
		String currentHeader = current.substring(0,3);
		String currentNo = current.substring(3,current.length());
		int currentNoLength = currentNo.length();
		double nextNo = Double.parseDouble(currentNo) + 1;
		String nextNum = String.valueOf(nextNo);

		if(current.length()<nextNum.length()){
			currentNoLength= currentNoLength+1;
		}
		return currentHeader +String.format("%0"+currentNoLength+"f", nextNo); 
	}

}
