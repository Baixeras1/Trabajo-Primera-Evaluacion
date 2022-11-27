package clasesprincipales;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class App {
	
	public static ArrayList<Empleados>empleados=new ArrayList<Empleados>();
	public static ArrayList<Empleados>empleados2=new ArrayList<Empleados>();
	public static ArrayList<Empleados>empleadosSinRepetecion=new ArrayList<Empleados>();
	
	public static void main(String[] args) throws SQLException, IOException {
		
		leerFichero lf =new leerFichero(empleados2);
		lf.leerBinario();
		
		leerbbdd();
		
		crearempleadosSinRepetecion();
		setVentasTotales();
		
		generaArrayComp();
		Hibernate.escribirBBDD(empleadosSinRepetecion);
		
		muestraArray(empleadosSinRepetecion);
	}
	
	private static void generaArrayComp() {
		for (int i = 0; i < empleadosSinRepetecion.size(); i++) {
			for (int j = 0; j < empleados2.size(); j++) {
				if(empleados2.get(j).equals(empleadosSinRepetecion.get(i))) {
					empleadosSinRepetecion.get(i).setGastosTotales(empleados2.get(j).getGastosTotales());
				}
			}
		}	
	}
	
	private static void muestraArray(ArrayList<Empleados> empleados2) {
		
		for (int i = 0; i < empleados2.size(); i++) {
			System.out.println(empleados2.get(i));
		}		
	}
	
	private static void setVentasTotales() {
		
		for (int i = 0; i < empleadosSinRepetecion.size(); i++) {
			
			double total=0;
			
			for (int j = 0; j < empleados.size(); j++) {
				if(empleados.get(j).equals(empleadosSinRepetecion.get(i))) {
					
					total+=empleados.get(j).getVentas();
				}
			}
			empleadosSinRepetecion.get(i).setVentasTotales(total);			
		}		
	}
	
	private static void crearempleadosSinRepetecion() {
		
		for (int i = 0; i < empleados.size(); i++) {
			
			 Empleados e1 = new Empleados (empleados.get(i).getMatricula(),empleados.get(i).getNombre(),empleados.get(i).getDepartamento(),empleados.get(i).getFecha());
			 
			 if(!empleadosSinRepetecion.contains(e1)) {
				 empleadosSinRepetecion.add(e1);
				}		
		}		
	}
	
	private static void leerbbdd() throws SQLException {
		
		String puerto="3306";
		String user="root";
		String pass="root";	
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:"+puerto+"/db1eva",user,pass);
		DatabaseMetaData dm=conn.getMetaData();
		ResultSet rs = null;
		Statement st = conn.createStatement();
		
		String sentencia ="SELECT * FROM RRHHVENTAS";
		rs=st.executeQuery(sentencia);
		
		while(rs.next()) {
			empleados.add(new Empleados(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5)));
		}
	}
}