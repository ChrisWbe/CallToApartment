package com.example.calltoapartment.AdaptadorListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.calltoapartment.R;

public class AdapterInfo extends ArrayAdapter {
    String[] nombres;
    String[] apartamentos;
    String[] parqueaderos;
    public AdapterInfo(Context context, String[] nombres, String[] apartamentos, String[] parqueaderos){
        super(context, R.layout.cardviewvis, R.id.tvNApart, apartamentos);
        this.nombres=nombres;
        this.apartamentos=apartamentos;
        this.parqueaderos=parqueaderos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.cardviewvis, parent, false);
        TextView tvNombres = row.findViewById(R.id.tvNombre);
        TextView tvApartment = row.findViewById(R.id.tvNApart);
        TextView tvParq = row.findViewById(R.id.tvParq);

        tvNombres.setText(nombres[position]);
        tvApartment.setText(apartamentos[position]);
        tvParq.setText(parqueaderos[position]);

        return row;
    }
}
