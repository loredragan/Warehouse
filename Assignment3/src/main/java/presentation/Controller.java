package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.html.HTMLDocument.Iterator;

import bussinessll.ClientBLL;
import bussinessll.ComandaBLL;
import bussinessll.ProdusBLL;
import model.Client;
import model.Comanda;
import model.Produs;
import start.ReflectionTech;

public class Controller {
	private View mainView;
	ViewOperatiiClient clientOperationView;
	ViewOperatiiComanda orderOperationView;
	ViewOperatiiProdus productOperationView;
	ComandaBLL comanda = new ComandaBLL();
	ClientBLL client = new ClientBLL();
	ProdusBLL produs = new ProdusBLL();
	static int i=0;
	public Controller(View view) {
		this.mainView = view;

//////////////////////OPERATII CLIENT///////////////////////////////////////////////////////	

		mainView.addShowClientsListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				List<Client> clienti= client.findAllClients();
				String[] coloane = client.coloaneClient(clienti.get(0));
				String[][] data = new String[clienti.size()][coloane.length];
				for(int i=0; i<clienti.size(); i++) {
					String[] values = client.valuesClient(clienti.get(i));
					data[i]=values;
				}
				
				JTable jt = new JTable(data,coloane);
			
				JScrollPane sp = new JScrollPane(jt);
				JFrame f = new JFrame();
				f.add(sp);
				f.setVisible(true);
				f.setSize(500,500);
				
				
				
			}
		});
		
		mainView.addShowProductsListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				List<Produs> produse= produs.findAllProdcts();
				String[] coloane = produs.coloaneProdus(produse.get(0));
				String[][] data = new String[produse.size()][coloane.length];
				for(int i=0; i<produse.size(); i++) {
					String[] values = produs.valuesProdus(produse.get(i));
					data[i]=values;
				}
				
				JTable jt = new JTable(data,coloane);
			
				JScrollPane sp = new JScrollPane(jt);
				JFrame f = new JFrame();
				f.add(sp);
				f.setVisible(true);
				f.setSize(500,500);
			}
		});
		
		mainView.addShowOrdersListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				List<Comanda> comenzi= comanda.findAllBills();
				String[] coloane = comanda.coloaneComanda(comenzi.get(0));
				String[][] data = new String[comenzi.size()][coloane.length];
				for(int i=0; i<comenzi.size(); i++) {
					String[] values = comanda.valuesComanda(comenzi.get(i));
					data[i]=values;
				}
				
				JTable jt = new JTable(data,coloane);
			
				JScrollPane sp = new JScrollPane(jt);
				JFrame f = new JFrame();
				f.add(sp);
				f.setVisible(true);
				f.setSize(500,500);
			}
		});
		mainView.addOperatiiClientListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				clientOperationView = new ViewOperatiiClient();
				clientOperationView.setVisible(true);

				// buton find pentru operatie find by id

				clientOperationView.addFindClientByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeFound = clientOperationView.findTextField.getText();
						try {
							int searchId = Integer.parseInt(toBeFound);
							Client c = client.findClientById(searchId);
							clientOperationView.resultFind.setText(ReflectionTech.retrieveProperties(c));
						} catch (IndexOutOfBoundsException ex) {
							clientOperationView
									.displayErrorMessage("Clientul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							clientOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				clientOperationView.addDeleteClientByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeDeleted = clientOperationView.deleteTextField.getText();
						try {
							int deleteId = Integer.parseInt(toBeDeleted);
							boolean del = client.deleteClientById(deleteId);
							if (del) {
								clientOperationView.resultDelete
										.setText("Clientul cu ID-ul " + deleteId + " a fost sters");
							}

						} catch (IndexOutOfBoundsException ex) {
							clientOperationView
									.displayErrorMessage("Clientul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							clientOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}
					}
				});

				clientOperationView.addUpdateClientByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String id = clientOperationView.updateTextField.getText();
						int ageSet = 0;

						try {
							int idd = Integer.parseInt(id);
							if ((!clientOperationView.updateAge.getText().isEmpty())
									&& (!clientOperationView.updateName.getText().isEmpty())) {
								String age = clientOperationView.updateAge.getText();
								String name = clientOperationView.updateName.getText();
								ageSet = Integer.parseInt(age);

								Client c = client.updateAgeClient(idd, ageSet);
								c = client.updateNameClient(idd, name);
								clientOperationView.resultUpdate.setText(
										"Varsta si numele clientului cu ID-ul " + idd + " au fost actualizate");
							} else if ((!clientOperationView.updateAge.getText().isEmpty())
									&& (clientOperationView.updateName.getText().isEmpty())) {
								String age = clientOperationView.updateAge.getText();
								ageSet = Integer.parseInt(age);
								Client c = client.updateAgeClient(idd, ageSet);
								clientOperationView.resultUpdate
										.setText("Varsta clientului cu ID-ul " + idd + " a fost actualizata");
							} else if ((clientOperationView.updateAge.getText().isEmpty())
									&& (!clientOperationView.updateName.getText().isEmpty())) {
								String name = clientOperationView.updateName.getText();
								Client c = client.updateNameClient(idd, name);
								clientOperationView.resultUpdate
										.setText("Numele clientului cu ID-ul " + idd + " a fost actualizat");
							}
						} catch (IndexOutOfBoundsException ex) {
							clientOperationView
									.displayErrorMessage("Clientul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							clientOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				clientOperationView.addInsertClientListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						try {
							if (((clientOperationView.updateAge.getText().isEmpty())
									&& (clientOperationView.insertName.getText().isEmpty()))
									|| clientOperationView.insertAge.getText().isEmpty()
									|| clientOperationView.insertName.getText().isEmpty()) {
								clientOperationView
										.displayErrorMessage("Trebuie sa introduceti date in toate casutele");
							}
							String age = clientOperationView.insertAge.getText();
							String name = clientOperationView.insertName.getText();
							int ageInt = Integer.parseInt(age);
							Client c = new Client(name, ageInt);
							Client inserted = client.insertClient(c);
							if (inserted != null) {
								clientOperationView.resultInsert
										.setText("S-a inserat cu succes clientul cu ID-ul " + inserted.getId());
							}

						} catch (IndexOutOfBoundsException ex) {
							clientOperationView
									.displayErrorMessage("Clientul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							clientOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				// FIND BY ID CLIENT BUTTON FROM PANEL:
				clientOperationView.addFindOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						clientOperationView.cardLayout.show(clientOperationView.cardPanel, "FindByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						clientOperationView.cardFindID.setBackground(new Color(red1, green1, blue1));

					}
				});

				clientOperationView.addDeleteOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						clientOperationView.cardLayout.show(clientOperationView.cardPanel, "DeleteByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						clientOperationView.cardDeleteID.setBackground(new Color(red1, green1, blue1));

					}
				});

				clientOperationView.addUpdateOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						clientOperationView.cardLayout.show(clientOperationView.cardPanel, "UpdateByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						clientOperationView.cardUpdateID.setBackground(new Color(red1, green1, blue1));

					}
				});

				clientOperationView.addInsertOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						clientOperationView.cardLayout.show(clientOperationView.cardPanel, "InsertClient");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						clientOperationView.cardInsert.setBackground(new Color(red1, green1, blue1));

					}
				});

			}
		});

