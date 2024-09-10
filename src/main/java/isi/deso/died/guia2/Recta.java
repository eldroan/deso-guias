/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.died.guia2;

/**
 *
 * @author leandroamarillo
 */
public class Recta {

    private Punto p1, p2;

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public Recta() {
        this.p1 = new Punto(1, 1);
        this.p2 = new Punto(2, 2);
    }

    public Recta(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Retornar la pendiente de la recta ( m = (y1 – y0) / (x1 – x0) )
     *
     * @return
     */
    public float pendiente() {
        float dy = p1.getY() - p2.getY();
        float dx = p1.getX() - p2.getX();
        return dy / dx;
    }

    public boolean paralelas(Recta r) {
        return this.pendiente() == r.pendiente();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    private boolean pertenece(Punto p3) {
        float ordenada = p1.getY() - pendiente() * p1.getX();
        float yCalculado = pendiente() * p3.getX() + ordenada;
        return p3.getY() == yCalculado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recta other = (Recta) obj;

        return pertenece(other.getP1()) && pertenece(other.getP2());

    }

}
