package com.example.calltoapartment.DBNumbers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseNumbers extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBNumbers.db";
    public static final String TABLE_NAME = "numbers_table";

    public static final String COL_1="ID_APARTMENT";
    public static final String COL_2="NOMBRE";
    public static final String COL_3="NUMBER";
    public static final String COL_4="PARQUEADERO";

    private SQLiteDatabase db = this.getWritableDatabase();

    public DataBaseNumbers(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME +"(ID_APARTMENT INTEGER PRIMARY KEY,NOMBRE TEXT,NUMBER TEXT,PARQUEADERO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertData(int id_apartment, String nombre,String number, String parqueadero){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id_apartment);
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3, number);
        contentValues.put(COL_4,parqueadero);
        long result = db.insert(TABLE_NAME,null, contentValues);
        return !(result == -1);
    }

    public Cursor getAllData(){
        return db.rawQuery("Select * from "+ TABLE_NAME, null);
    }

    public boolean updateData(String id_apartment, String number){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id_apartment);
        contentValues.put(COL_2, number);
        int result = db.update(TABLE_NAME,contentValues,"ID=?",new String[]{id_apartment});
        return (result>0);
    }

    public Integer deleteData(String id_apartment){
        return db.delete(TABLE_NAME,"ID=?",new String[]{id_apartment});
    }
}
