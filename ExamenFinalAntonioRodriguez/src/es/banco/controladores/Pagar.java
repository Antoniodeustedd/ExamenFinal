package es.banco.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Negocio;



/**
 * Servlet implementation class Pagar
 */
@WebServlet("/Pagar")
public class Pagar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagar() {
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
		String comprobacion= request.getParameter("comprobacion");
		String contraseña= request.getParameter("contraseña");
		
		Negocio gestor= new Negocio();
		gestor.pagar(numero,maximo,comprobacion,contraseña);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
