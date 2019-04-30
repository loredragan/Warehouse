package dao;

import model.Comanda;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import connection.ConnectionFactory;

public class ComandaDAO extends AbstractDAO<Comanda>{
	private static  String createInsertQuery(String clientID, String produsID, String cantitate, String sumaTotala) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(" comanda ");
		sb.append(" ( ");
		sb.append(clientID);
		sb.append(" , ");
		sb.append(produsID);
		sb.append(" , ");
		sb.append(cantitate);
		sb.append(" , ");
		sb.append(sumaTotala);
		sb.append(" ) ");
		sb.append(" VALUES " );
		sb.append(" ( ");
		sb.append(" ? ");
		sb.append(",");
		sb.append(" ? ");
		sb.append(",");
		sb.append(" ? ");
		sb.append(",");
		sb.append(" ? ");
		sb.append(" ) ");
		

		return sb.toString();
	}
	
	private static String createUpdateCantitateQuery(String id, String cantitate) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append( " comanda ");
		sb.append( " SET ");
		sb.append(cantitate);
		sb.append(" =? ");
		sb.append( " WHERE ");
		sb.append(id);
		sb.append( " =? ");
		return sb.toString();
		
	}
	
	public Comanda insert(Comanda com) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int insertedID = -1;
		
		String query = createInsertQuery("clientID","produsID","cantitate", "sumaTotala");
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, com.getClientID());
			statement.setInt(2, com.getProdusID());
			statement.setInt(3, com.getCantitate());
			statement.setFloat(4, com.getSumaTotala());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				insertedID = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, " comanda " + "DAO:Insert " + e.getMessage());
		}finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return this.findById(insertedID);
	}
	
	public Comanda updateComandaCantitate(int id, int cantitate) throws Exception {
		Comanda modifiedCantitate= null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateCantitateQuery("id","cantitate");
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, cantitate);
			statement.setInt(2, id);
			statement.executeUpdate();
			modifiedCantitate= this.findById(id);
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Comanda" + "DAO:UpdateCantitate" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
    	
    	return modifiedCantitate;
	}
	
	
}
