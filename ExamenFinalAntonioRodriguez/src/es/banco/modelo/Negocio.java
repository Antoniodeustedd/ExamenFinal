package es.banco.modelo;

import es.banco.integracion.TargetaDAO;
import es.banco.modelo.TargetaCredito;


public class Negocio {

	private  TargetaCredito TargetaCredito= new TargetaCredito();

	public int darAlta(String numero, String cupoMaximo, String cupoDisponible,
			String tipo, String numeroComprobacion, String contraseņa) {
		
		TargetaCredito vehiculo= new TargetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contraseņa);
		int id= TargetaDAO.darAlta(TargetaCredito);
		
				
		return id;
		
	}


}
