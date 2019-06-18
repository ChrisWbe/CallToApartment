package com.example.calltoapartment.Call;

public interface ICallVMP {
    interface  model{
        void ordenLlamada(int numero);

    }

    interface presenter{
        void clickEnterNumber();
        void iniciarLlamada(String numero);

    }

    interface view{
        String getNumber();
        void llamada(String numero);

    }
}
