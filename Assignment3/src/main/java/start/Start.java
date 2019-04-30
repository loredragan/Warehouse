package start;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bussinessll.ClientBLL;
import model.Client;
import presentation.Controller;
import presentation.View;

public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {
		View v = new View();
		Controller c = new Controller(v);
		


	}
}
