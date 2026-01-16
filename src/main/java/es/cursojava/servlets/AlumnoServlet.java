package es.cursojava.servlets;

import java.io.IOException;
import java.util.List;



import es.cursojava.hibernate.ejercicio1.dto.AlumnoDTO;
import es.cursojava.service.AlumnoService;
import es.cursojava.service.CalculadoraService;
import es.cursojava.utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//

@WebServlet("/alumno")
public class AlumnoServlet extends HttpServlet {
	
	AlumnoService alumnoService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//listar alumnos

		
		resp.getWriter().append("<h1>Listado de Alumnos</h1>");
		resp.getWriter().append("<a href=\"index.html\">Volver al formulario</a>");
		List<AlumnoDTO> alumnos ;
		alumnos=alumnoService.listarAlumnosActivos();
		
		for (AlumnoDTO alumnoDTO : alumnos) {
			resp.getWriter().append("<p> Nombre: " + alumnoDTO.getNombre() + ", Email: " + alumnoDTO.getEmail()
					+ ", Edad: " + alumnoDTO.getEdad() + "</p>");
			System.out.println(" Nombre: " + alumnoDTO.getNombre() + ", Email: " + alumnoDTO.getEmail()
					+ ", Edad: " + alumnoDTO.getEdad());
		}
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entro en doPost de AlumnoServlet");
		String campoNombre = req.getParameter("nombre");
		System.out.println("Nombre: " + campoNombre);

		String campoEmail = req.getParameter("email");
		System.out.println("Email: " + campoEmail);

		int campoEdad = Integer.parseInt(req.getParameter("edad"));
		System.out.println("Edad: " + campoEdad);

		String campoCurso = null;
		System.out.println("Curso: " + campoCurso);

		// Creo el DTO y llamo al servicio
		AlumnoDTO alumnoDTO = new AlumnoDTO(campoNombre, campoEmail, campoEdad);

		// Llamo al servicio para realizar la operacion
		try {
			 alumnoService = new AlumnoService(alumnoDTO);

			
			alumnoService.insertarAlumno(alumnoDTO);
			// Si todo va bien, muestro mensaje de exito
			resp.getWriter().append("<h1>Alumno procesado correctamente</h1>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en AlumnoServlet: " + e.getMessage());
		}
		doGet(req, resp);

		
	}

}
