package clasesprincipales;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import reverse.*;


public class Hibernate {
	
	private static SessionFactory hbsf;
	
	public static void escribirBBDD(ArrayList<Empleados> emp) {
		
		
		Empleados empleado = new Empleados();	
		
		Listaempleados le1;
		ListaempleadosId leid;
		
		System.out.println("--- Inicio de la sesión Hibernate");
		hbsf = HibernateUtil.getSessionFactory();
		
		Session hbse = hbsf.openSession();
		Transaction hbtr = hbse.beginTransaction();
		hbtr.commit();

		for (Empleados e : emp) {
			
			hbtr.begin();
			Date fecha = e.getFecha();
			fecha.setDate(2);
			leid=new ListaempleadosId(e.getNombre(), e.getDepartamento(), fecha, e.getMatricula(), e.getGastosTotales(), e.getVentasTotales());
			le1 = new Listaempleados(leid);
			
			hbse.save(le1);
			hbtr.commit();
			
		}
	
					
	}
	
}
