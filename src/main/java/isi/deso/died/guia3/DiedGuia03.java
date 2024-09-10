/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package isi.deso.died.guia3;

/**
 *
 * @author leandroamarillo
 */
public class DiedGuia03 {

    /**
     * 1. Crear el punto P1(1,1) 2. Crear el punto P2(2,2). 3. Crear la recta R1
     * con los puntos P1 y P2. 4. Mostrar por pantalla la pendiente de la recta
     * R1. 5. Crear el punto P3(3,3). 6. Crear la recta R2 con los puntos P2 y
     * P3. 7. Mostrar por pantalla (true o false) si R1 y R2 representan la
     * misma recta
     */
    public static void main(String[] args) {
        /*
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(2, 2);
        Recta r1 = new Recta(p1, p2);
        System.out.println("La pendiente de r1 es :" + r1.pendiente());
        Punto p3 = new Punto(3, 3);
        Recta r2 = new Recta(p2, p3);
        System.out.print("Son la misma recta? " + r1.equals(r2));
         */

        Apuesta a1 = new Apuesta("Leandro", (byte) 1, (byte) 2, (byte) 6, (byte) 9);
        Apuesta a3 = new Apuesta("Juan", (byte) 1, (byte) 2, (byte) 6, (byte) 9);
        Apuesta a2 = new Apuesta("Fulano", (byte) 2, (byte) 4, (byte) 6, (byte) 9, (byte) 0);

        Sorteo s = new Sorteo();
        s.addApuesta(a1);
        s.addApuesta(a2);
        s.addApuesta(a3);

        s.calcularGanadores();
    }
}
