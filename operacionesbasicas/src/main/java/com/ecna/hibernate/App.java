package com.ecna.hibernate;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;

import com.ecna.hibernate.mappings.unoauno.Stock;
import com.ecna.hibernate.mappings.unoauno.StockDetail;
import com.ecna.hibernate.mappings.unoavarios.Curso;
import com.ecna.hibernate.mappings.unoavarios.Profesor;
import com.ecna.hibernate.operacionesbasicas.Alumno;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		System.out.println("Pedir profesor");

		Profesor profesor = session.load(Profesor.class, 1L);

		System.out.println(profesor);
		
		System.out.println("Mostrar profesor");

		System.out.println(profesor.getNombre() + " " + profesor.getApellidos());
		
		for(Curso curso: profesor.getCursos()) {
			System.out.println(curso.getNombre());
		}

	}

	public static void creacionOneToMany(String[] args) {
		Profesor profesor = new Profesor(null, "Javier", "Lete", new HashSet<Curso>());

		Curso cursoJava = new Curso(1L, "Java");
		Curso cursoNET = new Curso(1L, ".NET");

		profesor.getCursos().add(cursoJava);
		profesor.getCursos().add(cursoNET);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		System.out.println("Vamos a guardar los cursos");

		session.save(cursoJava);
		session.save(cursoNET);

		System.out.println("Vamos a guardar el profesor");

		session.save(profesor);

		session.getTransaction().commit();

		session.close();
	}

	public static void unoAUno(String[] args) {
		// Transient
		Stock stock = new Stock();

		stock.setStockCode("4715");
		stock.setStockName("GENM");

		StockDetail stockDetail = new StockDetail();

		stockDetail.setCompName("GENTING Malaysia");
		stockDetail.setCompDesc("Best resort in the world");
		stockDetail.setRemark("Nothing Special");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		// Transient

		System.out.println("Hibernate one to one (XML mapping)");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock s = session.load(Stock.class, 1);

		System.out.println(s);

		session.getTransaction().commit();

		session.close();
	}

	public static void ejemploGetLoadEvictMerge(String[] args) {

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

		// alumno = session.get(Alumno.class, 1L);

		// System.out.println("(Después de evict) nombre: " + alumno.getNombre());
		// merge the object
		Alumno alumnoPersistente = (Alumno) session.merge(alumno); // Hace la actualización, pero mantiene el objeto
																	// Detached

		System.out.println(session.isDirty());

		alumnoPersistente.setApellidos("Desde alumnoPersistente");
		alumno.setApellidos("Desde alumno detached");

		// alumno.setNombre("The Expert");

		session.flush();

		alumno = session.get(Alumno.class, 1L);

		System.out.println("(Después de merge) nombre: " + alumno.getNombre());

		session.getTransaction().commit();

		session.close();
	}
}