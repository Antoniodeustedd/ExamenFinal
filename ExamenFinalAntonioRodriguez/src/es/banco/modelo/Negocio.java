package es.banco.modelo;

import es.banco.integracion.TargetaDAO;
import es.banco.modelo.TargetaCredito;


public class Negocio {

	private  TargetaCredito TargetaCredito= new TargetaCredito();

	public int darAlta(String numero, String cupoMaximo, String cupoDisponible,
			String tipo, String numeroComprobacion, String contraseña) {
		
		TargetaCredito vehiculo= new TargetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contraseña);
		int id= TargetaDAO.darAlta(TargetaCredito);
		
				
		return id;
		
	}


}
