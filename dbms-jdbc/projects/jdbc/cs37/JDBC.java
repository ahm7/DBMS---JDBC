package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import eg.edu.alexu.csd.oop.db.Database;
import eg.edu.alexu.csd.oop.db.cs37_54.Contact;
import eg.edu.alexu.csd.oop.db.cs37_54.MyDatabase;
import eg.edu.alexu.csd.oop.db.cs37_54.Validator;
import eg.edu.alexu.csd.oop.db.cs37_54.queries.Query;

public class JDBC {

	public static void main(String[] args) throws IOException {
		int i = 0;
		String query;
		Database d = new MyDatabase();
		Driver driver = new Driver();
		Properties info = new Properties();
		MyConnection connection;
		MyStatement statement;
		MyResultSet resultSet;
		MyResultSetMetaData rsmt;
		String path;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the path : ");
		path = scanner.nextLine();
		info.put("path", new File(path));
		Query q = null;
		try {
			connection = (MyConnection) driver.connect("jdbc:mySubprotocol:myDataSource", info);
			statement = (MyStatement) connection.createStatement();
			while (i == 0) {
				System.out.println("enter query");
				query = scanner.nextLine();
				try {
					Validator v = new Validator();
					if (v.setQuery(query)) {
						q = v.getItExploded();
					} else {
						throw new RuntimeException(
				"arg passed to executeupdate in mystatement class was unvalid query . check was done by validator class");
					}

				} catch (ParserConfigurationException e) {
					throw new RuntimeException(e);
				}

				if (q.getMainType().compareToIgnoreCase(Contact.selectKeys.SELECT) == 0) {
					resultSet = (MyResultSet) statement.executeQuery(query);
				}
				statement.execute(query);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
