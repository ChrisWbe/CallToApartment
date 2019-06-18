package com.example.calltoapartment.Insertar;

import android.content.Context;

import com.example.calltoapartment.DBNumbers.DataBaseNumbers;

public class InsertModel implements IInsertVMP.model {

    private IInsertVMP.presenter presenter;
    public InsertModel(IInsertVMP.presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void insertarDB(int apartment,String nombre,String number,String parqueadero ,Context context) {
        DataBaseNumbers db = new DataBaseNumbers(context);
        presenter.insertOk(db.insertData(apartment, nombre,number,parqueadero));

    }
}
