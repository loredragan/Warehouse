package bll.validators;

import model.Comanda;

public class ComandaCantitateValidator implements Validator<Comanda> {
private static final int MIN_CANTITATE = 0;
	
	public void validate(Comanda p) {
		if (p.getCantitate() < MIN_CANTITATE) {
			throw new IllegalArgumentException("You can not have negative numbers for quantity!");
		}
	}
}
