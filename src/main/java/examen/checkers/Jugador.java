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
public class Jugador {
    private Ficha[] fichas;
    private int fichasComidas;
    private int numFichas;
    
    public Jugador(){
        fichas= new Ficha[12];
    }

    public Ficha[] getFichas() {
        return fichas;
    }
    public int getNumF(){
        return fichas.length;
    }

    public void setFichas(Ficha[] fichas) {
        this.fichas = fichas;
    }
    public Ficha getFicha(int x){
        return fichas[x];
    }
    public void setFicha(int x, String c, String s){
        fichas[x]=new Ficha(c,s);
    }

    public int getFichasComidas() {
        return fichasComidas;
    }

    public void setFichasComidas(int fichasComidas) {
        this.fichasComidas = fichasComidas;
    }
    
        
 
}
