package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import eg.edu.alexu.csd.oop.db.cs37_54.MyDatabase;

public class Driver implements java.sql.Driver {
	private final static Logger logger = Logger.getLogger(Driver.class.getName());
	@Override
	public boolean acceptsURL(String url) throws SQLException {
		if (url.equals("jdbc:xmldb://localhost")) {
			return true;
		}
		return false;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		File dir = null;
		if (info.size() == 0) {
			dir = new File(System.getProperty("user.dir"));
			return new MyConnection(new MyDatabase(), dir);
		} else {
			for (Entry e : info.entrySet()) {
				dir = (File) e.getValue();
				dir.mkdirs();
			}
			logger.setLevel(Level.INFO);
			logger.info("path created \n connecting...");
			return new MyConnection(new MyDatabase(), dir);
		}

	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		DriverPropertyInfo[] dpi = new DriverPropertyInfo[info.size()];
		int i = 0;
		for (Entry e : info.entrySet()) {
			dpi[i] = (DriverPropertyInfo) e;
			i++;
		}
		logger.info("property info returned ..");
		return dpi;
	}

	@Override
	public int getMajorVersion() {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getMinorVersion() {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean jdbcCompliant() {
		throw new java.lang.UnsupportedOperationException();

	}

}