//////////////////////////OPERATII PRODUSE//////////////////////////////////////////////////////////////////

		mainView.addOperatiiProdusListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				productOperationView = new ViewOperatiiProdus();
				productOperationView.setVisible(true);

				productOperationView.addFindProdusByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeFound = productOperationView.findTextField.getText();
						try {
							int searchId = Integer.parseInt(toBeFound);
							Produs c = produs.findProdusByID(searchId);
							productOperationView.resultFind.setText(ReflectionTech.retrieveProperties(c));
						} catch (IndexOutOfBoundsException ex) {
							productOperationView
									.displayErrorMessage("Produsul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							productOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				productOperationView.addDeleteProdusByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeDeleted = productOperationView.deleteTextField.getText();
						try {
							int deleteId = Integer.parseInt(toBeDeleted);
							boolean del = produs.deleteProdusById(deleteId);
							if (del) {
								productOperationView.resultDelete
										.setText("Produsul cu ID-ul " + deleteId + " a fost sters");
							}

						} catch (IndexOutOfBoundsException ex) {
							productOperationView
									.displayErrorMessage("Produsul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							productOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				productOperationView.addUpdateProdusByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String id = productOperationView.updateTextField.getText();
						int cantitateSet = 0;
						float pretSet = 0.0f;

						try {
							int idd = Integer.parseInt(id);
							if ((!productOperationView.updateCantitate.getText().isEmpty())
									&& (!productOperationView.updatePret.getText().isEmpty())
									&& (!productOperationView.updateName.getText().isEmpty())) {
								String pret = productOperationView.updatePret.getText();
								String name = productOperationView.updateName.getText();
								String cantitate = productOperationView.updateCantitate.getText();
								cantitateSet = Integer.parseInt(cantitate);
								pretSet = Float.parseFloat(pret);

								Produs c = produs.updateNameProdus(idd, name);
								c = produs.updatePriceProduct(idd, pretSet);
								c = produs.updateCantitateProdus(idd, cantitateSet);

								productOperationView.resultUpdate.setText(
										"Cantitatea si numele si pretul produsului cu ID-ul " + idd + " au fost actualizate");
							} else if ((!productOperationView.updateName.getText().isEmpty())
									&& (productOperationView.updatePret.getText().isEmpty()
											&& productOperationView.updateCantitate.getText().isEmpty())) {
								String name = productOperationView.updateName.getText();

								Produs c = produs.updateNameProdus(idd, name);
								productOperationView.resultUpdate
										.setText("Numele produsului cu ID-ul " + idd + " a fost actualizat");
							} else if ((productOperationView.updateName.getText().isEmpty())
									&& (!productOperationView.updatePret.getText().isEmpty()
											&& productOperationView.updateCantitate.getText().isEmpty())) {
								String pret = productOperationView.updatePret.getText();
								pretSet = Float.parseFloat(pret);
								Produs c = produs.updatePriceProduct(idd, pretSet);
								productOperationView.resultUpdate
										.setText("Pretul produsului cu ID-ul " + idd + " a fost actualizat");
							} else if ((productOperationView.updateName.getText().isEmpty())
									&& (productOperationView.updatePret.getText().isEmpty()
											&& !productOperationView.updateCantitate.getText().isEmpty())) {
								String cantitate = productOperationView.updatePret.getText();
								cantitateSet = Integer.parseInt(cantitate);
								Produs c = produs.updateCantitateProdus(idd, cantitateSet);
								productOperationView.resultUpdate
										.setText("Cantitatea produsului cu ID-ul " + idd + " a fost actualizata");
							}
						} catch (IndexOutOfBoundsException ex) {
							productOperationView
									.displayErrorMessage("Produsul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							productOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				productOperationView.addInsertProdusListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						try {
							if (((productOperationView.insertNume.getText().isEmpty())
									&& (productOperationView.insertPret.getText().isEmpty())
									&& productOperationView.insertCantitate.getText().isEmpty())
									|| productOperationView.insertPret.getText().isEmpty()
									|| productOperationView.insertNume.getText().isEmpty()
									|| productOperationView.insertCantitate.getText().isEmpty()) {
								productOperationView
										.displayErrorMessage("Trebuie sa introduceti date in toate casutele");
							}
							String pret = productOperationView.insertPret.getText();
							String name = productOperationView.insertNume.getText();
							String cantitate = productOperationView.insertCantitate.getText();
							float pretInt = Float.parseFloat(pret);
							int cantitateInt = Integer.parseInt(cantitate);
							Produs c = new Produs(name, pretInt, cantitateInt);
							Produs inserted = produs.insertProdus(c);
							if (inserted != null) {
								productOperationView.resultInsert
										.setText("S-a inserat cu succes produsul cu ID-ul" + inserted.getId());
							}

						} catch (IndexOutOfBoundsException ex) {
							productOperationView
									.displayErrorMessage("Produsul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							productOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				productOperationView.addFindOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						productOperationView.cardLayout.show(productOperationView.cardPanel, "FindByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						productOperationView.cardFindID.setBackground(new Color(red1, green1, blue1));

					}
				});
//				
				productOperationView.addDeleteOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						productOperationView.cardLayout.show(productOperationView.cardPanel, "DeleteByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						productOperationView.cardDeleteID.setBackground(new Color(red1, green1, blue1));

					}
				});

				productOperationView.addUpdateOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						productOperationView.cardLayout.show(productOperationView.cardPanel, "UpdateByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						productOperationView.cardUpdateID.setBackground(new Color(red1, green1, blue1));

					}
				});

				productOperationView.addInsertOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						productOperationView.cardLayout.show(productOperationView.cardPanel, "InsertProdus");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						productOperationView.cardInsert.setBackground(new Color(red1, green1, blue1));

					}
				});

			}
		});

