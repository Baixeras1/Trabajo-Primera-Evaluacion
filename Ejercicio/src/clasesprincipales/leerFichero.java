package clasesprincipales;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class leerFichero {
	
	public  ArrayList<Empleados>empleados2;
	
	public leerFichero(ArrayList<Empleados> emp) {
		this.empleados2=emp;
		
	}

	public void  leerBinario() throws IOException {

		File contabilidad= new File("ficheroBinario.dat");
		
		String matricula;
		double salario;
		double gastos;
		double totalgastos;
		Empleados e;
		DataInputStream datos = null;
		
		try {

			datos = new DataInputStream(new FileInputStream(contabilidad));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		try {
		while(true) {
			
			matricula=datos.readUTF();
			gastos=datos.readDouble();
			salario=datos.readDouble(); 
			totalgastos=Math.round((gastos+salario)*100.00)/100.00;
			
			e =new Empleados(matricula,totalgastos);
			
			if(!this.empleados2.contains(e)) {
				
			App.empleados2.add(e);
			}else{
				
				int i=this.empleados2.indexOf(e);
				double gas=this.empleados2.get(i).getGastosTotales();
				this.empleados2.get(i).setGastosTotales(gastos);	
			}
		}			

		}catch (EOFException _eof) {
		
		}		
		
			datos.close();
	}
	
}

