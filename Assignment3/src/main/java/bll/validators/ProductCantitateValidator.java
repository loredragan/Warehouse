package bll.validators;

import model.Produs;

public class ProductCantitateValidator implements Validator<Produs>{
	private static final int MIN_CANTITATE = 0;
	
	public void validate(Produs p) {
		if (p.getCantitate() < MIN_CANTITATE) {
			throw new IllegalArgumentException("You can not have negative numbers for quantity!");
		}
	}
}
