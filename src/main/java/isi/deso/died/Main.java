/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.died;

import isi.deso.died.guia2.DiedGuia02;
import isi.deso.died.guia3.DiedGuia03;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leandroamarillo
 */
public class Main {

    public static Class<?>[] classes = {
        DiedGuia02.class,
        DiedGuia03.class
    };

    public static void main(String[] args) {

        System.out.println("Selecciona el numero de la guia a ejecutar y apreta enter:");
        for (int i = 0; i < classes.length; i++) {
            String wording = i + 1 + " - " + classes[i].getSimpleName();
            System.out.println(wording);
        }
        Scanner scanner = new Scanner(System.in);
        int guia = -1;
        boolean valido = false;

        do {
            try {
                guia = scanner.nextInt() - 1;
                valido = guia >= 0 && guia < classes.length;
            } catch (InputMismatchException ex) {
                System.out.println("Eso no es un numero...");
            }
            if (!valido) {
                System.out.println("No encontre la guia que me pediste probá de nuevo :)");
            }
        } while (!valido);

        try {
            Class<?> clazz = classes[guia];
            // Manoteamos el main de la clase y reventamos si no existe
            Method mainMethod = clazz.getDeclaredMethod("main", String[].class);
            // Ejecutamos el metodo main pasandole null porque es static
            mainMethod.invoke(null, (Object) args);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
