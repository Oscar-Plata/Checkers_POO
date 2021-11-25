/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.checkers;

import java.util.Scanner;

/**
 * Clase de juego de damas
 * @author Oscar JLP
 * @version 15/11/2021
 */
public class Checkers {

    public static TableroView tv = new TableroView();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jugador j1 = new Jugador();
        String j1Col = "rojo";
        Jugador j2 = new Jugador();
        String j2Col = "verde";
        int turnos=0;
        int contador=0;
        System.out.println("Ingresa cantidad de turnos: ");
        turnos=sc.nextInt();
        tv.dibujarTablero();
        fichasIniciales(j1, j2, j1Col, j2Col);
        do {
            
            System.out.println("\nTURNO #"+(contador+1)+" > JUGADOR 1 (ROJO):");
            moverFicha(j1, j2);
            System.out.println("\nTURNO JUGADOR 2 (VERDE):");
            moverFicha(j2, j1);
            contador++;
        } while (contador<turnos);
        
        System.out.println("\nJugador 1 Fichas comidas: "+j1.getFichasComidas());
        System.out.println("Jugador 2 Fichas comidas: "+j2.getFichasComidas());
        System.out.println("Fin");
    }

    public static void moverFicha(Jugador j, Jugador jn) {
        String origen = " ";
        String destino = " ";
        boolean existe = false;

        do {
            existe = false;
            System.out.println("Ingresa Coordenada Origen de ficha:");
            origen = sc.next().toUpperCase().trim();

            int c = 0;
            int posicion = 0;

            for (Ficha f : j.getFichas()) {
                if (origen.equals(f.getCoordenada())) {
                    existe = true;
                    posicion = c;
                }
                c++;
            }
            if (existe) {
                System.out.println("Si existe ficha en esa posicion");

                boolean ocupado = false;

                do {
                    ocupado = false;
                    boolean valido = false;
                    do {
                        valido = false;
                        System.out.println("Ingrese Coordenada de Destino: ");
                        destino = sc.next().trim().toUpperCase();
                        valido = verificarCoordDestino(destino);
                        if (!valido) System.out.println("Coordenada no valida");
                    } while (!valido);
                    for (Ficha f : j.getFichas()) {
                        if (destino.equals(f.getCoordenada())) {
                            ocupado = true;
                            System.out.println("Destino ya ocupado, Seleccione otro.");
                        }
                    }
                } while (ocupado);
                boolean comido = false;
                int a = 0;
                int pos = 0;
                for (Ficha f : jn.getFichas()) { //verificar si comemos ficha
                    if (destino.equals(f.getCoordenada())) {
                        comido = true;
                        System.out.println("Has comido una ficha enemiga.");
                        pos = a;
                    }
                    a++;
                }
                if (comido) {
                    Ficha fe = jn.getFicha(pos); //ficha enemiga comida
                    //System.out.println(fe);
                    tv.borrarFicha(fe);
                    fe.setCoordenada("COMIDA");
                    tv.dibujarFicha(fe);
                    j.setFichasComidas(j.getFichasComidas()+1);
                }
                Ficha fj = j.getFicha(posicion);
                tv.borrarFicha(fj);
                fj.setCoordenada(destino);
                fj.dividirCoordenada();
                tv.dibujarFicha(fj);
                
            } else {
                System.out.println("No existe ficha esa posicion o no es una posicion valida");
            }
        } while (!existe);
    }

    public static void fichasIniciales(Jugador j1, Jugador j2, String j1c, String j2c) {
        int a = 0, c = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 != 0) {
                j1.setFicha(c, j1c, "A" + String.valueOf(i + 1));
                c++;
                j1.setFicha(c, j1c, "C" + String.valueOf(i + 1));
                c++;
                j2.setFicha(a, j2c, "G" + String.valueOf(i + 1));
                a++;

            } else {
                j1.setFicha(c, j1c, "B" + String.valueOf(i + 1));
                c++;
                j2.setFicha(a, j2c, "H" + String.valueOf(i + 1));
                a++;
                j2.setFicha(a, j2c, "F" + String.valueOf(i + 1));
                a++;
            }
        }
        for (Ficha f : j1.getFichas()) {
            //System.out.println(f);
            if (f != null) {
                tv.dibujarFicha(f);
            }
        }
        for (Ficha f : j2.getFichas()) {
            //System.out.println(f);
            if (f != null) {
                tv.dibujarFicha(f);
            }
        }
    }

    public static boolean verificarCoordDestino(String s) {
        boolean valido = false;
        if(s.length()<=2){
        String linea = "" + s.charAt(0);
        int columna = Character.getNumericValue(s.charAt(1));
        if (columna > 0 && columna < 9) {
            if (linea.equals("A") || linea.equals("B") || linea.equals("C") || linea.equals("D")
                    || linea.equals("E") || linea.equals("F") || linea.equals("G") || linea.equals("H")) {
                valido = true;
            }
        }
        }
        return valido;
    }
}
