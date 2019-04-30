package model;

public class Comanda {
	public int id;
	public int clientID;
	public int produsID;
	public int cantitate;
	public float sumaTotala;
	public Comanda() {
		
	}
	
	public Comanda(int id, int clientID, int produsID, int cantitate) {
		this.clientID = id;
		this.clientID = clientID;
		this.produsID = produsID;
		this.cantitate = cantitate;
		
	}
	
	public Comanda(int clientID, int produsID, int cantitate) {
		this.clientID = clientID;
		this.produsID = produsID;
		this.cantitate = cantitate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getProdusID() {
		return produsID;
	}

	public void setProdusID(int produsID) {
		this.produsID = produsID;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public float getSumaTotala() {
		return sumaTotala;
	}

	public void setSumaTotala(float sumaTotala) {
		this.sumaTotala = sumaTotala;
	}
	@Override
	public String toString() {
		return "Comanda [id=" + id + ", clientID=" + this.clientID + ", produsID=" + this.produsID + ", cantitate=" + this.cantitate + ", sumaTotala=" + this.sumaTotala +"]";
	}
	
	
}
