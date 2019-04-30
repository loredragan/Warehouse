package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import com.mysql.jdbc.Field;

import connection.ConnectionFactory;
import model.Client;

public class ClientDAO extends AbstractDAO<Client> {

	private static String createInsertQuery(String name, String varsta) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(" client ");
		sb.append("( ");
		sb.append(name);
		sb.append(",");
		sb.append(varsta);
		sb.append(")");
		sb.append(" VALUES ");
		sb.append("(");
		sb.append("?");
		sb.append(",");
		sb.append("?");
		sb.append(")");

		return sb.toString();
	}

	private static String createUpdateNameQuery(String id, String name) {
		StringBuilder sb = new StringBuilder();
		// id si name sunt coloanele din tabel
		sb.append("UPDATE ");
		sb.append(" client ");
		sb.append(" SET ");
		sb.append(name);
		sb.append(" =?");
		sb.append(" WHERE ");
		sb.append(id);
		sb.append("=?");
		return sb.toString();
	}

	private static String createUpdateVarstaQuery(String id, String varsta) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append(" client ");
		sb.append(" set ");
		sb.append(varsta);
		sb.append("=?");
		sb.append(" WHERE ");
		sb.append(id);
		sb.append("=?");
		return sb.toString();
	}

	public Client updateClientAge(int id, int newAge) throws Exception {
		Client modifiedClient = null;
		Connection connection = null;
		PreparedStatement updateNameStatement = null;
		ResultSet resultSet = null;
		String query = createUpdateNameQuery("id", "varsta");

		try {
			connection = ConnectionFactory.getConnection();
			updateNameStatement = connection.prepareStatement(query);
			updateNameStatement.setInt(1, newAge);
			updateNameStatement.setInt(2, id);
			updateNameStatement.executeUpdate();
			modifiedClient = this.findById(id);

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "client" + "DAO:UpdateName" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(updateNameStatement);
			ConnectionFactory.close(connection);
		}

		return modifiedClient;
	}

	public Client updateClientName(int id, String newName) throws Exception { // trebuie sa imi modifice numele, dau
																				// numele, in functie de id ul trimis
		Client modifiedClient = null;
		Connection connection = null;
		PreparedStatement updateNameStatement = null;
		ResultSet resultSet = null;
		String query = createUpdateNameQuery("id", "nume");

		try {
			connection = ConnectionFactory.getConnection();
			updateNameStatement = connection.prepareStatement(query);
			updateNameStatement.setString(1, newName);
			updateNameStatement.setInt(2, id);
			updateNameStatement.executeUpdate();
			modifiedClient = this.findById(id);

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "client" + "DAO:UpdateName" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(updateNameStatement);
			ConnectionFactory.close(connection);
		}

		return modifiedClient;

	}
	
	

	public Client insert(Client c) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int insertedId = -1;

		String query = createInsertQuery("nume", "varsta");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, c.getNume());
			statement.setInt(2, c.getVarsta());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, " client " + "DAO:Insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return this.findById(insertedId);
	}

}
