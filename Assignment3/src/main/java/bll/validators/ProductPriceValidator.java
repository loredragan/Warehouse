package bll.validators;

import model.Produs;

public class ProductPriceValidator implements Validator<Produs> {
	private static final int MIN_PRICE = 1;

	public void validate(Produs p) {
		if (p.getPret() < MIN_PRICE) {
			throw new IllegalArgumentException("The Product Price limit is not respected!");
		}

	}

}
