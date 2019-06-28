package com.example.calltoapartment.Call;

public class CallPresenter implements ICallVMP.presenter{

    private ICallVMP.view view;
    private ICallVMP.model model;

    public CallPresenter(ICallVMP.view view){
        this.view=view;
        model= new CallModel(this);
    }


    @Override
    public void clickEnterNumber() {
        model.ordenLlamada(view.getNumber(), view.myContext());
    }

    @Override
    public void iniciarLlamada(String numero) {
        view.llamada(numero);
    }
}
