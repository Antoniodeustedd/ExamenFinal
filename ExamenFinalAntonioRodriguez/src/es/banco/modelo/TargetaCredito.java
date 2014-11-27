package es.banco.modelo;

public class TargetaCredito {
	String numero;
	String cupoMaximo;
	String cupoDisponible;
	String tipo;
	String numeroComprobacion;
	String contrase�a;
	String id;
	public TargetaCredito(String numero, String cupoMaximo,
			String cupoDisponible, String tipo, String numeroComprobacion,
			String contrase�a, String id) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrase�a = contrase�a;
		this.id = id;
	}
	public TargetaCredito(String numero, String cupoMaximo,
			String cupoDisponible, String tipo, String numeroComprobacion,
			boolean tipo2) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrase�a = contrase�a;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCupoMaximo() {
		return cupoMaximo;
	}
	public void setCupoMaximo(String cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}
	public String getCupoDisponible() {
		return cupoDisponible;
	}
	public void setCupoDisponible(String cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}
	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
