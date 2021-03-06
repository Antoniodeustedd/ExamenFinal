package es.banco.modelo;

import javax.jws.WebService;

import es.banco.integracion.TarjetaDAO;

@WebService(endpointInterface="es.banco.modelo.NegocioWS")
public class Negocio implements NegocioWS {

	private  TarjetaCredito TargetaCredito= new TarjetaCredito();

	public int darAlta(String numero, String cupoMaximo, String cupoDisponible,
			String tipo, String numeroComprobacion, String contraseņa) {
		
		TarjetaCredito targeta= new TarjetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contraseņa);
		
		TarjetaDAO targetaNueva=new TarjetaDAO();
		int id= TarjetaDAO.darAlta(TargetaCredito);
		
				
		return id;
		
	}

    public void ingresar(String numero,int dinero){
    	TarjetaDAO gestor= new TarjetaDAO();
		gestor.ingresar(numero, dinero);
    }
    /* (non-Javadoc)
	 * @see es.banco.modelo.NegocioPagar#pagar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
    @Override
	public String pagar(String numero,String maximo,String comprobacion,String contraseņa){
    	
    	String mensaje;
    	TarjetaDAO gestor= new TarjetaDAO();
    	TarjetaCredito t= TarjetaDAO.colsutar(nrot);
    	if(t.getNumeroComprobacion().equals(comporbacion))
		      gestor.pagar(numero, maximo,comprobacion,contraseņa);
    	
    	
    	
        return mensaje;
    }

	
}
