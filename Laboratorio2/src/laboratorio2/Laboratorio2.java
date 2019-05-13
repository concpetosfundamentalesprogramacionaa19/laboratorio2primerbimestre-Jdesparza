/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Laboratorio2 {

    public static void main(String[] args) {
        // declaración de variables y arreglos
        boolean bandera = true;
        int opcion;
        String nombres[] = new String[10000];
        String apellidos[] = new String[10000];
        double sueldo_semana[] = new double[10000];
        int n_hijos[] = new int[10000];
        int x;
        int i = 1;
        int j = 1;
        double g_pasaje[] = new double[10000];
        double g_bar[] = new double[10000];
        double g_salida[] = new double[10000];
        double Total_gpasaje[] = new double[10000];
        double Total_gbar[] = new double[10000];
        double Total_gsalida[] = new double[10000];
        double Total[] = new double[10000];

        // para importacion de datos por teclado a la biblioteca
        Scanner entrada = new Scanner(System.in);

        /**
         * El ciclo while permite ejecutar varias lineas de codigo de forma
         * repetitiva mientras la condicion permanesca verdadera y finaliza
         * cuando la condicion se vuelve falsa.
         */
        while (bandera == true) {
            // ingreso de la opcion por teclado, sobre el ingreso y salida de 
            // información de padres de familia.
            System.out.println("Por Favor escoga una de las siguientes "
                    + "opciones: ");
            System.out.println("------------------------ Menú --------------"
                    + "-----------------");
            System.out.println("| 1 Ingresar información del padre de "
                    + "familia               |");
            System.out.println("| 2 Mostrar la informacion de los padres de "
                    + "familia y salir |");
            System.out.println("----------------------------------------------"
                    + "---------------");
            opcion = entrada.nextInt();

            /**
             * El ciclo If permite ejecutar las lineas de codigo que tiene, solo
             * si la condición propuesta en el mismo se cumple.
             */
            // Se utiliza este if para el ingreso de datos de los padres de 
            // familia
            if (opcion == 1) {
                /**
                 * El bucle For tiene un valor inicial y uno final, y el valor
                 * inicial va aumentando o disminuyendo hasta llegar al valor
                 * final. Esto le sirve para recorrer las mismas lineas de
                 * codigo hasta que el ciclo del valor inicial termine.
                 */
                for (i = j; i <= j; i++) {
                    // ingreso de datos por teclado de los padres de familia.
                    entrada.nextLine();
                    System.out.println("Por favor ingrese los nombres del "
                            + "padre de familia: ");
                    nombres[i] = entrada.nextLine();
                    System.out.println("Por favor ingrese los apellidos del "
                            + "padre de familia: ");
                    apellidos[i] = entrada.nextLine();
                    System.out.println("Por favor ingrese el sueldo semanal "
                            + "del padre de familia: ");
                    sueldo_semana[i] = entrada.nextDouble();
                    System.out.println("Por favor ingrese el número de hijos "
                            + "del padre de familia: ");
                    n_hijos[i] = entrada.nextInt();

                    // ingreso de gastos de los hijos del padre de familia en 
                    // el caso de que tenga hijos.
                    if (n_hijos[i] > 0) {
                        for (x = 1; x <= n_hijos[i]; x++) {
                            System.out.println("Por favor ingrese el gasto "
                                    + "semanal para pasajes de su " + x + " "
                                    + "hijo");
                            g_pasaje[x] = entrada.nextDouble();
                            System.out.println("Por favor ingrese el gasto "
                                    + "semanal para el bar de su " + x + " "
                                    + "hijo");
                            g_bar[x] = entrada.nextDouble();
                            System.out.println("Por favor ingrese el gasto "
                                    + "semanal para salidas de su " + x + " "
                                    + "hijo");
                            g_salida[x] = entrada.nextDouble();

                            // suma de cada uno de los gastos
                            Total_gpasaje[x] = Total_gpasaje[x] + g_pasaje[x];
                            Total_gbar[x] = Total_gbar[x] + g_bar[x];
                            Total_gsalida[x] = Total_gsalida[x] + g_salida[x];
                            Total[x] = Total_gsalida[x] + Total_gbar[x]
                                    + Total_gsalida[x];
                        }
                    }
                }
                i = i + 1;
                j = j + 1;
            }

            // se usa este if para la salida de datos de los padres de familia.
            if (opcion == 2) {
                // salida de datos
                for (i = 1; i < j; i++) {
                    System.out.println("====================================="
                            + "=============================");
                    System.out.println("\nReporte Gastos de Padres de "
                            + "Familia\n");
                    System.out.println("Reporte " + i + "\n");
                    System.out.printf("Nombre de Padre de Familia: %s %s\n",
                            nombres[i], apellidos[i]);
                    System.out.printf("Sueldo Semanal: $%s\n",
                            sueldo_semana[i]);
                    System.out.printf("Número de hijos: %s\n\n", n_hijos[i]);
                    System.out.println("Reporte de Gastos");
                    System.out.println("Persona   Pasaje   Bar   Salidas");
                    if (n_hijos[i] > 0) {
                        for (x = 1; x <= n_hijos[i]; x++) {
                            System.out.printf("Hijo %s     %s     %s    "
                                    + " %s\n", x,
                                    g_pasaje[x], g_bar[x], g_salida[x]);
                        }
                    }
                    System.out.printf("Totales    %s     %s     %s",
                            Total_gpasaje[i], Total_gbar[i],
                            Total_gsalida[i]);
                    if (Total[i] < sueldo_semana[i]) {
                        System.out.printf("\nEl padre de fimilia %s %s le "
                                + "alcanza el dinero \nsemanal, para sus "
                                + "gastos\n", nombres[i], apellidos[i]);
                    } else {
                        if (Total[i] > sueldo_semana[i]) {
                            System.out.printf("\nEl padre de fimilia %s %s le "
                                    + "falta el dinero \nsemanal, para sus "
                                    + "gastos\n", nombres[i], apellidos[i]);
                        }
                    }
                    System.out.println("\nFin reporte " + i);
                    System.out.println("====================================="
                            + "=============================");
                }

                // se declara la bandera en falso y se hace uso de (break) para
                // finalizar el While.
                bandera = false;
                break;
            }

            /**
             * se usa esta if para que en el caso de que el usuario ingrese otra
             * opcion que no esta en el menú darle a conocer que esta no existe.
             */
            if (opcion > 2 || opcion < 1) {
                System.out.println("La opcion ingresada es incorrecta");
            }
        }
    }
}
