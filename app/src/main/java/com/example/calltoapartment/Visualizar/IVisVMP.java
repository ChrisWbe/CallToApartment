package com.example.calltoapartment.Visualizar;

import android.content.Context;

public interface IVisVMP {

    interface view{

    }

    interface presenter{
        void datos(Context context);
        String[] getNombre();
        String[] getNApar();
        String[] getParque();
    }

    interface model{
        void obtenerDatos(Context context);
        String[] getNombre();
        String[] getNApar();
        String[] getParque();

    }
}
