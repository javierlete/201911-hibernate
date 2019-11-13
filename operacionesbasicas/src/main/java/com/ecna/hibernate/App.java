package com.ecna.hibernate;

import static org.hibernate.criterion.Restrictions.gt;
import static org.hibernate.criterion.Restrictions.ilike;
import static org.hibernate.criterion.Restrictions.or;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.ecna.hibernate.dto.EmpleadoNombreNumero;
import com.ecna.hibernate.mappings.composicion.Dni;
import com.ecna.hibernate.mappings.composicion.Empleado;
import com.ecna.hibernate.mappings.herencia.Libro;
import com.ecna.hibernate.mappings.herencia.LibroConEstrellas;
import com.ecna.hibernate.mappings.herencia.LibroRegistrado;
import com.ecna.hibernate.mappings.mapas.Encounter;
import com.ecna.hibernate.mappings.unoauno.Stock;
import com.ecna.hibernate.mappings.unoauno.StockDetail;
import com.ecna.hibernate.mappings.unoavarios.Curso;
import com.ecna.hibernate.mappings.unoavarios.Profesor;
import com.ecna.hibernate.mappings.unoavarioslist.Cuenta;
import com.ecna.hibernate.mappings.unoavarioslist.Movimiento;
import com.ecna.hibernate.operacionesbasicas.Alumno;

public class App {
	public static void main(String[] args) {
		ejemploNativeSQL();
	}

	private static void ejemploNativeSQL() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Object[]> consulta = session.createSQLQuery("SELECT * FROM profesores").list();
		
		for(Object[] fila: consulta) {
			
			for(Object columna: fila) {
				System.out.println(columna);
			}
			System.out.println();
		}
		
		List<Profesor> profesores = session.createNativeQuery("SELECT * FROM profesores", Profesor.class).list();
		
		for(Profesor profesor: profesores) {
			System.out.println(profesor);
		}
	}

	private static void ejemploHQL() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Cuentas sin tipo (como campos)");
		
		List<Object[]> resultado = session.createQuery("from Cuenta c left outer join c.movimientos").list();

		for (Object[] fila : resultado) {
			for (Object columna : fila) {
				System.out.print("Dato: " + columna + ", ");

				if (columna instanceof Cuenta) {
					System.out.println("MOVIMIENTOS: " + ((Cuenta) columna).getMovimientos());
				}
			}
			System.out.println();
		}

		System.out.println("Cuentas con tipo");
		
		List<Cuenta> cuentas = session.createQuery("select c from Cuenta c left outer join c.movimientos").list();

		for (Cuenta cuenta : cuentas) {
			System.out.print(cuenta);
			System.out.println("MOVIMIENTOS: " + cuenta.getMovimientos());

		}
		
		System.out.println("Números de cuenta");
		
		List<String> numerosDeCuenta = session.createQuery("select c.numero from Cuenta c").list();
		
		for(String numero: numerosDeCuenta) {
			System.out.println(numero);
		}
		
		System.out.println("Números de DNI");
		
		List<Object[]> numerosDeDni = session.createQuery("select e.nombre, e.dni.numero from Empleado e").list();
		
		for(Object[] campos: numerosDeDni) {
			System.out.println(campos[0]);
			System.out.println(campos[1]);
		}
		
		System.out.println("Empleado Nombre Numero");
		
		List<EmpleadoNombreNumero> datos = session.createQuery(
				"select new com.ecna.hibernate.dto.EmpleadoNombreNumero(e.nombre, e.dni.numero) from Empleado e").list();
				
		for(EmpleadoNombreNumero dato: datos) {
			System.out.println(dato.getNombre());
			System.out.println(dato.getNumero());
		}
		
		System.out.println("Lista de listas");
		
		List<List<String>> listas = session.createQuery(
				"select new list(e.nombre, e.dni.numero) from Empleado e").list();
				
		for(List<String> lista: listas) {
			System.out.println(lista.get(0));
			System.out.println(lista.get(1));
		}
		
		System.out.println("Prueba de named Query");
		
