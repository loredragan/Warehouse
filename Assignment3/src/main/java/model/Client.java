package model;

import com.mysql.jdbc.Field;

public class Client {
	public int id;
	public String nume;
	public int varsta;

	public Client() {
	}

	public Client(int id, String nume, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
	}

	public Client(String nume, int varsta) {
		super();
		this.nume = nume;
		this.varsta = varsta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nume=" + nume + ", varsta=" + varsta + "]";
	}

}
