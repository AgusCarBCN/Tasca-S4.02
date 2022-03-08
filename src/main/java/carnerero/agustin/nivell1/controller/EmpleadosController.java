package carnerero.agustin.nivell1.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import carnerero.agustin.nivell1.model.Empleado;
import carnerero.agustin.nivell1.repository.*;

@Controller
public class EmpleadosController {

	ListaDeEmpleados repoEmpleados = ListaDeEmpleados.getInstance();

	@GetMapping("/")
	public String mostrarTodos(Model model) {
		List<Empleado> listEmployees = repoEmpleados.getListaEmpleados();
		
		model.addAttribute("empleados", listEmployees);
		return "listadeempleados";
	}

	@GetMapping("/{trabajo}")
	public String buscarPorTrabajo(@PathVariable String trabajo, Model model) {
		
		List<Empleado> listEmployeesByJob = repoEmpleados.buscarPorEmpleo(trabajo);
		model.addAttribute("empleados", listEmployeesByJob);
		return "listadeempleados";
	}
	
	@PostMapping("/agregar")
	public String agregar(@Valid Empleado empleado, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "formulario";
		}
		repoEmpleados.insertar(empleado);
		model.addAttribute("empleados", repoEmpleados.getListaEmpleados());
		return "listadeempleados";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Integer id, Model model) {
		List<Empleado> listEmployees = repoEmpleados.getListaEmpleados();		
		repoEmpleados.eliminar(id);
		model.addAttribute("empleados", listEmployees);
		return "listadeempleados";
	}

	@GetMapping("/modificar/{id}")
	public String editarEmpleado(@PathVariable Integer id, Model model) {
		Empleado empleado = repoEmpleados.buscarEmpleado(id);
		model.addAttribute("empleados", repoEmpleados.getListaEmpleados());
		model.addAttribute("empleado", empleado);
		return "listadeempleados";
	}

	@PostMapping("/modificar")
	public String modificar(Empleado empleado, Model model) {
		repoEmpleados.editaEmpleado(empleado);
		model.addAttribute("empleados", repoEmpleados.getListaEmpleados());
		return "listadeempleados";
	}
}
