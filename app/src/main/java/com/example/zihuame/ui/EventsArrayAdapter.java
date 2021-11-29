package com.example.zihuame.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zihuame.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventsArrayAdapter extends ArrayAdapter<Event> {
    public EventsArrayAdapter(@NonNull Context context, ArrayList<Event> eventos) {
        super(context,0, eventos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Event event = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_listview, parent, false);
        }
        // Lookup view for data population
        TextView titulo = (TextView) convertView.findViewById(R.id.lv_titulo);
        TextView tipo = (TextView) convertView.findViewById(R.id.lv_tipo);
        TextView zona = (TextView) convertView.findViewById(R.id.lv_maptext);
        TextView fecha = (TextView) convertView.findViewById(R.id.lv_calendartext);

        ImageView iView = (ImageView) convertView.findViewById(R.id.lv_image);
        Picasso.get()
                .load(event.imagen)
                .fit().into(iView);


        // Populate the data into the template view using the data object
        titulo.setText(event.Titulo);
        tipo.setText(event.Tipo);
        zona.setText(event.Zona);
        fecha.setText(event.Fecha);
        // Return the completed view to render on screen
        return convertView;
    }
}
