package es.cursojava.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String peticion = request.getParameter("peticion");
		System.out.println("Nombre recibido: " + nombre);
		System.out.println("Peticion: " + peticion);
		System.out.println(request.getSession().getId());
		response.getWriter().append("Bienvenido al curso de Java EE "+ nombre + ". Peticion: " + peticion);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int edad= Integer.parseInt(request.getParameter("edad"));
		String genero = request.getParameter("genero");
		System.out.println("Nombre recibido: " + nombre);
		System.out.println("Peticion: " + genero);
		System.out.println("Edad: " + edad);
	
		response.getWriter().append("<H1>Bienvenido al curso de Java EE "+ nombre + ". Edad: " + edad +"</H1>");
		
	}

}

