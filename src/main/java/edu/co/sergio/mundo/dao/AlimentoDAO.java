package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Alimento;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlimentoDAO implements IBaseDatos<Alimento> {

	public List<Alimento> findAll() {
		List<Alimento> obras= null;
	    String query = "select idcolmena, sum(panalconalimento) as Suma from visitatecnica group by idcolmena;";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(AlimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int idColmena;
            int valor;
	
	    while (rs.next()){
                Alimento registro=new Alimento();
	    	if(obras == null){
	    		obras= new ArrayList<Alimento>();     
	    	}
                idColmena=rs.getInt("idColmena");
                registro.setIdColmena(idColmena);
                valor=rs.getInt("suma");
                registro.setAlimento(valor);
	        obras.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("No se puede obtener la lista de Departamentos");
			e.printStackTrace();
		}
	    
	    return obras;
	}

	

	public boolean insert(Alimento t) {
		return false;
	}


	public boolean update(Alimento t) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(AlimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Obra set nom_depto = ? where id_depto = ?";
		PreparedStatement preparedStmt=null;
			
		return result;
	}


	public boolean delete(Alimento t) {
	   return false;
	}
}
