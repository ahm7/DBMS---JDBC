package eg.edu.alexu.csd.oop.jdbc.cs37;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import eg.edu.alexu.csd.oop.db.cs37_54.ColumnsAndValues;
import eg.edu.alexu.csd.oop.db.cs37_54.Validator;
import eg.edu.alexu.csd.oop.db.cs37_54.ValidatorI;
import eg.edu.alexu.csd.oop.db.cs37_54.queries.Query;
import eg.edu.alexu.csd.oop.db.cs37_54.queries.SelectQuery;

public class DataBaseMetaData {
	File dbPath = null;
	LinkedList<TableData> tables = new LinkedList<TableData>();

	public DataBaseMetaData(File path) {
		this.dbPath = path;
		getData();
	}

	private void getData() {
		// list file in the database directory
		File[] listOfFiles = dbPath.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder;
				InputStream inputStream;
				Reader reader = null;
				try {
					inputStream = new FileInputStream(listOfFiles[i]);
					try {
						reader = new InputStreamReader(inputStream, "ISO-8859-1");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					try {
						throw new SQLException();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				InputSource is = new InputSource(reader);
				is.setEncoding("ISO-8859-1");
				try {
					builder = factory.newDocumentBuilder();
					Document doc = builder.parse(is);
					Node t = doc.getFirstChild();
					Element table = (Element) t;
					String tableName = table.getAttribute("name");
					LinkedList<ColumnsAndValues> data = new LinkedList<>();
					NodeList columns = t.getChildNodes();
					for (int j = 0; j < columns.getLength(); j++) {
						Element column = (Element) columns.item(j);
						String columnName = column.getTagName();
						String columnType = column.getAttribute("type");
						ColumnsAndValues c = new ColumnsAndValues();
						c.setColumn(columnName);
						c.setValue(columnType);
						data.add(c);
					}
					tables.add(new TableData(tableName, data));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public LinkedList<TableData> getTablesList() {
		return tables;
	}

	public String getTableName(String query) {
		try {
			ValidatorI v = new Validator();
			if (v.setQuery(query)) {
				Query q = v.getItExploded();
				if (q.getMainType().compareToIgnoreCase("select") == 0) {
					SelectQuery sq = (SelectQuery)q;
					return sq.getSelectionTableName();
				}else{
					throw new RuntimeException("not select query type");
				}
			} else {
				throw new RuntimeException("invalid query");
			}

		} catch (ParserConfigurationException | SQLException e) {
			throw new RuntimeException("can't initiate validator") ;
		}
	}
	
	
	public TableData getTableByName (String tableName){
		for(TableData table : tables){
			if(table.name.equalsIgnoreCase(tableName)){
				return table;
			}
		}
		return null;
	}

}
