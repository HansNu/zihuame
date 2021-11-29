package com.example.zihuame.ui;

import java.io.Serializable;

public class Event implements Serializable {
    public String Titulo = "", Tipo = "", Fecha = "", Zona = "", imagen = "https://conceptodefinicion.de/wp-content/uploads/2016/12/Evento.jpg";
    public float lat = 0, lng = 0;

    public Event(String Titulo,String Tipo,String Fecha,String Zona){
        this.Titulo = Titulo;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
        this.Zona = Zona;
    }

    @Override
    public String toString() {
        return Titulo;
    }
}
