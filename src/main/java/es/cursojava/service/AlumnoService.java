package es.cursojava.service;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.ejercicio1.dao.AlumnoDAO;
import es.cursojava.hibernate.ejercicio1.dto.AlumnoDTO;
import es.cursojava.hibernate.ejercicio1.entites.Alumno;


public class AlumnoService {

	private static final int MAX_NOMBRE_LENGTH = 10;
	private static final int MIN_NOMBRE_LENGTH = 3;

	public AlumnoService(AlumnoDTO alumnoDTO) throws Exception {
		validarNombre(alumnoDTO.getNombre());
		validarEmail(alumnoDTO.getEmail());
		validarEdad(alumnoDTO.getEdad());
	}

	public static boolean validarEmail(String email) {
	    return email != null && email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	}


	public void validarEdad(Integer edad) throws Exception {
		if (edad == null || edad < 0 || edad > 120) {
			throw new Exception("Edad no valida");
		}
	}

	public void validarNombre(String nombre) throws Exception {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new Exception("Nombre no valido");
		}

		if (nombre.length() < MIN_NOMBRE_LENGTH || nombre.length() > MAX_NOMBRE_LENGTH) {
			throw new Exception(
					"Nombre debe tener entre " + MIN_NOMBRE_LENGTH + " y " + MAX_NOMBRE_LENGTH + " caracteres");
		}
	}

	public void insertarAlumno(AlumnoDTO alumnoDTO) {
		// TODO Auto-generated method stub
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		Alumno alumno = new Alumno(alumnoDTO.getNombre(), alumnoDTO.getEmail(), alumnoDTO.getEdad());
		alumnoDAO.guardarAlumno(alumno);
	
	}

	public List<AlumnoDTO> listarAlumnosActivos() {
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		List<Alumno> alumnos = alumnoDAO.obtenerTodosAlumnos();
		List<AlumnoDTO> alumnosDTO = new ArrayList<>();

		for (Alumno alumno : alumnos) {
			alumnosDTO.add(new AlumnoDTO(alumno.getNombre(), alumno.getEmail(), alumno.getEdad()));
		}

		

		return alumnosDTO;
	}

}
