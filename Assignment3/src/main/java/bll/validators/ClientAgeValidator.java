package bll.validators;

import model.Client;

public class ClientAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 12;
	private static final int MAX_AGE = 100;
	
	public void validate(Client c) {
		if (c.getVarsta() < MIN_AGE || c.getVarsta() > MAX_AGE) {
			throw new IllegalArgumentException("The Student Age limit is not respected!");
		}

	}
}
