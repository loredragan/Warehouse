package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.util.*;

public class ViewOperatiiComanda extends JFrame {
	JButton findByID;
	JButton deleteByID;
	JButton updateByID;
	JButton insert;
	JButton findComandaWithID;
	JButton deleteComandaWithID;
	JButton updateComandaWithID;
	JButton insertComanda;

	JPanel cardFindID;
	JPanel cardDeleteID;
	JPanel cardUpdateID;
	JPanel cardInsert;

	JTextField findTextField;
	JTextField deleteTextField;
	JTextField updateTextField;
	JTextField updateCantitate;
	JTextField insertCantitate;
	JTextField insertIDclient;
	JTextField insertIDprodus;

	JLabel resultFind;
	JLabel resultDelete;
	JLabel resultUpdate;
	JLabel resultInsert;

	ArrayList<Integer> clientsID;
	ArrayList<Integer> productsID;
	final CardLayout cardLayout = new CardLayout();
	final JPanel cardPanel = new JPanel(cardLayout);

	@SuppressWarnings("static-access")
	public ViewOperatiiComanda() {
//		this.clientsID = c;
//		this.productsID = p;
//		String[] clientsArray = new String[this.clientsID.size()];
//		String[] productsArray = new String[this.productsID.size()];
//
//		for(int i=0; i<this.clientsID.size(); i++) {
//			clientsArray[i] = String.valueOf(clientsID.get(i));
//		}
//		
//		for(int i=0; i<this.productsID.size(); i++) {
//			productsArray[i] = String.valueOf(productsID.get(i));
//		}
//		

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		this.setName("Operatii comanda");
		this.setSize(500, 500);

		// FIND BY ID
		this.cardFindID = new JPanel();
		JLabel insertFindID = new JLabel("Inserati ID:");
		this.findTextField = new JTextField(5);
		this.cardFindID.add(insertFindID);
		this.cardFindID.add(findTextField);
		this.findComandaWithID = new JButton("FIND IT");
		this.cardFindID.add(findComandaWithID);
		this.resultFind = new JLabel("---");
		this.cardFindID.add(resultFind);
		Random rand = new Random();
		float red1 = rand.nextFloat();
		float green1 = rand.nextFloat();
		float blue1 = rand.nextFloat();
		cardFindID.setBackground(new Color(red1, green1, blue1));

		// DELETE BY ID
		this.cardDeleteID = new JPanel();
		JLabel insertDeleteID = new JLabel("Inserati ID");
		this.deleteTextField = new JTextField(5);
		this.cardDeleteID.add(insertDeleteID);
		this.cardDeleteID.add(deleteTextField);
		this.deleteComandaWithID = new JButton("DELETE IT");
		this.cardDeleteID.add(deleteComandaWithID);
		this.resultDelete = new JLabel("---");
		this.cardDeleteID.add(resultDelete);
		float red11 = rand.nextFloat();
		float green11 = rand.nextFloat();
		float blue11 = rand.nextFloat();
		cardDeleteID.setBackground(new Color(red11, green11, blue11));

		// UPDATE BY ID
		this.cardUpdateID = new JPanel();
		JLabel insertUpdateID = new JLabel("Inserati ID");
		this.updateTextField = new JTextField(5);
		this.cardUpdateID.add(insertUpdateID);
		this.cardUpdateID.add(updateTextField);
		JLabel labelCantitate = new JLabel("Inserati noua cantitate pentru comanda");
		this.updateCantitate = new JTextField(20);
		this.cardUpdateID.add(labelCantitate);
		this.cardUpdateID.add(updateCantitate);
		this.updateComandaWithID = new JButton("UPDATE IT");
		this.cardUpdateID.add(updateComandaWithID);
		this.resultUpdate = new JLabel("---");
		this.cardUpdateID.add(resultUpdate);
		float red111 = rand.nextFloat();
		float green111 = rand.nextFloat();
		float blue111 = rand.nextFloat();
		cardUpdateID.setBackground(new Color(red111, green111, blue111));

		// INSERT
		this.cardInsert = new JPanel();

		this.insertIDclient = new JTextField(10);
		this.insertIDprodus = new JTextField(10);
//		this.selectClientID.setSelectedIndex(0);
//		this.selectProdusID.setSelectedIndex(0);
		JLabel chooseClient = new JLabel("Alegeti clientul pentru care doriti sa faceti comanda");
		this.cardInsert.add(chooseClient);
		this.cardInsert.add(insertIDclient);
		JLabel chooseProduct = new JLabel("Alegeti produsul dorit");
		this.cardInsert.add(chooseProduct);
		this.cardInsert.add(insertIDprodus);
		JLabel insertCantitateLabel = new JLabel("Inserati cantiatea dorita");
		this.insertCantitate = new JTextField(5);
		this.cardInsert.add(insertCantitateLabel);
		this.cardInsert.add(insertCantitate);
		this.insertComanda = new JButton("INSERT IT");
		this.cardInsert.add(insertComanda);
		this.resultInsert = new JLabel("---");
		this.cardInsert.add(resultInsert);
		float red1111 = rand.nextFloat();
		float green1111 = rand.nextFloat();
		float blue1111 = rand.nextFloat();
		cardInsert.setBackground(new Color(red1111, green1111, blue1111));

		cardPanel.add(cardFindID, "FindByID");
		cardPanel.add(cardDeleteID, "DeleteByID");
		cardPanel.add(cardUpdateID, "UpdateByID");
		cardPanel.add(cardInsert, "InsertComanda");

		// BUTOANE MAINVIEW
		JPanel buttonPanel = new JPanel();
		this.findByID = new JButton("Find by ID");
		this.deleteByID = new JButton("Delete by ID");
		this.updateByID = new JButton("Update by ID");
		this.insert = new JButton("Insert");
		buttonPanel.add(this.findByID);
		buttonPanel.add(this.deleteByID);
		buttonPanel.add(updateByID);
		buttonPanel.add(this.insert);
		this.add(cardPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	public void addFindOperationListener(ActionListener listener) {
		this.findByID.addActionListener(listener);
	}

	public void addDeleteOperationListener(ActionListener listener) {
		this.deleteByID.addActionListener(listener);
	}

	public void addUpdateOperationListener(ActionListener listener) {
		this.updateByID.addActionListener(listener);
	}

	public void addInsertOperationListener(ActionListener listener) {
		this.insert.addActionListener(listener);
	}

	public void addFindComandaByIdListener(ActionListener listener) {
		this.findComandaWithID.addActionListener(listener);
	}

	public void addDeleteComandaByIdListener(ActionListener listen) {
		this.deleteComandaWithID.addActionListener(listen);
	}

	public void addUpdateComandaByIdListener(ActionListener listen) {
		this.updateComandaWithID.addActionListener(listen);
	}

	public void addInsertComandaListener(ActionListener listen) {
		this.insertComanda.addActionListener(listen);
	}

	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
