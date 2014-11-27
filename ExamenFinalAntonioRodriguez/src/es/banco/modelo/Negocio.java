package es.banco.modelo;

import es.banco.integracion.TarjetaDAO;


public class Negocio {

	private  TargetaCredito TargetaCredito= new TargetaCredito();

	public int darAlta(String numero, String cupoMaximo, String cupoDisponible,
			String tipo, String numeroComprobacion, boolean contraseņa) {
		
		TargetaCredito targeta= new TargetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contraseņa);
		
		TarjetaDAO targetaNueva=new TarjetaDAO();
		int id= TarjetaDAO.darAlta(TargetaCredito);
		
				
		return id;
		
	}

    public void ingresar(String numero,int dinero){
    	TarjetaDAO gestor= new TarjetaDAO();
		gestor.ingresar(numero, dinero);
    }
    public void pagar(String numero,String maximo,String comprobacion,String contraseņa){
    	TarjetaDAO gestor= new TarjetaDAO();
		gestor.pagar(numero, maximo,comprobacion,contraseņa);
    }

	
}
