package com.example.tarea24;

public class Config {
    public static final String signature_table = "signatures";


    public static final String id = "id";
    public static final String image = "image";
    public static final String description = "description";


    public static final String CreateTableFirmas= "CREATE TABLE signatures" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "image BLOB, " +
            "description TEXT)";

    public static final String DropTableFirmas= "DROP TABLE IF EXISTS signatures";
    public static final String NameDataBase = "tarea2_3_db";
}
