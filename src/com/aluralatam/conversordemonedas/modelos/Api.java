package com.aluralatam.conversordemonedas.modelos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Api {

    private static final String API_KEY = "ab374557e3721014899b47d2";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasa(String base, String destino) {
        try {
            URL url = new URL(BASE_URL + base);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {
                respuesta.append(linea);
            }
            lector.close();

            JSONObject json = new JSONObject(respuesta.toString());
            return json.getJSONObject("conversion_rates").getDouble(destino);

        } catch (Exception e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
            return -1;
        }
    }
}
