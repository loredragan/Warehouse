package bussinessll;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.*;
import dao.ProdusDAO;
import model.Client;
import model.Produs;
import dao.*;

public class ProdusBLL {
	private List<Validator<Produs>> validators;
	private ProdusDAO produsDAO;

	public ProdusBLL() {
		validators = new ArrayList<Validator<Produs>>();
		validators.add(new ProductCantitateValidator());

		produsDAO = new ProdusDAO();
	}

	public Produs findProdusByID(int id) throws Exception {
		Produs p = produsDAO.findById(id);
		if (p == null) {
			throw new NoSuchElementException("Produsul cu id-ul =" + id + "was not found");
		}

		return p;
	}

	public String[] coloaneProdus(Produs p) {
		return produsDAO.columns(p);
	}
	
	public String[] valuesProdus(Produs p) {
		return AbstractDAO.values(p);
	}
	
	public boolean deleteProdusById(int id) throws Exception {
		boolean wasDeleted = false;
		Produs p = produsDAO.findById(id);
		if (p == null) {
			throw new NoSuchElementException("Produsul cu id-ul =" + id + "was not found");
		}

		produsDAO.deleteById(id);
		wasDeleted = true;
		return wasDeleted;
	}

	public List<Produs> findAllProdcts() {
		List<Produs> products = produsDAO.findAll();
		if (products == null) {
			throw new NoSuchElementException("Lista de produse este goala");
		}

		return products;
	}

	public Produs insertProdus(Produs produs) throws Exception {
		Produs c = produsDAO.insert(produs);
		ProductCantitateValidator cv = new ProductCantitateValidator();
		ProductPriceValidator pr = new ProductPriceValidator();
		cv.validate(c);
		pr.validate(c);

		return c;
	}

	public Produs updatePriceProduct(int id, float newPrice) throws Exception {
		Produs p = produsDAO.updateProductPrice(id, newPrice);
		ProductPriceValidator pr = new ProductPriceValidator();
		pr.validate(p);

		return p;
	}

	public Produs updateNameProdus(int id, String newName) throws Exception {
		return produsDAO.updateProductName(id, newName);
	}

	public Produs updateCantitateProdus(int id, int cantitate) throws Exception {
		Produs p = produsDAO.updateProductCantitate(id, cantitate);
		ProductCantitateValidator cv = new ProductCantitateValidator();
		cv.validate(p);
		return p;
	}

}
