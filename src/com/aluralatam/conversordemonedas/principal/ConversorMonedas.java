package com.aluralatam.conversordemonedas.principal;

import java.util.Scanner;
import com.aluralatam.conversordemonedas.modelos.Api;


public class ConversorMonedas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("## Sea bienvenido/a al Conversor de monedas =]");
        do {
            System.out.println("\n************************************************************");
            System.out.println("Por favor ingrese el número que desea realizar:");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir ");
            System.out.println("************************************************************");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                String base = "", destino = "";

                switch (opcion) {
                    case 1: base = "USD"; destino = "ARS"; break;
                    case 2: base = "ARS"; destino = "USD"; break;
                    case 3: base = "USD"; destino = "BRL"; break;
                    case 4: base = "BRL"; destino = "USD"; break;
                    case 5: base = "USD"; destino = "COP"; break;
                    case 6: base = "COP"; destino = "USD"; break;
                }


                double tasa = Api.obtenerTasa(base, destino);

                if (tasa != -1) {
                    double resultado = cantidad * tasa;
                    System.out.printf("Resultado: %.2f %s = %.2f %s\n", cantidad, base, resultado, destino);
                } else {
                    System.out.println("No se pudo obtener la tasa de cambio.");
                }
            } else if (opcion != 7) {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        System.out.println("Gracias por usar el conversor de monedas. \n" + "Finalizando...");
        scanner.close();
    }
}
