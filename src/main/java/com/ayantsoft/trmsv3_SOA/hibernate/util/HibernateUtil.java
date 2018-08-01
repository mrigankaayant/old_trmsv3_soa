package com.ayantsoft.trmsv3_SOA.hibernate.util;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil implements Serializable{
		
	/**
	 * sessionFactory
	 */
	private static final long serialVersionUID = -5231774211714915467L;
	
	private static Logger log = Logger.getLogger(HibernateUtil.class);
	
	private static SessionFactory sessionFactory;

	static{
		try{		
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Exception e){
			log.info("Hibernate Util Error : ", e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}