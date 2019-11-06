package com.ecna.hibernate.ejemplojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory( "com.ecna.hibernate.ejemplojpa" );
    	
    	EntityManager entityManager = sessionFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
    	
    	entityManager.persist( new Event( "Our very first event!", new Date(), 1, "" ) );
    	entityManager.persist( new Event( "A follow up event", new Date() , 2, "") );
    	
    	entityManager.getTransaction().commit();
    	
    	entityManager.close();
    	
    	entityManager = sessionFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
    	
    	List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
    	
    	for ( Event event : result ) {
    		System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
    	}
    	
    	entityManager.getTransaction().commit();
    
    	entityManager.close();
    }
}
