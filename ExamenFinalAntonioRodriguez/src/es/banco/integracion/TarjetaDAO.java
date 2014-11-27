package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.banco.modelo.TarjetaCredito;



public class TarjetaDAO {
	
	private Connection cx;
	   
    private void conectar() {
      try {
           Class.forName("com.mysql.jdbc.Driver");
           cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
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

	public  int darAlta(TarjetaCredito tarjeta) {
		
		int idRetornar=0;
		
		try {
	        conectar();
            PreparedStatement ps = cx.prepareStatement("INSERT INTO VEHICULO VALUES(?,?,?,?,?,?,?)");
		    ps.setInt(1, 0);
		    ps.setString(2, tarjeta.getNumero());
		    ps.setString(3, tarjeta.getCupoMaximo());
		    ps.setString(4, tarjeta.getCupoDisponible());
		    ps.setString(5, tarjeta.getTipo());
		    ps.setString(6, tarjeta.getNumeroComprobacion());
		    ps.setString(7, tarjeta.getContraseña());
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
		TarjetaCredito tarjeta= new TarjetaCredito();
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

	
	




	
	

	
	
