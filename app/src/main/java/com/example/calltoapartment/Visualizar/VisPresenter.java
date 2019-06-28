package com.example.calltoapartment.Visualizar;

import android.content.Context;

public class VisPresenter implements IVisVMP.presenter {
    public String[] nombre;
    public String[] nApar;
    public String[] parqueadero;
    private IVisVMP.view view;
    private IVisVMP.model model;
    public VisPresenter(IVisVMP.view view){
        this.view=view;
        model = new VisModel(this);
    }

    @Override
    public void datos(Context context) {
       model.obtenerDatos(context);
       nombre = model.getNombre();
       nApar = model.getNApar();
       parqueadero = model.getParque();
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
