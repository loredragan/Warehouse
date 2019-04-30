package presentation;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.util.*;

public class ViewOperatiiProdus extends JFrame {

	JButton findByID; // gasire dupa id
	JButton deleteByID; // stergere dupa id
	JButton updateByID; // update dupa ID
	JButton insert; // inserare
	JButton findProdusWithID; // pentru a efectua operatia de cautare
	JButton deleteProdusWithID;
	JButton updateProdusWithID;
	JButton insertProdus;

	JPanel cardFindID; // panouri pentru fiecare operatie
	JPanel cardDeleteID;
	JPanel cardUpdateID;
	JPanel cardInsert;

	JTextField findTextField; // pt inserare ID pe operatie
	JTextField deleteTextField;
	JTextField updateTextField;
	JTextField updateName;
	JTextField updateCantitate;
	JTextField updatePret;
	JTextField insertNume;
	JTextField insertCantitate;
	JTextField insertPret;

	JLabel resultFind;
	JLabel resultDelete;
	JLabel resultUpdate;
	JLabel resultInsert;
	final CardLayout cardLayout = new CardLayout();
	final JPanel cardPanel = new JPanel(cardLayout);


	public ViewOperatiiProdus() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		this.setName("Operatii produs");
		this.setSize(500, 500);

		
		// FIND BY ID
		this.cardFindID = new JPanel();
		JLabel insertFindID = new JLabel("Inserati ID:");
		this.findTextField = new JTextField(5);
		this.cardFindID.add(insertFindID);
		this.cardFindID.add(findTextField);
		this.findProdusWithID = new JButton("FIND IT");
		this.cardFindID.add(findProdusWithID);
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
		this.deleteProdusWithID = new JButton("DELETE IT");
		this.cardDeleteID.add(deleteProdusWithID);
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
		JLabel labelName = new JLabel("Inserati noua valoare pentru nume");
		this.updateName = new JTextField(20);
		this.cardUpdateID.add(labelName);
		this.cardUpdateID.add(updateName);
		JLabel labelCantitate = new JLabel("Inserati noua valoare pentru cantitate");
		this.updateCantitate = new JTextField(20);
		this.cardUpdateID.add(labelCantitate);
		this.cardUpdateID.add(updateCantitate);
		JLabel labelPret = new JLabel("Inserati noua valoare pentru pret");
		this.updatePret = new JTextField(20);
		this.cardUpdateID.add(labelPret);
		this.cardUpdateID.add(updatePret);
		this.updateProdusWithID = new JButton("UPDATE IT");
		this.cardUpdateID.add(updateProdusWithID);
		this.resultUpdate = new JLabel("---");
		this.cardUpdateID.add(resultUpdate);
		float red111 = rand.nextFloat();
		float green111 = rand.nextFloat();
		float blue111 = rand.nextFloat();
		cardUpdateID.setBackground(new Color(red111, green111, blue111));

		// INSERT BY ID
		this.cardInsert = new JPanel();
		JLabel insertNewName = new JLabel("Inserati numele noului produs");
		this.insertNume = new JTextField(20);
		cardInsert.add(insertNewName);
		cardInsert.add(insertNume);
		JLabel insertNewCantitate = new JLabel("Inserati cantitatea noului produs");
		this.insertCantitate = new JTextField(20);
		cardInsert.add(insertNewCantitate);
		cardInsert.add(insertCantitate);
		JLabel insertNewPret = new JLabel("Inserati pretul noului produs");
		this.insertPret = new JTextField(20);
		cardInsert.add(insertNewPret);
		cardInsert.add(insertPret);
		insertProdus = new JButton("Inserati produsul");
		cardInsert.add(insertProdus);
		this.resultInsert = new JLabel("---");
		this.cardInsert.add(resultInsert);
		float red1111 = rand.nextFloat();
		float green1111 = rand.nextFloat();
		float blue1111 = rand.nextFloat();
		cardInsert.setBackground(new Color(red1111, green1111, blue1111));

		cardPanel.add(cardFindID, "FindByID");
		cardPanel.add(cardDeleteID, "DeleteByID");
		cardPanel.add(cardUpdateID, "UpdateByID");
		cardPanel.add(cardInsert, "InsertProdus");

		// BUTOANE MAI VIEW
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
		//this.setVisible(true);

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
	
	public void addFindProdusByIdListener(ActionListener listener) {
		this.findProdusWithID.addActionListener(listener);
	}
	
	public void addDeleteProdusByIdListener(ActionListener listener) {
		this.deleteProdusWithID.addActionListener(listener);
	}
	
	public void addUpdateProdusByIdListener(ActionListener listener) {
		this.updateProdusWithID.addActionListener(listener);
	}
	
	public void addInsertProdusListener(ActionListener listener) {
		this.insertProdus.addActionListener(listener);
	}

	public static void main(String[] args) {
		ViewOperatiiProdus vp = new ViewOperatiiProdus();
	}
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
