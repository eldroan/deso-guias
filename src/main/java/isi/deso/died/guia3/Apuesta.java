/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.died.guia3;

import java.util.ArrayList;

/**
 *
 * @author leandroamarillo
 */
public class Apuesta {

    static int MAX_APUESTAS = 6;

    private String nombre;
    private ArrayList valores;

    public Apuesta() {
        this.nombre = "";
    }

    public Apuesta(String nombre, byte... valores) {
        this.nombre = nombre;
        this.valores = new ArrayList<Byte>();
        for (int i = 0; i < Math.min(valores.length, MAX_APUESTAS); i++) {
            this.valores.add(valores[i]);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList getValores() {
        return valores;
    }

    public int calcularAciertos(byte[] resultados) {
        int suma = 0;
        for (int i = 0; i < resultados.length; i++) {
            if (this.valores.contains(resultados[i])) {
                suma++;
            }
        }
        return suma;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
