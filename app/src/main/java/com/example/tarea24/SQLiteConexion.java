package com.example.tarea24;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteConexion extends SQLiteOpenHelper {
    public SQLiteConexion(Context context, String database, SQLiteDatabase.CursorFactory factory, int version){
        super(context, database, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Config.CreateTableFirmas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Config.DropTableFirmas);
        onCreate(db);
    }
}