/////////////////////////OPERATII COMENZI/////////////////////////////////////////////////////////////////////////

		mainView.addOperatiiComandaListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				orderOperationView = new ViewOperatiiComanda();
				orderOperationView.setVisible(true);

				orderOperationView.addFindOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						orderOperationView.cardLayout.show(orderOperationView.cardPanel, "FindByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						orderOperationView.cardFindID.setBackground(new Color(red1, green1, blue1));

					}
				});

				orderOperationView.addFindComandaByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeFound = orderOperationView.findTextField.getText();
						try {
							int searchId = Integer.parseInt(toBeFound);
							Comanda c = comanda.findComandaByID(searchId);
							orderOperationView.resultFind.setText(ReflectionTech.retrieveProperties(c));
						} catch (IndexOutOfBoundsException ex) {
							orderOperationView
									.displayErrorMessage("Comanda cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							orderOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				orderOperationView.addDeleteComandaByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String toBeDeleted = orderOperationView.deleteTextField.getText();
						try {
							int deleteId = Integer.parseInt(toBeDeleted);
							boolean del = comanda.deleteComandaById(deleteId);
							if (del) {
								orderOperationView.resultDelete
										.setText("Comanda cu ID-ul " + deleteId + " a fost stearsa");
							}

						} catch (IndexOutOfBoundsException ex) {
							orderOperationView
									.displayErrorMessage("Comanda cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							orderOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				orderOperationView.addUpdateComandaByIdListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String id = orderOperationView.updateTextField.getText();
						int cantitateSet = 0;
						

						try {
							int idd = Integer.parseInt(id);
							if (!orderOperationView.updateCantitate.getText().isEmpty())
					{
								String cantitate = orderOperationView.updateCantitate.getText();
								cantitateSet = Integer.parseInt(cantitate); //cantitatea pe care o vreau;
								int cantitateAvuta = comanda.findComandaByID(idd).getCantitate(); //cantitatea pe care o am
								Comanda c = comanda.findComandaByID(idd);//
								Produs p = produs.findProdusByID(c.getProdusID()); //produsul care se afla in comanda
								int cantitateActualaProdus = p.getCantitate();
								if(cantitateSet > cantitateAvuta) {
									p = produs.updateCantitateProdus(p.getId(), cantitateActualaProdus-(cantitateSet - cantitateAvuta));
								}else if(cantitateSet < cantitateAvuta) {
									p = produs.updateCantitateProdus(p.getId(), cantitateActualaProdus+(cantitateAvuta - cantitateSet));
								}
								c = comanda.updateCantitateComanda(idd, cantitateSet);
							} 
						} catch (IndexOutOfBoundsException ex) {
							orderOperationView
									.displayErrorMessage("Comanda cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							orderOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				orderOperationView.addInsertComandaListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						try {
							if ((orderOperationView.insertCantitate.getText().isEmpty()
									&& orderOperationView.insertIDclient.getText().isEmpty()
									&& orderOperationView.insertIDprodus.getText().isEmpty())
									|| orderOperationView.insertCantitate.getText().isEmpty()
									|| orderOperationView.insertIDclient.getText().isEmpty()
									|| orderOperationView.insertIDprodus.getText().isEmpty()) {
								orderOperationView.displayErrorMessage("Trebuie completate toate campurile");
							}

							List<Client> clienti = client.findAllClients();
							List<Produs> produse = produs.findAllProdcts();
							int foundClientID = -1;
							int foundProdusID = -1;
							String clientId = orderOperationView.insertIDclient.getText();
							int clientIdd = Integer.parseInt(clientId);
							String produsID = orderOperationView.insertIDprodus.getText();
							System.out.println(produsID);
							int produsIdd = Integer.parseInt(produsID);
							System.out.println(produsIdd + "");
							if (orderOperationView.insertCantitate.getText().isEmpty()) {
								orderOperationView.displayErrorMessage("Trebuie sa introduceti cantitatea dorita");
							}
							float pret = 0;
							String cantitate = orderOperationView.insertCantitate.getText();
							int cantitateDorita = Integer.parseInt(cantitate);
							et: for (int i = 0; i < clienti.size(); i++) {
								if (clientIdd == clienti.get(i).getId()) {
									System.out.println("Aici intra");
									foundClientID = 1;
									break et;
								}
							}

							et2: for (int i = 0; i < produse.size(); i++) {
								if (produsIdd == produse.get(i).getId()) {
									foundProdusID = 1;
									pret = produse.get(i).getPret();
									break et2;
								}
							}

							if (foundClientID == -1) {
								orderOperationView.displayErrorMessage("Nu exista clientul cu acest ID");
							} else if (foundProdusID == -1) {
								orderOperationView.displayErrorMessage("Nu exista produsul cu acest ID");
							} else {
								Comanda comandaa = new Comanda(clientIdd, produsIdd, cantitateDorita);
								comandaa.setSumaTotala(cantitateDorita * pret);
								Produs p = produs.findProdusByID(produsIdd);
								p = produs.updateCantitateProdus(produsIdd, p.getCantitate() - cantitateDorita);

								Comanda com = comanda.insertComanda(comandaa);
								if (com != null) {
									orderOperationView.resultInsert
											.setText("S-a inserat cu succes comanda cu ID-ul" + com.getId());
								}
								if(p.getCantitate()<=0) {
									boolean b =   produs.deleteProdusById(p.getId());
								}
									
								
								 BufferedWriter writer = null;
								 try {
									 writer = new BufferedWriter(new FileWriter("factura"+i+".txt"));
									 i++;
									 writer.write(com.toString() + "\n");
								 }catch(IOException ex) {
									 ex.printStackTrace();
								 }finally {
									try {
										if(writer!=null)
											writer.close();
									}catch(IOException ex) {
										ex.printStackTrace();
									}
								 }

							}

						} catch (IndexOutOfBoundsException ex) {
							orderOperationView
									.displayErrorMessage("Produsul cu ID-ul introdus nu exista in baza de date");
						} catch (Exception ex) {
							orderOperationView.displayErrorMessage("Trebuie sa introduceti date valide");
						}

					}
				});

				orderOperationView.addDeleteOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						orderOperationView.cardLayout.show(orderOperationView.cardPanel, "DeleteByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						orderOperationView.cardDeleteID.setBackground(new Color(red1, green1, blue1));

					}
				});

				orderOperationView.addUpdateOperationListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						orderOperationView.cardLayout.show(orderOperationView.cardPanel, "UpdateByID");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						orderOperationView.cardUpdateID.setBackground(new Color(red1, green1, blue1));

					}
				});

				orderOperationView.addInsertOperationListener(new ActionListener() {

					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent e) {
						orderOperationView.cardLayout.show(orderOperationView.cardPanel, "InsertComanda");
						Random rand = new Random();
						float red1 = rand.nextFloat();
						float green1 = rand.nextFloat();
						float blue1 = rand.nextFloat();
						orderOperationView.cardInsert.setBackground(new Color(red1, green1, blue1));
//						
					}
				});

			}
		});
	}

	
}
