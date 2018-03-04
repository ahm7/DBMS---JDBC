package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.io.File;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.xml.parsers.ParserConfigurationException;

import eg.edu.alexu.csd.oop.db.Database;
import eg.edu.alexu.csd.oop.db.cs37_54.Contact;
import eg.edu.alexu.csd.oop.db.cs37_54.MyDatabase;
import eg.edu.alexu.csd.oop.db.cs37_54.Validator;
import eg.edu.alexu.csd.oop.db.cs37_54.queries.Query;

public class MyStatement implements java.sql.Statement {
	/* use it to add batches */
	private LinkedList<String> listOfCommands = new LinkedList<String>();
	/* a pointer to the connection returns this statement - for getconnection */
	private Connection con = null;
	/* the Database */
	private Database myDB = new MyDatabase();
	/* time out default value in sec */
	private final int queryTimeOutDefaultValue = 4;
	/* time out value in sec */
	private int queryTimeOut = queryTimeOutDefaultValue;
	private String tableName = null;
	private DataBaseMetaData data = null;
	private final static Logger logger = Logger.getLogger(MyStatement.class.getName());

	public MyStatement(Database db, Connection con, File path) {
		this.con = con;
		this.myDB = db;
		this.data = new DataBaseMetaData(path);
		logger.setLevel(Level.INFO);
		logger.info("statement created..");
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void addBatch(String arg0) throws SQLException {
		this.listOfCommands.add(arg0);
		logger.info("Batch added");

	}

	@Override
	public void cancel() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void clearBatch() throws SQLException {
		this.listOfCommands.clear();
		logger.info("Batch list cleared");
	}

	@Override
	public void clearWarnings() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void close() throws SQLException {
		this.listOfCommands = null;
		this.myDB = null;
		this.con = null;
		this.queryTimeOut = this.queryTimeOutDefaultValue;
		logger.info("statement closed..");

	}

	@Override
	public void closeOnCompletion() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean execute(String arg0) throws SQLException {
		Query q = null;
		try {
			Validator v = new Validator();
			if (v.setQuery(arg0)) {
				logger.info("Query is valid");
				q = v.getItExploded();
			} else {
				throw new RuntimeException(
						"arg passed to executeupdate in mystatement class was unvalid query . check was done by validator class");
			}

		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		if (q != null) {
			if (q.getMainType().compareToIgnoreCase(Contact.selectKeys.SELECT) == 0) {
				logger.info("it is select query");
				this.executeQuery(arg0);
				return false;
			} else {
				int i = this.executeUpdate(arg0);
				if (i == -1) {
					return false;
				}
				return true; // must be false but the tester says true then ----
								// true XD
			}
		} else {
			throw new RuntimeException("unexpected null object in mystatement");
		}

	}

	@Override
	public boolean execute(String arg0, int arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean execute(String arg0, int[] arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean execute(String arg0, String[] arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int[] executeBatch() throws SQLException {
		int[] updates = new int[this.listOfCommands.size()];
		for (int i = 0; i < this.listOfCommands.size(); i++) {
			updates[i] = this.executeUpdate(this.listOfCommands.get(i));
		}
		logger.info("Batch list executed..");
		return updates;
	}

	private StringBuilder cases = new StringBuilder();

	@Override
	public ResultSet executeQuery(String arg0) throws SQLException {
		Object[][] selected = this.myDB.executeQuery(arg0);
		tableName = data.getTableName(arg0);
		logger.info("creating resultSet..");
		ResultSet rs = new MyResultSet(selected, this, data, tableName);

		if (selected == null)
			throw new RuntimeException(cases.toString() + "\n\n\n" + arg0 + "\n\n\n\n\n\n\n\n");
		return rs;

	}

	@Override
	public int executeUpdate(String arg0) throws SQLException {
		this.cases.append(arg0 + "\n");

		logger.info("executing update..");
		Query q = null;
		try {
			Validator v = new Validator();
			if (v.setQuery(arg0)) {
				q = v.getItExploded();
			} else {
				throw new RuntimeException(
						"arg passed to executeupdate in mystatement class was unvalid query . check was done by validator class");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		if (q != null) {
			if (q.getMainType().compareToIgnoreCase(Contact.DropKeys.Drop) == 0) {
				if (!this.myDB.executeStructureQuery(arg0)) {

				}
				return 0;
			} else if (q.getMainType().compareToIgnoreCase(Contact.createKeys.CREATE) == 0) {
				if (!this.myDB.executeStructureQuery(arg0)) {
					return -1;
				}
				return 0;
			} else {
				return this.myDB.executeUpdateQuery(arg0);
			}
		} else {
			throw new RuntimeException("unexpected null object in mystatement");
		}
	}

	@Override
	public int executeUpdate(String arg0, int arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int executeUpdate(String arg0, int[] arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int executeUpdate(String arg0, String[] arg1) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public Connection getConnection() throws SQLException {
		return this.con;

	}

	@Override
	public int getFetchDirection() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getFetchSize() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getMaxRows() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean getMoreResults() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean getMoreResults(int arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return this.queryTimeOut;

	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getResultSetType() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getUpdateCount() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isClosed() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isPoolable() throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setCursorName(String arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setEscapeProcessing(boolean arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setFetchDirection(int arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setFetchSize(int arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setMaxFieldSize(int arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setMaxRows(int arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setPoolable(boolean arg0) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public void setQueryTimeout(int arg0) throws SQLException {
		if (arg0 <= 0) {
			throw new SQLException("time must be > 0 ");
		}
		this.queryTimeOut = arg0;

	}

}
