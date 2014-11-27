package es.banco.modelo;

import es.banco.integracion.TarjetaDAO;


public class Negocio {

	private  TarjetaCredito TargetaCredito= new TarjetaCredito();

	public int darAlta(String numero, String cupoMaximo, String cupoDisponible,
			String tipo, String numeroComprobacion, boolean contrase�a) {
		
		TarjetaCredito targeta= new TarjetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contrase�a);
		
		TarjetaDAO targetaNueva=new TarjetaDAO();
		int id= TarjetaDAO.darAlta(TargetaCredito);
		
				
		return id;
		
	}

    public void ingresar(String numero,int dinero){
    	TarjetaDAO gestor= new TarjetaDAO();
		gestor.ingresar(numero, dinero);
    }
    public void pagar(String numero,String maximo,String comprobacion,String contrase�a){
    	TarjetaDAO gestor= new TarjetaDAO();
		gestor.pagar(numero, maximo,comprobacion,contrase�a);
    }

	
}
