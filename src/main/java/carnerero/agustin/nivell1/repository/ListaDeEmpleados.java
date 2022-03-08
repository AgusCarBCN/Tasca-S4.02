package carnerero.agustin.nivell1.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import carnerero.agustin.nivell1.model.Empleado;

public class ListaDeEmpleados {
	private List<Empleado> listaEmpleados = new ArrayList<>();
	private List<Empleado> listaPorTrabajos = new ArrayList<>();
	private static ListaDeEmpleados lista;
	//Base de datos inicial
	private ListaDeEmpleados() {

		listaEmpleados.add(new Empleado(1, "Jose", "administrativo"));
		listaEmpleados.add(new Empleado(2, "Ana", "administrativo"));
		listaEmpleados.add(new Empleado(3, "Sergio", "operario"));
		listaEmpleados.add(new Empleado(4, "Salvador", "operario"));
		listaEmpleados.add(new Empleado(5, "Ambrosio", "operario"));
		listaEmpleados.add(new Empleado(6, "Julia", "tecnico"));
		listaEmpleados.add(new Empleado(7, "Adela", "gerente"));
	}

	public static ListaDeEmpleados getInstance() {
		if (lista == null) {
			lista = new ListaDeEmpleados();
		}
		return lista;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}		

	/**
	 * Método que agrega un empleado a la lista de empleados
	 * 
	 * @param empleado
	 */
	public void insertar(Empleado empleado) {
		listaEmpleados.add(empleado);
	}

	/**
	 * Método que retorna lista de empleados por puesto de trabajo.
	 * 
	 * @param empleo
	 * @return Retorna lista de empleados por puesto de trabajo.
	 */
	public List<Empleado> buscarPorEmpleo(String empleo) {
		listaPorTrabajos.clear();
		for (Empleado empleado : listaEmpleados) {
			if (empleo.equals(empleado.getTrabajo())) {
				listaPorTrabajos.add(empleado);
			}
		}
		return listaPorTrabajos;
	}

	/**
	 * Método que elimina un empleado.
	 * 
	 * 
	 * @param id id del empleado.
	 */
	public void eliminar(int id) {
		boolean encontrado = false;
		Empleado empleado;
		Iterator<Empleado> it = listaEmpleados.iterator();
		while (it.hasNext() && !encontrado) {
			empleado = it.next();
			if (empleado.getId() == id) {
				it.remove();
				encontrado = true;				
				
			}
		}
		if (!encontrado) {
			System.err.println("No se ha encontrado ningun empleado con este id.");
		}

	}

	/**
	 * Método que busca un empleado por su id.
	 * 
	 * @param id
	 * @return Retorna empleado por id.
	 */
	public Empleado buscarEmpleado(int id) {
		boolean encontrado = false;
		Empleado empleado = null;
		Iterator<Empleado> it = listaEmpleados.iterator();
		while (it.hasNext() && !encontrado) {
			empleado = it.next();
			if (empleado.getId() == id) {
				encontrado = true;
				
			}
		}
		if (!encontrado) {
			System.err.println("No se ha encontrado ningun operario con ese identidad.");
		}
		return empleado;
	}

	/**
	 * 
	 * Método que modifica los atributos de un empleado.Se usará para cambiar el puesto de trabajo del empleado
	 * 
	 * @param empleado
	 */
	public void editaEmpleado(Empleado empleado) {
		boolean encontrado = false;
		Iterator<Empleado> it = listaEmpleados.iterator();
		while (it.hasNext() && !encontrado) {
			Empleado emp = it.next();
			if (emp.getId() == empleado.getId()) {
				encontrado = true;
				emp.setId(empleado.getId());
				emp.setNombre(empleado.getNombre());
				emp.setTrabajo(empleado.getTrabajo());
				emp.setSalario(empleado.getSalario());
			
				
			}
		}
		if (!encontrado) {
			System.err.println("No se ha encontrado ningun operario con ese identidad.");
		}
	}
}
