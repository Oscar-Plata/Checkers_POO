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
public class TableroView {

    Cuadro[][] casillas;
    Circulo[][] fichas;

    public TableroView() {
        casillas = new Cuadro[8][8];
        fichas = new Circulo[8][8];
    }

    public void dibujarTablero() {
        int c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casillas[i][j] = new Cuadro();
                casillas[i][j].setyPosition((i * 90));
                casillas[i][j].changeSize(90);
                casillas[i][j].setxPosition((j * 90));
                if (c % 2 == 0) {
                    casillas[i][j].changeColor("white");
                } else {
                    casillas[i][j].changeColor("black");
                }
                c++;
                casillas[i][j].dibujar();
            }
            c++;
        }
    }

    public void dibujarFicha(Ficha f) {
        if (f.getCoordenada().equals("COMIDA")) {
           Circulo comida= new Circulo();
           comida.cambiarPosicion(1000, 500);
           comida.changeSize(85);
           comida.changeColor(f.getColor());
           comida.makeVisible();
        } else {
            int a = (f.getLinea() - 1);

            int b = f.getNumColumna();
            fichas[a][b] = new Circulo();
            fichas[a][b].cambiarPosicion((a * 90) + 2, (b * 90) + 2);
            fichas[a][b].changeSize(85);
            fichas[a][b].changeColor(f.getColor());
            fichas[a][b].makeVisible();
        }
    }

    public void borrarFicha(Ficha f) {
        int a = (f.getLinea() - 1);
        int b = f.getNumColumna();
        fichas[a][b].makeInvisible();

    }

}
