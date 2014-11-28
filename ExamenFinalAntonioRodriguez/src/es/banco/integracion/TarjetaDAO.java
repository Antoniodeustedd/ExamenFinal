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
    public void ingresar(String numeroComprobacion,TarjetaCredito tarjeta){
    	try { 
            
            conectar();
            PreparedStatement t= cx.prepareStatement("UPDATE TARGETACREDITO SET CUPOMAXIMO=? WHERE NUMEROCOMPROBACION=?");
            t.setString(1,numeroComprobacion );
            t.setString(7, id);
            
            desconectar();
      } catch (SQLException e) {
            e.printStackTrace();
      }
		
	}
    public String pagar(int dinero,String numeroComprobacion){
		TarjetaCredito tarjeta= new TarjetaCredito();
		String mensaje;
		try {
		    conectar();
            PreparedStatement ps = cx.prepareStatement("SELECT NMERO FROM VEHICULO WHERE numeroComprobacion=?");
            ResultSet rs =ps.executeQuery();  
            if(rs.next()) {   
            	
            	tarjeta.setNumero(rs.getString("numero"));
            	
               }
			
       
        	 desconectar();
        	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mensaje;
	}
    public TarjetaCredito consultarUno(int numero) {
		
		TarjetaCredito t= new TarjetaCredito();
		try {
		    conectar();
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM TARJETACREDITO WHERE NUMERO=?");
            ps.setInt(1, numero);
            ResultSet rs =ps.executeQuery();  
            if(rs.next()) {   
            	t.setId(rs.getString("id"));
            	t.setNumero(rs.getString("numero"));
            	t.setCupoMaximo(rs.getString("cupoMaximo"));
            	t.setCupoDisponible(rs.getString("cupoMinimo"));
            	t.setTipo(rs.getString("tipo"));
            	t.setNumeroComprobacion(rs.getString("numeroComprobacion"));
            	t.setContraseña(rs.getString("contrasenha"));
                
             }
			
       
        	 desconectar();
        	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return t;
	}
    




}







	
	




	
	

	
	
