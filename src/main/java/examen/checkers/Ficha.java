/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.checkers;

/**
 *
 * @author oscar
 */
public class Ficha {

    private String color;
    private char columna;
    private int linea;
    private String coordenada;

    public Ficha() {
    }

    public Ficha( String c, String p) {
        this.color = c;
        this.linea = 0;
        this.columna = ' ';
        this.coordenada = p;
        dividirCoordenada();
    }

    public void dividirCoordenada() {
        this.columna = coordenada.charAt(0);
        this.linea = Character.getNumericValue(coordenada.charAt(1));

    }
    
    public int getNumColumna(){
        int num;
        switch(columna){
            case 'A':
           case 'a': num=0; break;
           case 'B':
           case 'b': num=1; break; 
           case 'C':
           case 'c': num=2; break;
           case 'D':
           case 'd': num=3; break;
           case 'E':
           case 'e': num=4; break;
           case 'F':
           case 'f': num=5; break;
           case 'G':
           case 'g': num=6; break;
           case 'H':
           case 'h': num=7;break;
           default: System.out.println("error");
                    num=10;
                   break;
           
            
        }
        return num;       
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public String toString() {
        return "Ficha{" + "color=" + color + ", coordenada=" + coordenada + '}';
    }
    
}