//		List<Profesor> profesores = session
//				.createQuery("select p from Profesor p inner join p.cursos c where c.nombre='PHP'").list();
//
//		for (Profesor profesor : profesores) {
//
//			System.out.println(profesor);
//		}
		
		List<Profesor> profesores = session.getNamedQuery("profesPHP").list();
		
		for(Profesor profesor: profesores) {

			System.out.println(profesor);
		}
		
		System.out.println("Listado de todos los objetos");
		
		List<Object> objetos = session.createQuery("from java.lang.Object").list();
		
		for(Object o: objetos) {
			System.out.println(o);
		}
	}

	private static void ejemploCriteria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Libro.class);

		criteria
//			.setFirstResult(1)
//			.setMaxResults(2)
				.add(or(ilike("nombre", "%li%"), gt("id", 3L)));

		criteria.addOrder(Order.desc("nombre"));

		ProjectionList pl = Projections.projectionList();

		pl.add(Projections.rowCount());
		pl.add(Projections.avg("estrellas"));
		pl.add(Projections.count("isbn"));
		// pl.add(Projections.property("isbn"));

		criteria.setProjection(pl);

		Object[] l = (Object[]) criteria.uniqueResult();

		for (Object o : l) {
			System.out.println(o);
		}

		// Long resultado = (Long) criteria.uniqueResult();

		// System.out.println(resultado);

//		List<Libro> libros = criteria.list();
//		
//		for(Libro libro: libros) {
//			System.out.println(libro);
//		}

		criteria = session.createCriteria(Cuenta.class);

		criteria.setFetchMode("movimientos", FetchMode.JOIN);

		for (Cuenta c : (List<Cuenta>) criteria.list()) {
			System.out.println(c);
			System.out.println(c.getMovimientos());
		}

		Cuenta cuenta = new Cuenta();
		cuenta.setNumero("321-321-321");

		criteria = session.createCriteria(Cuenta.class);

		criteria.add(Example.create(cuenta));

		criteria.setFetchMode("movimientos", FetchMode.JOIN);

		criteria.list();

		for (Cuenta c : (List<Cuenta>) criteria.list()) {
			System.out.println("Cuenta basada en ejemplo: " + c);
			System.out.println(c.getMovimientos());
		}
	}

	private static void ejemploHerencia() {
		Libro libro = new Libro(null, "Mi libro");
		LibroRegistrado libroRegistrado = new LibroRegistrado(null, "La Historia Interminable: hibernate",
				"123-123-123");
		LibroConEstrellas libroConEstrellas = new LibroConEstrellas(null, "Como sobrevivir a hibernate", 5);

		System.out.println(libro);
		System.out.println(libroRegistrado);
		System.out.println(libroConEstrellas);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(libro);
		session.save(libroRegistrado);
		session.save(libroConEstrellas);

		session.getTransaction().commit();

		session.clear();

		Libro l = session.load(Libro.class, 1L);
		LibroRegistrado lr = session.load(LibroRegistrado.class, 2L);
		LibroConEstrellas le = session.load(LibroConEstrellas.class, 3L);

		System.out.println(l);
		System.out.println(lr);
		System.out.println(le);

		System.out.println("---------------------------");
		List<Libro> libros = session.createQuery("from Libro").list();

		for (Libro lib : libros) {
			System.out.println(lib);
		}
	}

	public static void ejemploMaps() {
		Encounter e = new Encounter();

		e.setNombre("Euskal Encounter");

		e.setAsistentes(new HashMap<>());

		e.getAsistentes().put("Mutante", "Javier");
		e.getAsistentes().put("Pelutxito", "Pepe");

		System.out.println(e.getAsistentes().get("Pelutxito"));

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(e);

		session.getTransaction().commit();

		session.evict(e);

		Encounter encounter = session.load(Encounter.class, 1L);

		System.out.println(encounter.getAsistentes().get("Mutante"));
	}

	public static void ejemploComposicion() {
		Empleado empleado = new Empleado(null, "Javier", new Dni("12345678", 'Z'));

		System.out.println(empleado);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(empleado);

		session.getTransaction().commit();

		session.evict(empleado);

		Empleado e = session.load(Empleado.class, 1L);

		System.out.println(e.getDni().getLetra());
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