package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ColeccionVinilo coleccion;
    private Scanner scanner;

    public Menu() {
        this.coleccion = new ColeccionVinilo();
        this.scanner = new Scanner(System.in);
    }
// metodo para manejo de errores de inputs del usuario
    private int leerOpcion() {
        int opcion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcion = scanner.nextInt();
                entradaValida = true; // Si la entrada es un número, salimos del bucle
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
        }

        return opcion;
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n--- Colección de Vinilos ---");
            System.out.println("1. Agregar vinilo");
            System.out.println("2. Buscar vinilo");
            System.out.println("3. Ver cantidad de vinilos");
            System.out.println("4. Ver espacio disponible");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarVinilo();
                    break;
                case 2:
                    buscarVinilo();
                    break;
                case 3:
                    verCantidadVinilos();
                    break;
                case 4:
                    verEspaciosDisponibles();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }


    private void agregarVinilo() {
        System.out.print("Ingrese el nombre del artista: ");
        String artista = scanner.nextLine();
        System.out.print("Ingrese el nombre del disco: ");
        String nombreDisco = scanner.nextLine();
        int anio = leerYear();

        Vinilo vinilo = new Vinilo(artista, nombreDisco, anio);
        if (coleccion.agregarVinilo(vinilo)) {
            System.out.println("Vinilo agregado exitosamente.");
        } else {
            System.out.println("La colección está llena. No se pudo agregar el vinilo.");
        }
    }

    private int leerYear() {
        int year = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el año de lanzamiento: ");
                year = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número para el año.");
                scanner.nextLine();
            }
        }

        return year;
    }

    private void buscarVinilo() {
        System.out.print("Ingrese el nombre del disco a buscar: ");
        String nombreABuscar = scanner.nextLine();

        if (coleccion.buscarVinilo(nombreABuscar)) {
            System.out.println("El vinilo está en la colección.");
        } else {
            System.out.println("El vinilo no está en la colección.");
        }
    }

    private void verCantidadVinilos() {
        System.out.println("Cantidad de vinilos en la colección: " + coleccion.cantidadVinilos());
    }

    private void verEspaciosDisponibles() {
        System.out.println("Espacios disponibles en la colección: " + coleccion.espaciosDisponibles());
    }
}
