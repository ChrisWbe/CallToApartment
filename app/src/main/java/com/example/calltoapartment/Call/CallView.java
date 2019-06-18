package com.example.calltoapartment.Call;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.example.calltoapartment.Actualizar.ActView;
import com.example.calltoapartment.Borrar.BorView;
import com.example.calltoapartment.Insertar.InsertView;
import com.example.calltoapartment.R;
import com.example.calltoapartment.Visualizar.VisView;

public class CallView extends AppCompatActivity implements ICallVMP.view{

    private EditText etNumber;
    private ICallVMP.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_view);

        presenter = new CallPresenter(this);

        EventoTeclado eventoTeclado = new EventoTeclado();
        etNumber = findViewById(R.id.etNumber);
        etNumber.setOnEditorActionListener(eventoTeclado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.insertar:
                return iniActividadSQL(InsertView.class);
            case R.id.actualizar:
                return iniActividadSQL(ActView.class);
            case R.id.visualizar:
                return iniActividadSQL(VisView.class);
            case R.id.borrar:
                return iniActividadSQL(BorView.class);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean iniActividadSQL(Class context){
        Intent i = new Intent(this, context);
        startActivity(i);
        return true;
    }

    @Override
    public String getNumber() {
        return etNumber.getText().toString();
    }

    @Override
    public void llamada(String numero) {
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(numero)));
    }

    class EventoTeclado implements EditText.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId==EditorInfo.IME_ACTION_DONE){
                presenter.clickEnterNumber();
            }
            return false;
        }
    }
}
