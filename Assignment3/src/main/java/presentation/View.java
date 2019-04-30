package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class View extends JFrame {
	JButton produs;
	JButton client;
	JButton comenzi;
	JPanel cardComanda;
	JPanel cardProdus;
	JPanel cardClient;
	JButton showAllClients;
	JButton operatiiClient;
	JButton showAllProducts;
	JButton operatiiProdus;
	JButton showAllOrders;
	JButton operatiiComenzi;
	
	
	public View() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		this.setName("Warehouse management");

		this.setSize(300, 300);

		final CardLayout cardLayout = new CardLayout();
		final JPanel cardPanel = new JPanel(cardLayout);

		//panou clienti
	
		
		
		
		// CLIENTUL
		this.cardClient = new JPanel();
		this.showAllClients = new JButton("Vizualizeaza clientii");
		this.operatiiClient = new JButton("Operatii client");
		this.cardClient.add(showAllClients);
		this.cardClient.add(operatiiClient);
		Random rand = new Random();
		float red1 = rand.nextFloat();
		float green1 = rand.nextFloat();
		float blue1 = rand.nextFloat();
		cardClient.setBackground(new Color(red1, green1, blue1));

		// PRODUSUL
		this.cardProdus = new JPanel();
		this.showAllProducts = new JButton("Vizualizeaza produsele");
		this.operatiiProdus = new JButton("Operatii produs");
		this.cardProdus.add(showAllProducts);
		this.cardProdus.add(operatiiProdus);
		Random rand1 = new Random();
		float red11 = rand.nextFloat();
		float green11 = rand.nextFloat();
		float blue11 = rand.nextFloat();
		cardProdus.setBackground(new Color(red11, green11, blue11));

		// COMANDA
		this.cardComanda = new JPanel();
		this.showAllOrders = new JButton("Vizualizeaza comenzile");
		this.operatiiComenzi = new JButton("Operatii comenzi");
		this.cardComanda.add(showAllOrders);
		this.cardComanda.add(operatiiComenzi);
		Random rand11 = new Random();
		float red111 = rand.nextFloat();
		float green111 = rand.nextFloat();
		float blue111 = rand.nextFloat();
		cardComanda.setBackground(new Color(red111, green111, blue111));

		cardPanel.add(cardClient, "Client");
		cardPanel.add(cardProdus, "Produs");
		cardPanel.add(cardComanda, "Comenzi");
		
		// BUTOANE MAIN VIEW
		JPanel buttonPanel = new JPanel();
		this.client = new JButton("Clienti");
		this.comenzi = new JButton("Comenzi");
		this.produs = new JButton("Produse");

		buttonPanel.add(this.client);
		buttonPanel.add(this.produs);
		buttonPanel.add(this.comenzi);

		this.client.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Client");
				Random rand = new Random();
				float red1 = rand.nextFloat();
				float green1 = rand.nextFloat();
				float blue1 = rand.nextFloat();
				cardClient.setBackground(new Color(red1, green1, blue1));

			}
		});

		this.comenzi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Comenzi");
				Random rand = new Random();
				float red1 = rand.nextFloat();
				float green1 = rand.nextFloat();
				float blue1 = rand.nextFloat();
				cardComanda.setBackground(new Color(red1, green1, blue1));

			}
		});

		this.produs.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Produs");
				Random rand = new Random();
				float red1 = rand.nextFloat();
				float green1 = rand.nextFloat();
				float blue1 = rand.nextFloat();
				cardProdus.setBackground(new Color(red1, green1, blue1));
			}
		});

		this.add(cardPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	void addShowAllClientsListener(ActionListener listener) {
		this.showAllClients.addActionListener(listener);
	}

	void addShowAllProductsListener(ActionListener listener) {
		this.showAllProducts.addActionListener(listener);
	}

	void addshowAllOrdersListener(ActionListener listener) {
		this.showAllOrders.addActionListener(listener);
	}

	void addOperatiiClientListener(ActionListener listener) {
		this.operatiiClient.addActionListener(listener);
	}

	void addOperatiiProdusListener(ActionListener listener) {
		this.operatiiProdus.addActionListener(listener);
	}

	void addOperatiiComandaListener(ActionListener listener) {
		this.operatiiComenzi.addActionListener(listener);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	public void addShowClientsListener(ActionListener listener) {
		this.showAllClients.addActionListener(listener);
	}
	
	public void addShowProductsListener(ActionListener listener) {
		this.showAllProducts.addActionListener(listener);
	}
	
	public void addShowOrdersListener(ActionListener listener) {
		this.showAllOrders.addActionListener(listener);
	}
	
}
