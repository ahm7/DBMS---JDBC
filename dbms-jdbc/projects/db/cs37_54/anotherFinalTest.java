package eg.edu.alexu.csd.oop.db.cs37_54;

//import static org.junit.Assert.fail;

import java.sql.SQLException;

//import org.junit.Assert;

public class anotherFinalTest {

	public static void main(String[] args) {
		MyDatabase db = new MyDatabase();
		try {
			db.createDatabase("TestDB", true);
			int count5 = db.executeUpdateQuery("UPDATE table_name1 SET column_name1='11111111', COLUMN_NAME2=10, column_name3='333333333' WHERE coLUmn_NAME2=5");

			db.executeStructureQuery("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)");
			
			int count1 = db.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)");
			//Assert.assertNotEquals("Insert returned zero rows", 0, count1);
			int count2 = db.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 5)");
			//Assert.assertNotEquals("Insert returned zero rows", 0, count2);
			int count3 = db.executeUpdateQuery("INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 6)");
			//Assert.assertNotEquals("Insert returned zero rows", 0, count3);
			
			int count4 = db.executeUpdateQuery("DELETE From table_name1  WHERE coLUmn_NAME2=4");
			//Assert.assertEquals("Delete returned wrong number", 1, count4);
			
			Object[][] result = db.executeQuery("SELECT * FROM table_name1 WHERE coluMN_NAME2 < 6");
			//Assert.assertNotNull("Null result returned", result);
			//Assert.assertEquals("Wrong number of rows", 1, result.length);
			//Assert.assertEquals("Wrong number of columns", 3, result[0].length);
			
			 count5 = db.executeUpdateQuery("UPDATE table_name1 SET column_name1='11111111', COLUMN_NAME2=10, column_name3='333333333' WHERE coLUmn_NAME2=5");
		//	Assert.assertEquals("Update returned wrong number", 1, count5);
			
