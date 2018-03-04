package eg.edu.alexu.csd.oop.db.cs37_54;

import java.util.ArrayList;
import java.util.HashMap;

public class QueryInfo {
    private String mainType;
    private String secType;

    public void setmainType(String x) {
        this.mainType = x;
    }

    public String getmainType() {
        return this.mainType;
    }

    public void setsecType(String x) {
        this.secType = x;
    }

    public String getsecType() {
        return this.secType;
    }

    //----------------------------------------------------------where
    private String whereCondition;

    public void setWhere(String x) {
        this.whereCondition = x;
    }

    public String getWhere() {
        return this.whereCondition;
    }

    //--------------------------------------------------------------del
    private String deletedFrom;
    private boolean deleteAll;

    public void setDelAll(boolean x) {
        this.deleteAll = x;
    }

    public boolean getDelAll() {
        return this.deleteAll;
    }

    public void setDelFrom(String s) {
        this.deletedFrom = s;
    }

    public String getDelFrom() {
        return this.deletedFrom;
    }

    //-------------------------------------------------------------drop db and table
    private String DroppedName;    //for both db and table

    public void setDroppedName(String string) {
        this.DroppedName = string;
    }

    public String getDroppedName() {
        return this.DroppedName;
    }

    //--------------------------------------------------------------CREATE DB ELEMS
    private String creationDBName;

    public void setCreationDBName(String table) {
        this.creationDBName = table;
    }

    public String getCreationDBName() {
        return this.creationDBName;
    }

    //-------------------------------------------------------------create elems
    private HashMap<String, String> createMap;
    private String creationTableName;

    public void setCreateMap(HashMap<String, String> m) {
        this.createMap = m;
    }

    public HashMap<String, String> getCreateMap() {
        return this.createMap;
    }

    public void setCreationTableName(String table) {
        this.creationTableName = table;
    }

    public String getCreationTableName() {
        return this.creationTableName;
    }

    //-------------------------------------------------------------- inser elements
    private String insertionTableName;
    private HashMap<String, String> insertionMap;

    public void setInsertTableName(String t) {
        this.insertionTableName = t;
    }

    public String getInsertTableName() {
        return this.insertionTableName;
    }

    public HashMap<String, String> getInsertMap() {
        return this.insertionMap;
    }

    //------------------------------------------------------------------- update elements
    private String updateTableName;
    private HashMap<String, String> UpdateMap;

    public void setUpdateTableName(String t) {
        this.updateTableName = t;
    }

    public String getetUpdateTableName() {
        return this.updateTableName;
    }

    public HashMap<String, String> getUpdateMap() {
        return this.UpdateMap;
    }

    //----------------------------------------------------------------------select elements

    private String SelectionTableName;
    private ArrayList<String> selectionArray;

    public void setSelectionTableName(String t) {
        this.SelectionTableName = t;
    }

    public ArrayList<String> getselectionArray() {
        return this.selectionArray;
    }

    public String getSelectionTableName() {
        return this.SelectionTableName;
    }


    //------------------------------------------------------------------------
    public QueryInfo() {
        this.deletedFrom = null;
        this.DroppedName = null;
        this.mainType = null;
        this.creationTableName = null;
        this.insertionTableName = null;
        this.createMap = new HashMap<String, String>();
        this.insertionMap = new HashMap<String, String>();
        this.UpdateMap = new HashMap<String, String>();
        this.selectionArray = new ArrayList<String>();
        this.SelectionTableName = null;
        this.updateTableName = null;
    }

}
