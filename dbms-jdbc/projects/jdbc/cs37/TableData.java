package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.db.cs37_54.ColumnsAndValues;

public class TableData {
	public String name;
	public LinkedList<ColumnsAndValues> columns;

	public TableData(String name, LinkedList<ColumnsAndValues> columns) {
		this.name = name;
		this.columns = columns;
	}
	
}
