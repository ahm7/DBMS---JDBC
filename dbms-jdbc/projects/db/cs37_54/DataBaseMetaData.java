package eg.edu.alexu.csd.oop.db.cs37_54;

import java.util.LinkedList;

public class DataBaseMetaData {
	LinkedList<TableData> tables = new LinkedList<TableData>();
	public DataBaseMetaData(){
	}

	public void putTable(String name ,  ColumnsAndValues[] columns){
		tables.add(new TableData(name , columns));
	}
	
	public void removeTable(String name){
		for(int i=0;i<tables.size();i++){
			if(tables.get(i).name.equals(name)){
				tables.remove(i);
				return;
			}
		}
	}
	public void updateTable(String name ,  ColumnsAndValues[] columns){
		for(int i=0;i<tables.size();i++){
			if(tables.get(i).name.equals(name)){
				tables.remove(i);
				tables.add(new TableData(name , columns));
				return;
			}
		}
	}
	
	
}
