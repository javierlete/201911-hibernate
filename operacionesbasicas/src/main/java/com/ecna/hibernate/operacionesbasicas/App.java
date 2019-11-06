package com.ecna.hibernate.operacionesbasicas;

import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		session.save(new Alumno(null, "Javier", "Lete"));
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		Alumno alumno = session.load(Alumno.class, 1L); 
		
		System.out.println(alumno);
		
		System.out.println("(Original) nombre: " + alumno.getNombre());
		// evict the object
		session.evict(alumno);
		
		System.out.println(session.isDirty());
		
		alumno.setNombre("Pasan de mí");
		
		System.out.println(session.isDirty());
		
		session.flush();
		
		//alumno = session.get(Alumno.class, 1L);
		
		//System.out.println("(Después de evict) nombre: " + alumno.getNombre());
		// merge the object
		Alumno alumnoPersistente = (Alumno)session.merge(alumno); // Hace la actualización, pero mantiene el objeto Detached
		
		System.out.println(session.isDirty());
		
		alumnoPersistente.setApellidos("Desde alumnoPersistente");
		alumno.setApellidos("Desde alumno detached");
		
		
		//alumno.setNombre("The Expert");
		
		session.flush();
		
		alumno = session.get(Alumno.class, 1L);
		
		System.out.println("(Después de merge) nombre: " + alumno.getNombre());
		
		session.getTransaction().commit();
		
		session.close();
	}
}