package clasesprincipales;

import java.sql.Date;
import java.util.Objects;

public class Empleados {
	
	private String matricula;
	private String nombre;
	private String departamento;
	private double ventas;
	private Date fecha;
	private double ventasTotales;
	private double gastosTotales;
	private double salario;
	private double gastos;
	
	public Empleados() {
		super();
	}
	
	public Empleados(String matricula, String nombre, String departamento, Date fecha) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.departamento = departamento;
		this.fecha = fecha;
	}

	public Empleados(String matricula, String nombre, String departamento, Date fecha, double ventasTotales,
			double gastosTotales) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.departamento = departamento;
		this.fecha = fecha;
		this.ventasTotales = ventasTotales;
		this.gastosTotales = gastosTotales;
	}

	public Empleados(String matricula, String nombre, String departamento, double ventas, Date fecha) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.departamento = departamento;
		this.ventas = ventas;
		this.fecha = fecha;
	}

	public Empleados(String matricula) {
		super();
		this.matricula = matricula;
	}

	public Empleados(String matricula, double salario, double gastos) {
		super();
		this.matricula = matricula;
		this.salario = salario;
		this.gastos = gastos;
	}

	public Empleados(String matricula, double gastosTotales) {
		super();
		this.matricula = matricula;
		this.gastosTotales = gastosTotales;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getVentas() {
		return ventas;
	}

	public void setVentas(double ventas) {
		this.ventas = ventas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getVentasTotales() {
		return ventasTotales;
	}

	public void setVentasTotales(double ventasTotales) {
		this.ventasTotales = ventasTotales;
	}

	public double getGastosTotales() {
		return gastosTotales;
	}

	public void setGastosTotales(double gastosTotales) {
		this.gastosTotales = gastosTotales;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Empleados matricula=" + matricula + ", nombre=" + nombre + ", departamento=" + departamento
				+ ", fecha=" + fecha + ", ventasTotales=" + ventasTotales + ", gastosTotales=" + gastosTotales;
	}
	
	
	
	
	
	

}
