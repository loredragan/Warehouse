package bussinessll;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

import com.mysql.jdbc.Field;

import bll.validators.*;
import model.Client;
import dao.*;

public class ClientBLL {
	private List<Validator<Client>> validators;
	private ClientDAO clientDAO;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new ClientAgeValidator());

		clientDAO = new ClientDAO();
	}

	public Client findClientById(int id) throws Exception {

		Client c = clientDAO.findById(id);

		if (c == null) {
			throw new NoSuchElementException("Clientul cu id-ul =" + id + "was not found");
		}

		return c;
	}

	public boolean deleteClientById(int id) throws Exception {
		boolean wasDeleted = false;
		Client c = clientDAO.findById(id);
		if (c == null) {
			throw new NoSuchElementException("Studentul cu id-ul =" + id + "was not found");
		}

		clientDAO.deleteById(id);
		wasDeleted = true;
		return wasDeleted;

	}
	
	

	public List<Client> findAllClients() {
		List<Client> clients = clientDAO.findAll();
		if (clients == null) {
			throw new NoSuchElementException("Lista de clienti este goala");
		}

		return clients;
	}
	
	public String[] coloaneClient(Client client) {
		
		return clientDAO.columns(client);
	}
	
	public String[] valuesClient(Client client) {
		return AbstractDAO.values(client);
	}

	public Client insertClient(Client client) throws Exception {

		Client c = clientDAO.insert(client);
		ClientAgeValidator cv = new ClientAgeValidator();
		cv.validate(c);
		return c;
	}

	public Client updateNameClient(int id, String newName) throws Exception {
		Client c = clientDAO.updateClientName(id, newName);

		return c;
	}

	public Client updateAgeClient(int id, int newAge) throws Exception {

		Client c = clientDAO.updateClientAge(id, newAge);
		ClientAgeValidator cv = new ClientAgeValidator();
		cv.validate(c);
		return c;
	}

}
