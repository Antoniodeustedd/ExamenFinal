package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.banco.modelo.TargetaCredito;



public class TarjetaDAO {
	
	private Connection cx;
	   
    private void conectar() {
      try {
           Class.forName("com.mysql.jdbc.Driver");
           cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario","root","root");
           cx.setAutoCommit(false);
       } catch (SQLException e) {
          
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
    private void desconectar() {
        try {
           cx.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    
    }

	public  int darAlta(TargetaCredito targetaCredito) {
		
		int idRetornar=0;
		
		try {
	        conectar();
            PreparedStatement ps = cx.prepareStatement("INSERT INTO VEHICULO VALUES(?,?,?,?,?,?,?)");
		    ps.setInt(1, 0);
		    ps.setString(2, targetaCredito.getNumero());
		    ps.setString(3, targetaCredito.getCupoMaximo());
		    ps.setString(4, targetaCredito.getCupoDisponible());
		    ps.setString(5, targetaCredito.getTipo());
		    ps.setString(6, targetaCredito.getNumeroComprobacion());
		    ps.setString(7, targetaCredito.getContraseña());
	        int filasAfectadas =ps.executeUpdate();
            cx.commit();
            if(filasAfectadas>=1) { 
                idRetornar= ultimoId();
            }  
            desconectar();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idRetornar;
		       
	}
	
    public int ultimoId() {
	int  idM=90;
	try {
        conectar();
		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM TarjetaCredito"); 
		ResultSet consulta = ps.executeQuery(); 
		
		if(consulta.next()) { 
			idM=consulta.getInt("ULTIMO");
		}
		
		desconectar();
	} catch (SQLException e) {
		  e.printStackTrace();
		
	}
	
	return idM;

}
    public void ingresar(String numeroComprobacion,int dinero){
    	try { 
            
            conectar();
            PreparedStatement tarjeta = cx.prepareStatement("SELECT * FROM VEHICULO WHERE numeroComprobacion=?");
            int saldo =tarjeta.setInt(1, numeroComprobacion);
            if(saldo<20){
            	
            }
            else{
            	PreparedStatement tarjeta = cx.prepareStatement("SELECT * FROM VEHICULO WHERE numeroComprobacion=?");
                int saldo =tarjeta.setInt(1, numeroComprobacion);
            	saldo=  saldo-dinero;
            	PreparedStatement ps= cx.prepareStatement("UPDATE TARJETACREDITO SET SALDO=? WHERE ID=?");
                ps.setString(1, cupoMaximo)
                ps.setInt(2, id);
                cx.commit();
            }
            desconectar();
      } catch (SQLException e) {
            e.printStackTrace();
      }
		
		
	}
    public void pagar(int dinero,String numeroComprobacion){
		TargetaCredito targeta= new TargetaCredito();
		try {
		    conectar();
            PreparedStatement ps = cx.prepareStatement("SELECT numero FROM VEHICULO WHERE numeroComprobacion=?");
            ResultSet rs =ps.executeQuery();  
            if(rs.next()) {   
            	
            	targeta.setNumero(rs.getString("numero"));
            	
               }
			
       
        	 desconectar();
        	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void pagar(String numero, String maximo, String comprobacion,
			String contraseña) {
try { 
            
            conectar();
            
            PreparedStatement ps= cx.prepareStatement("UPDATE TARJETACREDITO SET DINERO=? WHERE ID=?");
            ps.setString(1, cupoMaximo)
            ps.setInt(2, id);
            cx.commit();
            desconectar();
      } catch (SQLException e) {
            e.printStackTrace();
      }
		
	}
    }

	
	




	
	

	
	
