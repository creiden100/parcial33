package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Kilos;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RecoleccionDAO implements IBaseDatos<Kilos> {


	public List<Kilos> findAll() {
		List<Kilos> obras= null;
	    String query = "select idcolmena, sum(kilos)as Suma from recoleccion group by idcolmena;";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RecoleccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int idColmena;
            int valor;
	
	    while (rs.next()){
                Kilos registro=new Kilos();
	    	if(obras == null){
	    		obras= new ArrayList<Kilos>();     
	    	}
                idColmena=rs.getInt("idColmena");
                registro.setIdColmena(idColmena);
                valor=rs.getInt("Suma");
                registro.setKilos(valor);
	        obras.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Departamentos");
			e.printStackTrace();
		}
	    
	    return obras;
	}

	

	public boolean insert(Kilos t) {
		return false;
	}


	public boolean update(Kilos t) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RecoleccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Obra set nom_depto = ? where id_depto = ?";
		PreparedStatement preparedStmt=null;
			
		return result;
	}


	public boolean delete(Kilos t) {
	   return false;
	}
}
