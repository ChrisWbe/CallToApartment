package com.example.calltoapartment.DBNumbers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseNumbers extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBNumbers.db";
    public static final String TABLE_NAME = "numbers_table";

    public static final String COL_1="ID_APARTMENT";
    public static final String COL_2="NOMBRE";
    public static final String COL_3="NUMBER";
    public static final String COL_4="PARQUEADERO";
    Context context;

    private SQLiteDatabase db = this.getWritableDatabase();

    public DataBaseNumbers(Context context){

        super(context, DATABASE_NAME, null, 1);
        this.context = context;
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
        Toast.makeText(this.context, nombre, Toast.LENGTH_LONG).show();
        long result = db.insert(TABLE_NAME,null, contentValues);
        return !(result == -1);
    }

    public Cursor getAllData(){
        return db.rawQuery("Select * from "+ TABLE_NAME, null);
    }

    public String getNumberDate(String numero){
        Cursor cursor = db.rawQuery("Select "+COL_3+" from "+TABLE_NAME+" WHERE "+COL_1+"='"+numero+"'", null);
        cursor.moveToNext();
        return cursor.getString(0);
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
