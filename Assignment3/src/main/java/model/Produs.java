package model;

public class Produs {
	public int id;
	public String nume;
	public float pret;
	public int cantitate;

	public Produs() {

	}

	public Produs(int id, String nume, float pret, int cantitate) {
		this.id = id;
		this.nume = nume;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public Produs(String nume, float pret, int cantitate) {
		this.nume = nume;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
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

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	@Override
	public String toString() {
		return "Produs [id=" + id + ", nume=" + nume + ", pret=" + pret + "]";
	}

}
