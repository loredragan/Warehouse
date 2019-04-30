package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class ViewOperatiiClient extends JFrame {
	JButton findByID; // gasire dupa id - butoanele din mainView
	JButton deleteByID; // stergere dupa id
	JButton updateByID; // update dupa id
	JButton insert; // inserare
	JButton findClientWithID; // buton pentru gasire in operatie
	JButton deleteClientWithID; // cand se apasa se sterge din tabela
	JButton updateClientWithID; // cand se apasa se face update in tabela
	JButton insertClient; // cand se apasa se insereaza in tabela
	
	JPanel cardFindID;// panouri pentru fiecare operatie
	JPanel cardDeleteID; //
	JPanel cardUpdateID;
	JPanel cardInsert;
	
	JTextField findTextField;// pt inserare ID pe operatie
	JTextField deleteTextField;
	JTextField updateTextField;
	JTextField updateName; // pt update nume client
	JTextField updateAge; // pentru update varsta client
	JTextField insertName;
	JTextField insertAge;

	JLabel resultFind;
	JLabel resultDelete;
	JLabel resultUpdate;
	JLabel resultInsert;
	final CardLayout cardLayout = new CardLayout();
	final JPanel cardPanel = new JPanel(cardLayout);

	public ViewOperatiiClient() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		this.setName("Operatii client");
		this.setSize(500, 500);

		

		// FIND BY ID
		this.cardFindID = new JPanel();
		JLabel insertFindID = new JLabel("Inserati ID");
		this.findTextField = new JTextField(5);
		this.cardFindID.add(insertFindID);
		this.cardFindID.add(findTextField);
		this.findClientWithID = new JButton("FIND IT");
		this.cardFindID.add(findClientWithID);
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
		this.deleteClientWithID = new JButton("DELETE IT");
		this.cardDeleteID.add(deleteClientWithID);
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
		JLabel labelAge = new JLabel("Inserati noua valoare pentru varsta");
		this.updateAge = new JTextField(20);
		this.cardUpdateID.add(labelAge);
		this.cardUpdateID.add(updateAge);
		this.updateClientWithID = new JButton("UPDATE IT");
		this.cardUpdateID.add(updateClientWithID);
		this.resultUpdate = new JLabel("---");
		this.cardUpdateID.add(resultUpdate);
		float red111 = rand.nextFloat();
		float green111 = rand.nextFloat();
		float blue111 = rand.nextFloat();
		cardUpdateID.setBackground(new Color(red111, green111, blue111));
		// INSERT BY ID
		this.cardInsert = new JPanel();
		JLabel insertNewName = new JLabel("Inserati numele noului client");
		this.insertName = new JTextField(20);
		cardInsert.add(insertNewName);
		cardInsert.add(insertName);
		JLabel insertNewAge = new JLabel("Inserati varsta noului client");
		this.insertAge = new JTextField(20);
		cardInsert.add(insertNewAge);
		cardInsert.add(insertAge);
		insertClient = new JButton("INSERT IT");
		cardInsert.add(insertClient);
		this.resultInsert = new JLabel("---");
		this.cardInsert.add(resultInsert);
		float red1111 = rand.nextFloat();
		float green1111 = rand.nextFloat();
		float blue1111 = rand.nextFloat();
		cardInsert.setBackground(new Color(red1111, green1111, blue1111));
		cardPanel.add(cardFindID, "FindByID");
		cardPanel.add(cardDeleteID, "DeleteByID");
		cardPanel.add(cardUpdateID, "UpdateByID");
		cardPanel.add(cardInsert, "InsertClient");
		// BUTOANE MAIN VIEW;
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
	
	
	public void addDeleteOperationListener(ActionListener listen) {
		this.deleteByID.addActionListener(listen);
	}
	
	public void addUpdateOperationListener(ActionListener listen) {
		this.updateByID.addActionListener(listen);
	}
	
	public void addInsertOperationListener(ActionListener listen) {
		this.insert.addActionListener(listen);
	}
	public void addFindOperationListener(ActionListener listen) {
		this.findByID.addActionListener(listen);
	}
	
	void addFindClientByIdListener(ActionListener listen) {
		this.findClientWithID.addActionListener(listen);
	}
	
	void addDeleteClientByIdListener(ActionListener listen) {
		this.deleteClientWithID.addActionListener(listen);
	}
	
	void addUpdateClientByIdListener(ActionListener listen) {
		this.updateClientWithID.addActionListener(listen);
	}
	
	void addInsertClientListener(ActionListener listener) {
		this.insertClient.addActionListener(listener);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	
}
