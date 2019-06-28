package com.example.calltoapartment.Call;

import android.content.Context;

public interface ICallVMP {
    interface  model{
        void ordenLlamada(String numero, Context context);

    }

    interface presenter{
        void clickEnterNumber();
        void iniciarLlamada(String numero);

    }

    interface view{
        String getNumber();
        void llamada(String numero);
        Context myContext();

    }
}
