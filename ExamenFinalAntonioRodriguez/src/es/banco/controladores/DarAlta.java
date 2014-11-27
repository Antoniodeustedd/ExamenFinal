package es.banco.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Negocio;
import es.concesionario.modelo.GestorVehiculos;

/**
 * Servlet implementation class DarAlta
 */
@WebServlet("/DarAlta")
public class DarAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numero= request.getParameter("numero");
		String maximo= request.getParameter("maximo");
		String disponible= request.getParameter("disponible");
		String comprobacion= request.getParameter("comprobacion");
		String contraseña= request.getParameter("contraseña");
		boolean tipo= Boolean.parseBoolean(request.getParameter("tipo"));
		Negocio gestor= new Negocio();
		int id= gestor.darAlta(numero,maximo,disponible,comprobacion,contraseña,tipo);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
