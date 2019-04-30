package dao;

import model.Produs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import connection.ConnectionFactory;

public class ProdusDAO extends AbstractDAO<Produs> {
	private static String createInsertQuery(String name, String pret,String cantitate) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(" produs ");
		sb.append("( ");
		sb.append(name);
		sb.append(",");
		sb.append(pret);
		sb.append(" , ");
		sb.append(cantitate);
		sb.append(")");
		sb.append(" VALUES ");
		sb.append("(");
		sb.append("?");
		sb.append(",");
		sb.append("?");
		sb.append(" , ");
		sb.append(" ? ");
		sb.append(")");
		return sb.toString();

	}

	private static String createUpdateNameQuery(String id, String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(" produs ");
		sb.append(" SET ");
		sb.append(name);
		sb.append(" =?");
		sb.append(" WHERE ");
		sb.append(id);
		sb.append("=?");
		return sb.toString();
	}

	private static String createUpdatePriceQuery(String id, String pret) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append(" produs ");
		sb.append(" set ");
		sb.append(pret);
		sb.append("=?");
		sb.append(" WHERE ");
		sb.append(id);
		sb.append("=?");
		return sb.toString();
	}
	
	private static String createUpdateCantitateQuery(String id, String cantitate) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append(" produs ");
		sb.append(" set ");
		sb.append(cantitate);
		sb.append("=?");
		sb.append(" WHERE ");
		sb.append(id);
		sb.append(" =? ");
		return sb.toString();
	}

	public Produs updateProductPrice(int id, float newPrice) throws Exception {
		Produs modifiedPrice = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdatePriceQuery("id","pret");
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setFloat(1, newPrice);
			statement.setInt(2, id);
			statement.executeUpdate();
			modifiedPrice = this.findById(id);
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING, "produs" + "DAO:UpdatePrice" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
    	
    	return modifiedPrice;
	}

	public Produs updateProductName(int id, String newName) throws Exception {
		Produs modifiedProduct = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateNameQuery("id", "nume");

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, newName);
			statement.setInt(2, id);
			statement.executeUpdate();
			modifiedProduct = this.findById(id);

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "produs" + "DAO:UpdateName" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return modifiedProduct;
	}
	
	public Produs updateProductCantitate(int id, int cantitate) throws Exception {
		Produs modifiedCantitate = null;
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
			modifiedCantitate = this.findById(id);
		}catch (SQLException e) {
			LOGGER.log(Level.WARNING, "produs" + "DAO:UpdateCantitate" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
    	
    	return modifiedCantitate;
	}
	
	public Produs insert(Produs p) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int insertedId = -1;
		
		String query = createInsertQuery("nume","pret","cantitate");
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, p.getNume());
			statement.setFloat(2, p.getPret());
			statement.setInt(3,p.getCantitate());
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				insertedId = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, " client " + "DAO:Insert " + e.getMessage());
		}finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return this.findById(insertedId);
	}
}
