/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.died.guia3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author leandroamarillo
 */
public class Sorteo {

    static int NUMEROS_GANADORES = 6;
    static int MAX_NUMERO = 42;

    private int semana, año;
    private ArrayList<Apuesta> apuestas;

    public Sorteo() {
        apuestas = new ArrayList<>();
    }

    public Sorteo(int semana, int año) {
        this.semana = semana;
        this.año = año;
        apuestas = new ArrayList<>();
    }

    public byte[] generarSorteo() {
        byte[] ganadores = new byte[NUMEROS_GANADORES];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < NUMEROS_GANADORES; i++) {
            int ganador = r.nextInt(MAX_NUMERO + 1);
            ganadores[i] = (byte) ganador;
        }
        return ganadores;
    }

    public void addApuesta(Apuesta a) {
        apuestas.add(a);
    }

    public void calcularGanadores() {
        byte[] ganadores = generarSorteo();

        List<List<Apuesta>> puntajes = new ArrayList<>();
        for (int i = 0; i < NUMEROS_GANADORES + 1; i++) {
            puntajes.add(new ArrayList<>());
        }

        for (int i = 0; i < apuestas.size(); i++) {
            Apuesta apuestaActual = apuestas.get(i);
            int aciertos = apuestaActual.calcularAciertos(ganadores);
            puntajes.get(aciertos).add(apuestaActual);
        }

        boolean found = false;
        for (int i = puntajes.size() - 1; i > 0; i--) {
            List<Apuesta> actual = puntajes.get(i);
            if (actual.size() > 0) {
                System.out.println("Los ganadores con " + i + " aciertos son:");
                System.out.println(actual);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No gano nadie :c");
        }

    }

}
