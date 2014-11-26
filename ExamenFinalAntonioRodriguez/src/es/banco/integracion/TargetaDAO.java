package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.banco.modelo.TargetaCredito;


public class TargetaDAO {
	
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

	public int darAlta(TargetaCredito targetaCredito) {
		
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
		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM VEHICULO"); 
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
	
}
	
	

	
	
