package bussinessll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.*;
import model.Comanda;
import model.Produs;
import dao.*;

public class ComandaBLL {
	private List<Validator<Comanda>> validators;
	private ComandaDAO comandaDAO;

	public ComandaBLL() {
		validators = new ArrayList<Validator<Comanda>>();
		validators.add(new ComandaCantitateValidator());
		comandaDAO = new ComandaDAO();
	}

	public Comanda findComandaByID(int id) throws Exception {
		Comanda c = comandaDAO.findById(id);
		if (c == null) {
			throw new NoSuchElementException("Comanda cu id-ul =" + id + "was not found");
		}

		return c;
	}
	
	
	
	public String[] coloaneComanda(Comanda comanda) {
		return comandaDAO.columns(comanda);
	}
	
	public String[] valuesComanda(Comanda c) {
		return AbstractDAO.values(c);
	}

	public boolean deleteComandaById(int id) throws Exception {
		boolean wasDeleted = false;
		Comanda p = comandaDAO.findById(id);
		if (p == null) {
			throw new NoSuchElementException("Comanda cu id-ul =" + id + "was not found");
		}

		comandaDAO.deleteById(id);
		wasDeleted = true;
		return wasDeleted;
	}

	public List<Comanda> findAllBills() {
		List<Comanda> comenzi = comandaDAO.findAll();
		if (comenzi == null) {
			throw new NoSuchElementException("Lista de comenzi este goala");
		}

		return comenzi;
	}
	
	public Comanda insertComanda(Comanda comanda) throws Exception {
		Comanda c = comandaDAO.insert(comanda);
		ComandaCantitateValidator cv = new ComandaCantitateValidator();
		cv.validate(c);
		
		return c;
	}
	
	public Comanda updateCantitateComanda(int id, int cantitate) throws Exception {
		Comanda c = comandaDAO.updateComandaCantitate(id, cantitate);
		ComandaCantitateValidator cv = new ComandaCantitateValidator();
		cv.validate(c);
		return c;
	}
}
