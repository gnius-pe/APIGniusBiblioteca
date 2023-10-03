package com.biblioteca.biblioteca.utilidades;

import com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS.Estudiante;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConeccionAPIXML {

    public Estudiante obtenerAlumno(String codigo){
        String apiUrl = "https://itsm2023.rj.r.appspot.com/api/usuario/?codigo=" + codigo;
        ObjectMapper xmlObjectMapper = new XmlMapper();
        try {
            String xmlData = obtenerEstudianteXml(apiUrl);
            System.out.println(xmlData);
            Estudiante alumnoUnas = xmlObjectMapper.readValue(xmlData,Estudiante.class);
            return alumnoUnas;
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

    public boolean existEstudianteUnas(String codigo){
        return obtenerAlumno(codigo) != null ? true : false;
    }

    private String obtenerEstudianteXml(String apiUrl) throws IOException {
        HttpURLConnection conexion = null;
        BufferedReader lector = null;
        StringBuilder respuesta = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = lector.readLine()) != null) {
                respuesta.append(linea);
            }
        } finally {
            // Cerrar la conexión y el lector cuando se complete
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                conexion.disconnect();
            }
        }
        return respuesta.toString();
    }

}
