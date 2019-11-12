package com.ecna.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ecna.hibernate.mappings.unoauno.Stock;
import com.ecna.hibernate.mappings.unoauno.StockDetail;
import com.ecna.hibernate.mappings.unoavarios.Curso;
import com.ecna.hibernate.mappings.unoavarios.Profesor;
import com.ecna.hibernate.mappings.unoavarioslist.Cuenta;
import com.ecna.hibernate.mappings.unoavarioslist.Movimiento;
import com.ecna.hibernate.operacionesbasicas.Alumno;

public class App {
	public static void main(String[] args) {
		ejemploVariosAVarios();
	}

	public static void ejemploVariosAVarios() {
		com.ecna.hibernate.mappings.variosavarios.Profesor profesor = new com.ecna.hibernate.mappings.variosavarios.Profesor(
				null, "Javier", "Lete", new HashSet<com.ecna.hibernate.mappings.variosavarios.Curso>());
		com.ecna.hibernate.mappings.variosavarios.Profesor profesor2 = new com.ecna.hibernate.mappings.variosavarios.Profesor(
				null, "Pepe", "Pérez", new HashSet<>());

		com.ecna.hibernate.mappings.variosavarios.Curso cursoJava = new com.ecna.hibernate.mappings.variosavarios.Curso(
				null, "Java", new HashSet<>());
		com.ecna.hibernate.mappings.variosavarios.Curso cursoNET = new com.ecna.hibernate.mappings.variosavarios.Curso(
				null, ".NET", new HashSet<>());

		profesor.getCursos().add(cursoJava);
		cursoJava.getProfesores().add(profesor);

		profesor.getCursos().add(cursoNET);
		cursoNET.getProfesores().add(profesor);

		profesor2.getCursos().add(cursoNET);
		cursoNET.getProfesores().add(profesor2);

		for (com.ecna.hibernate.mappings.variosavarios.Curso c : profesor.getCursos()) {
			System.out.println(c);
			
			for (com.ecna.hibernate.mappings.variosavarios.Profesor p : c.getProfesores()) {
				System.out.println(p);
			}
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.getTransaction().begin();
		
		session.save(profesor);
		session.save(profesor2);
		session.save(cursoNET);
		session.save(cursoJava);
		
		session.getTransaction().commit();
		
		System.out.println(profesor);
		System.out.println(profesor2);
		System.out.println(cursoNET);
		System.out.println(cursoJava);
		
		session.getTransaction().begin();
		
		List<com.ecna.hibernate.mappings.variosavarios.Curso> cursos;

		cursos = session.createQuery("from Curso").list();
		
		for (com.ecna.hibernate.mappings.variosavarios.Curso c : cursos) {
			System.out.println(c);
			
			for (com.ecna.hibernate.mappings.variosavarios.Profesor p : c.getProfesores()) {
				System.out.println(p);
			}
		}
		
		session.getTransaction().commit();
	}

	public static void ejemploUnoAVariosList() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Cuenta cuenta = new Cuenta();

			cuenta.setNumero("12345678");
			cuenta.setMovimientos(new ArrayList<Movimiento>());

			Movimiento m1 = new Movimiento(null, new Date(), "Primero", new BigDecimal("123.45"));
			Movimiento m2 = new Movimiento(null, new Date(), "Segundo", new BigDecimal("-123.45"));

			cuenta.getMovimientos().add(m1);
			cuenta.getMovimientos().add(m2);

			session.getTransaction().begin();

			session.save(m1);
			session.save(m2);
			session.save(cuenta);

			session.getTransaction().commit();

			session.getTransaction().begin();

			Cuenta c = session.load(Cuenta.class, 1L);

			for (Movimiento m : c.getMovimientos()) {
				System.out.println(m);
			}

		} catch (HibernateException e) {
			if (session != null)
				session.getTransaction().rollback();

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public static void ejemploUnoAVariosSet() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			System.out.println("Pedir profesor");

			Profesor profesor = session.load(Profesor.class, 1L);

			System.out.println(profesor);

			System.out.println("Mostrar profesor");

			System.out.println(profesor.getNombre() + " " + profesor.getApellidos());

			for (Curso curso : profesor.getCursos()) {
				System.out.println(curso.getNombre());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static void creacionOneToMany() {
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

	public static void unoAUno() {
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

	public static void ejemploGetLoadEvictMerge() {

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