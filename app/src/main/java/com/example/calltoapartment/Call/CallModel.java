package com.example.calltoapartment.Call;


import android.content.Context;
import android.widget.Toast;

import com.example.calltoapartment.DBNumbers.DataBaseNumbers;

public class CallModel implements ICallVMP.model {

    private ICallVMP.presenter presenter;

    public CallModel(ICallVMP.presenter presenter){
        this.presenter=presenter;

    }

    @Override
    public void ordenLlamada(String numero, Context context) {
        DataBaseNumbers db = new DataBaseNumbers(context);
        String dial = "tel:"+db.getNumberDate(numero);
        presenter.iniciarLlamada(dial);

    }
}
