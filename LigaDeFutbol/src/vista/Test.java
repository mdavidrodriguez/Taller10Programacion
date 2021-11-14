package vista;

import datos.ArchivoLiga;
import entidades.Liga;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Registro Liga de Futbol ");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner sc = new Scanner(System.in);
                        ArchivoLiga archivo = new ArchivoLiga();
                        Liga l = new Liga();
                        System.out.println("Digite el Nombre del equipo: ");
                        l.setNombreEquipo(sc.nextLine());
                        System.out.println("Digite los partidos Jugados: ");
                        l.setParJugados(sc.nextInt());
                        System.out.println("Numero de partidos Ganados: ");
                        l.setParGanados(sc.nextInt());
                        System.out.println("Numero de partidos Perdidos: ");
                        l.setParPerdidos(sc.nextInt());
                        System.out.println("Numero de partidos Empatados: ");
                        l.setParEmpatadados(sc.nextInt());
                        System.out.println("Numero de puntos Acumulados: ");
                        l.setPuntosAcum(sc.nextInt());

                        archivo.escribir(l);

                        List<Liga> liga = archivo.leer();
                        imprimirLista(liga);
                        break;
                    case 2:
                    
                        //Falta Implementar
                        break;

                    case 3:
                        //Falta Implementar
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    public static void imprimirLiga(Liga l) {
        System.out.printf("%10s %10d %10d %10d %10d %10.2f%n", l.getNombreEquipo(), l.getParJugados(), l.getParGanados(),
                l.getParPerdidos(), l.getParEmpatadados(), l.getPuntosAcum());
    }

    public static void imprimirLista(List<Liga> lista) {
        for (Liga l : lista) {
            imprimirLiga(l);
        }

    }

}
