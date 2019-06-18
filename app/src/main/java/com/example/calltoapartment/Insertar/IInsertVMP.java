package com.example.calltoapartment.Insertar;

import android.content.Context;

public interface IInsertVMP {

    interface view{
        String getIdApartment();
        String getNombre();
        String getNumber();
        String getParqueadero();
        Context getMyContext();
        void datosInsertados(String mensaje);
    }

    interface presenter{
        void obtenerDatos();
        void insertOk(boolean ok);
    }

    interface model{
        void insertarDB(int apartment,String nombre ,String number,String parqueadero ,Context context);
    }
}
