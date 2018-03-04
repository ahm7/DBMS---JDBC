package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.sql.SQLException;

import eg.edu.alexu.csd.oop.db.cs37_54.ColumnsAndValues;

public class MyResultSetMetaData implements java.sql.ResultSetMetaData {

	private MyResultSet resultSet = null;
	private String tableName = null;
	private DataBaseMetaData data = null;
	private Object[][] result = null;

	public MyResultSetMetaData(Object[][] rs, String tableName, DataBaseMetaData d) {
		this.result = rs;
		this.tableName = tableName;
		this.data = d;
	}

	@Override
	public int getColumnCount() throws SQLException {
		if (result.length > 0) {
			return result[0].length;
		} else {
			return 0;
		}
	}

	@Override
	// it behaves like getColumnName because we won't change the display name
	public String getColumnLabel(int column) throws SQLException {
		TableData table = data.getTableByName(tableName);
		ColumnsAndValues c = table.columns.get(column-1);
		return c.getColumn();
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		TableData table = data.getTableByName(tableName);
		ColumnsAndValues c = table.columns.get(column-1);
		return c.getColumn();
	}

	@Override
	public int getColumnType(int column) throws SQLException {
		TableData table = data.getTableByName(tableName);
		ColumnsAndValues c = table.columns.get(column-1);
		String type = c.getValue();
		if (type.equalsIgnoreCase("int")) {
			return java.sql.Types.INTEGER;
		} else if (type.equalsIgnoreCase("varchar")) {
			return java.sql.Types.VARCHAR;
		} else {
			return 0;
		}
	}

	// i couldn't use the parameter to indicate the table
	@Override
	public String getTableName(int column) throws SQLException {
		return tableName;
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
	public String getCatalogName(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public String getColumnClassName(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getPrecision(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int getScale(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isCurrency(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public int isNullable(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isSearchable(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isSigned(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public boolean isWritable(int column) throws SQLException {
		throw new java.lang.UnsupportedOperationException();

	}

}
