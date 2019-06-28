package com.example.calltoapartment.Visualizar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import com.example.calltoapartment.AdaptadorListView.AdapterInfo;
import com.example.calltoapartment.R;

public class VisView extends AppCompatActivity implements IVisVMP.view{
    private ListView listView;
    private IVisVMP.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_view);

        listView = findViewById(R.id.lvVisualizar);
        presenter = new VisPresenter(this);
        presenter.datos(this);
        AdapterInfo adapter = new AdapterInfo(this, presenter.getNombre(), presenter.getNApar(), presenter.getParque());
        listView.setAdapter(adapter);
    }
}
