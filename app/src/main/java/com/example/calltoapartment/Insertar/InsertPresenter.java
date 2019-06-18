package com.example.calltoapartment.Insertar;

import android.content.Context;

public class InsertPresenter implements IInsertVMP.presenter{
    private IInsertVMP.view view;
    private IInsertVMP.model model;

    public InsertPresenter(IInsertVMP.view view){
        this.view = view;
        model = new InsertModel(this);
    }


    @Override
    public void obtenerDatos() {
        int apartment = Integer.parseInt(view.getIdApartment());
        String number = view.getNumber();
        String nombre = view.getNombre();
        String parqueadero = view.getParqueadero();
        Context context = view.getMyContext();
        model.insertarDB(apartment, nombre,number, parqueadero,context);
    }

    @Override
    public void insertOk(boolean ok) {
        String mensaje = ok ? "Datos almacenados" : "Error";
        view.datosInsertados(mensaje);
    }

}
