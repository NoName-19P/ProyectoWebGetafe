package es.cursojava.servlets;

import java.io.IOException;

import es.cursojava.dto.CalculadoraDTO;
import es.cursojava.service.CalculadoraService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CalculadoraServlet doGet");
		String operacion = req.getParameter("operacion");
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		System.out.println("Operacion: " + operacion);
		System.out.println("Num1: " + num1);

		//Creo el DTO y llamo al servicio
		CalculadoraDTO calculadoraDTO = new CalculadoraDTO(operacion, num1, num2);
		//Llamo al servicio para realizar la operacion y obtener el resultado
		CalculadoraService calculadoraService = new CalculadoraService();
		//Obtengo el resultado
		String resultado = calculadoraService.calcular(calculadoraDTO);
		
		resp.getWriter().append("<h1>"+resultado+"</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		System.out.println("CalculadoraServlet init");	
//		
//	}
//
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("CalculadoraServlet service1");
//		//super.service(arg0, arg1);
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("CalculadoraServlet destroy"); 
//		super.destroy();
//	}

//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("CalculadoraServlet service2");
//		super.service(arg0, arg1);
//	}
	
	

	
	
	
}