			Object[][] result2 = db.executeQuery("SELECT * FROM table_name1 WHERE coluMN_NAME2 > 4");
			System.out.println(result2.length);
	      for (int i = 0; i < result2.length; i++) {
	            for (int j = 0; j < result2[0].length; j++) {
	                System.out.printf(result2[i][j] + "\t");
           }
	            System.out.println();
	        }
			//Assert.assertNotNull("Null result returned", result2);
			//Assert.assertEquals("Wrong number of rows", 2, result2.length);
			//Assert.assertEquals("Wrong number of columns", 3, result2[0].length);
			Object column_2_object = result2[0][1];
			//if (column_2_object instanceof String){
				//fail("This should be 'Integer', but found 'String'!");
			//else if (column_2_object instanceof Integer) {
				int column_2 = (Integer) column_2_object;
			//	Assert.assertEquals("Select did't return the updated record!", 10, column_2);
			System.out.println(count1 +" "+count2+" "+count3 +" "+count4+" "+count5+" "+column_2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
/*
		try {
			database.createDatabase("sample/78913.48010157843/TestDB_Select", false);

			database.executeStructureQuery(
					" CREATE TABLE table_name13(column_name1 varchar, column_name2 int, column_name3 varchar)");
			
			database.executeUpdateQuery(
					" INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)");
			database.executeUpdateQuery(
					" INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value7', 5)");
			database.executeUpdateQuery(
					" INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value4', 8)");
			database.executeUpdateQuery("DELETE  FROM table_name13 WHERE column_name2 = 4");
			database.executeUpdateQuery("DELETE  FROM table_name13 WHERE column_name2 = 5");
			database.executeUpdateQuery("DELETE  FROM table_name13 WHERE column_name2 = 8");

			

			System.out.println(database.executeUpdateQuery(
					"UP DATE table_name1 SET column_name1='1111111111', COLUMN_NAME2=2222222, column_name3='333333333'"));
			

			//database.createDatabase("sample", true);
			// database.executeStructureQuery("DROP DATABASE sample");

			//database.executeStructureQuery(
				//	" CREATE TABLE table_name1(column_name1 varchar , column_name2 int, column_name3 varchar)");

			//database.executeStructureQuery(
				//	" CREATE TABLE table_name1(column_name1 int , column_name2 int, column_name3 int)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * database.createDatabase("sample/78913.48010157843/TestDB_Select",
		 * true); database.
		 * executeStructureQuery("CREATE DATABASE sample/78913.48010157843/testdb_select;"
		 * ); database.
		 * executeStructureQuery("DROP DATABASE sample/78913.48010157843/testdb_select "
		 * ); database.
		 * executeStructureQuery(" CREATE TABLE table_name13(column_name1 varchar, column_name2 int, column_name3 varchar)"
		 * ); System.out.println(database.
		 * executeUpdateQuery(" IN SERT    INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"
		 * )); database.
		 * executeUpdateQuery(" INSERT   INTO table_name13(column_NAME1, column_name2, COLUMN_name3) VALUES ('value1', 4, 'value3')"
		 * ); database.
		 * executeUpdateQuery(" INSERT   INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5)"
		 * ); database.
		 * executeUpdateQuery(" INSERT INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value5', 'value6', 6)"
		 * ); Object[][]f= database.
		 * executeQuery("SELECT column_name1 FROM table_name13 WHERE coluMN_NAME2 < 5"
		 * ); System.out.println(f.length); for (int i = 0; i < f.length; i++) {
		 * for (int j = 0; j < f[0].length; j++) { System.out.printf(f[i][j] +
		 * "\t"); } System.out.println(); }
		 * 
		 * 
		 * database.createDatabase("sample/78913.48010157843/TestDB_Select",
		 * true); database.
		 * executeStructureQuery("CREATE DATABASE sample/78913.48010157843/testdb_select;"
		 * ); database.
		 * executeStructureQuery(" CREATE TABLE table_name13(column_name1 varchar, column_name2 int, column_name3 varchar)"
		 * ); database.
		 * executeUpdateQuery(" INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"
		 * ); database.
		 * executeUpdateQuery(" INSERT INTO table_name13(column_NAME1, column_name2, COLUMN_name3) VALUES ('value1', 4, 'value3')"
		 * ); database.
		 * executeUpdateQuery(" INSERT INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5)"
		 * ); database.
		 * executeUpdateQuery(" INSERT INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value5', 'value6', 6)"
		 * ); f= database.
		 * executeQuery("SELECT column_name1 FROM table_name13 WHERE coluMN_NAME2 < 5"
		 * ); System.out.println(f.length); for (int i = 0; i < f.length; i++) {
		 * for (int j = 0; j < f[0].length; j++) { System.out.printf(f[i][j] +
		 * "\t"); } System.out.println(); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * //
		 * 
		 * /*
		 * 
		 * sample/78913.48010157843/TestDB_Select true CREATE DATABASE
		 * sample/78913.48010157843/testdb_select; CREATE TABLE
		 * table_name13(column_name1 varchar, column_name2 int, column_name3
		 * varchar) INSERT INTO table_name13(column_NAME1, COLUMN_name3,
		 * column_name2) VALUES ('value1', 'value3', 4) INSERT INTO
		 * table_name13(column_NAME1, column_name2, COLUMN_name3) VALUES
		 * ('value1', 4, 'value3') INSERT INTO table_name13(column_name1,
		 * COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5) INSERT
		 * INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES
		 * ('value5', 'value6', 6) SELECT column_name1 FROM table_name13 WHERE
		 * coluMN_NAME2 < 5 sample/78913.48010157843/TestDB_Select true CREATE
		 * DATABASE sample/78913.48010157843/testdb_select; CREATE TABLE
		 * table_name13(column_name1 varchar, column_name2 int, column_name3
		 * varchar) INSERT INTO table_name13(column_NAME1, COLUMN_name3,
		 * column_name2) VALUES ('value1', 'value3', 4) INSERT INTO
		 * table_name13(column_NAME1, column_name2, COLUMN_name3) VALUES
		 * ('value1', 4, 'value3') INSERT INTO table_name13(column_name1,
		 * COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5) INSERT
		 * INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES
		 * ('value5', 'value6', 6) SELECT column_name1 FROM table_name13 WHERE
		 * coluMN_NAME2 < 5
		 * 
		 */

	

}}