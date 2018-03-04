package eg.edu.alexu.csd.oop.db.cs37_54;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by M.Sharaf on 26/11/2017.
 */
public class FinalTest {
    public static void main(String[] args) throws SQLException {

//        /* all cases of select */
        MyDatabase db = new MyDatabase();
 //       database.createDatabase("yom", false);
        
        
        
        db.executeStructureQuery("CREATE DATABASE testdb_select;");
		db.executeStructureQuery(
				"CREATE TABLE table_name13(column_name1 varchar, column_name2 int, column_name3 varchar)");
		int t =db.executeUpdateQuery(
				"INSERT INTO table_name13 VALUES ('tgt', 'tgtg', 20)");
		System.out.println(t);
		
		t=db.executeUpdateQuery(
			
				"INSERT INTO table_name13(column_NAME1, column_name2, COLUMN_name3) VALUES ('value1', 4, 'value3')");
		System.out.println(t);
		db.executeUpdateQuery(
				"INSERT INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5)");
		db.executeUpdateQuery(
				"INSERT INTO table_name13(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value5', 'value6', 6)");
        
//
//        int d = 0;
//        database.executeStructureQuery(
//                " CREATE TABLE table_name1(column_name1 varchar , column_name2 int, column_name3 varchar)");
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value7', 4)");
//
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value7', 4)");
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value7', 5)");
//
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value3', 'value7', 5)");
//
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value3', 'value5', 6)");
//        d = database.executeUpdateQuery(
//                " INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value4', 'value5', 6)");
//
//
//        Object[][] f;
//        //f = database.executeQuery("SELECT coLUmn_NAME1, coLUmn_NAME2 FROM table_name1;"); // TEST 1
//        //f = database.executeQuery("SELECT * FROM table_name1; "); // TEST 2
//        f = database.executeQuery("SELECT coLUmn_NAME1, coLUmn_NAME2 FROM table_name1 WHERE coLUmn_NAME2<6; "); // TEST 3
//        //f = database.executeQuery("SELECT * FROM table_name1 WHERE coLUmn_NAME2=6; "); // TEST 4

        MyDatabase database = new MyDatabase();
        database.createDatabase("yom", false);
        //System.out.println(database.executeUpdateQuery("UPDATE table_name4 SET column_name1=='1111111111', COLUMN_NAME2=2222222, column_name3='333333333'"));
        System.out.println(database.executeStructureQuery(" CREATE TABLE table_name1(column_name1 varchar , column_name2 int, column_name3 varchar)"));
        database.executeUpdateQuery(" INSERT INTO table_name1(, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)");
        database.executeUpdateQuery("INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)");
//        Object[][] f= database.executeQuery(" SELECT  FROM table_name1 WHERE coluMN_NAME2 <4");
//        System.out.println(f.length);
//        for (int i = 0; i < f.length; i++) {
//            for (int j = 0; j < f[0].length; j++) {
//                System.out.printf(f[i][j] + "\t");
//            }
//            System.out.println();
//        }

			/* end of select */

    }
}