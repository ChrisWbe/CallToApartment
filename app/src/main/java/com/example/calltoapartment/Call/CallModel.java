package com.example.calltoapartment.Call;


public class CallModel implements ICallVMP.model {

    private ICallVMP.presenter presenter;

    public CallModel(ICallVMP.presenter presenter){
        this.presenter=presenter;

    }

    @Override
    public void ordenLlamada(int numero) {
        if(numero==123456){
            String dial = "tel:"+numero;
            presenter.iniciarLlamada(dial);
        }
    }
}
