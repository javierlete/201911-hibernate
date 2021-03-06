package com.ecna.hibernate.ejemploconanotaciones;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
	private static SessionFactory sessionFactory;
	
	private static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			
			throw e;
		}
	}
	
    public static void main( String[] args ) throws Exception
    {
    	setUp();
    	
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	
    	session.save( new Event( "Our very first event!", new Date(), 11, "Prueba" ) );
    	session.save( new Event( "A follow up event", new Date(), 22, "Pruebaza" ) );
    	
    	session.getTransaction().commit();
    	
    	session.close();
    	
    	session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	
    	@SuppressWarnings("unchecked")
		List<Event> result = session.createQuery( "from Event" ).list();
    	
    	for ( Event event : (List<Event>) result ) {
    	    System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
    	}
    	
    	session.getTransaction().commit();
    	
    	session.close();
    }
}
