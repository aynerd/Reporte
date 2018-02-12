package com.sccreporte.reporte.data;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by simpson on 2/9/2018.
 */

public class Report implements Comparable<Report>{
    public JSONObject reportJSON;
    public int avivamientos;
    public int ayunos;
    public int biblias;
    public int cultos;
    public int devocionales;
    public int enfermos;
    public int estudios_asistidos;
    public int estudios_establecidos;
    public int estudios_realizados;
    public Date fecha;
    public int hogares;
    public int horas_ayunos;
    public int id;
    public int mensajeros;
    public int mensajes;
    public String otros;
    public int porciones;
    public int sanidades;
    public int user_id;
    public int visitas;

    public Report(JSONObject report){
        reportJSON = report;
        String tempFecha = "04/04/1988";
        SimpleDateFormat formatter = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss zzz", Locale.getDefault());
        try {
            avivamientos = report.getInt("avivamientos");
            ayunos = report.getInt("ayunos");
            biblias = report.getInt("biblias");
            cultos = report.getInt("cultos");
            devocionales = report.getInt("devocionales");
            enfermos = report.getInt("enfermos");
            estudios_asistidos = report.getInt("estudios_asistidos");
            estudios_establecidos = report.getInt("estudios_establecidos");
            estudios_realizados = report.getInt("estudios_realizados");
            tempFecha = report.getString("fecha");
            hogares = report.getInt("hogares");
            horas_ayunos = report.getInt("horas_ayunos");
            id = report.getInt("id");
            mensajeros = report.getInt("mensajeros");
            mensajes = report.getInt("mensajes");
            otros = report.getString("otros");
            porciones = report.getInt("porciones");
            sanidades = report.getInt("sanidades");
            user_id = report.getInt("user_id");
            visitas = report.getInt("visitas");

        }catch (JSONException e){
            e.printStackTrace();
        }

        try {
            fecha = formatter.parse(tempFecha);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(@NonNull Report anotherReport) {
        return fecha.compareTo(anotherReport.fecha);
    }
}