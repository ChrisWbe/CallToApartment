package com.example.calltoapartment.Visualizar;

import android.content.Context;
import android.database.Cursor;
import com.example.calltoapartment.DBNumbers.DataBaseNumbers;

public class VisModel implements IVisVMP.model {
    public String[] nombre;
    public String[] nApar;
    public String[] parqueadero;
    private IVisVMP.presenter presenter;

    public VisModel(IVisVMP.presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void obtenerDatos(Context context) {
        DataBaseNumbers db = new DataBaseNumbers(context);
        Cursor cursor = db.getAllData();
        nombre = new String[cursor.getCount()];
        nApar = new String[cursor.getCount()];
        parqueadero = new String[cursor.getCount()];

        if(cursor!=null && cursor.getCount()>0){
            for(int i=0; cursor.moveToNext(); i++){
                nombre[i] = cursor.getString(1);
                nApar[i] = cursor.getString(2);
                parqueadero[i] = cursor.getString(3);
            }
        }
    }

    @Override
    public String[] getNombre() {
        return nombre;
    }

    @Override
    public String[] getNApar() {
        return nApar;
    }

    @Override
    public String[] getParque() {
        return parqueadero;
    }
}
