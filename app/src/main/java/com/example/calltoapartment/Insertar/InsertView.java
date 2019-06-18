package com.example.calltoapartment.Insertar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
                presenter.obtenerDatos();
            }
        });
    }

    public Context getMyContext(){
        return this;
    }

    @Override
    public void datosInsertados(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    public String getIdApartment(){
        return etIdApartment.getEditText().getText().toString();
    }

    @Override
    public String getNombre() {
        return etNombre.getEditText().toString();
    }

    public String getNumber(){
        return etNumber.getEditText().getText().toString();
    }

    @Override
    public String getParqueadero() {
        return etParqueadero.getEditText().toString();
    }

}
