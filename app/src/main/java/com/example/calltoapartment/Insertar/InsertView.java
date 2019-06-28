package com.example.calltoapartment.Insertar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.calltoapartment.R;
import com.google.android.material.textfield.TextInputLayout;

public class InsertView extends AppCompatActivity implements IInsertVMP.view{
    private Button btnInsertar;
    private TextInputLayout etIdApartment;
    private TextInputLayout etNumber;
    private TextInputLayout etNombre;
    private TextInputLayout etParqueadero;
    private RadioGroup rbTypeTel;

    private IInsertVMP.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_view);

        presenter = new InsertPresenter(this);

        btnInsertar = findViewById(R.id.btnInsertar);
        etIdApartment = findViewById(R.id.etIdApartment);
        etNumber = findViewById(R.id.etNumber);
        etNombre=findViewById(R.id.etNombre);
        etParqueadero=findViewById(R.id.etParqueadero);
        rbTypeTel=findViewById(R.id.rbTypeTel);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visError()){
                    etIdApartment.setError(getString(R.string.campoEmpty));
                    etNombre.setError(getString(R.string.campoEmpty));
                    etNumber.setError(getString(R.string.campoEmpty));
                    etParqueadero.setError(getString(R.string.campoEmpty));
                }else{
                    presenter.obtenerDatos();
                }

            }
        });
    }

    public boolean visError(){
        return (TextUtils.isEmpty(etIdApartment.getEditText().getText().toString().trim()) || TextUtils.isEmpty(etNombre.getEditText().getText().toString().trim()) || TextUtils.isEmpty(etNumber.getEditText().getText().toString().trim()) || TextUtils.isEmpty(etParqueadero.getEditText().getText().toString().trim())) ? true:false;
    }

    public Context getMyContext(){
        return this;
    }

    @Override
    public void datosInsertados(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    public String getIdApartment(){
        return etIdApartment.getEditText().getText().toString().trim();
    }

    @Override
    public String getNombre() {
        return etNombre.getEditText().getText().toString().trim();
    }

    public String getNumber(){
        return etNumber.getEditText().getText().toString().trim();
    }

    @Override
    public String getParqueadero() {
        return etParqueadero.getEditText().getText().toString().trim();
    }

}
