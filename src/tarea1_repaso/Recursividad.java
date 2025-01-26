/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_repaso;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author disma
 */
public class Recursividad {
    public void mostrarMenu() {
        while (true) {
            String[] opciones = {"Decimal a Binario", "MCD", "Fibonacci", "Búsqueda Binaria", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Recursividad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0: 
                    decimalABinario(); 
                break;
                
                case 1: 
                    calcularMCD(); 
                break;
                
                case 2: 
                    calcularFibonacci();
                break;
                
                case 3: 
                    busquedaBinaria(); 
                break;
                
                default: 
                return;
            }
        }
    }

    private void decimalABinario() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número decimal:"));
        String binario = convertirABinario(numero);
        JOptionPane.showMessageDialog(null, "Binario: " + binario);
    }

    private String convertirABinario(int numero) {
        if (numero == 0) {
            return "0";
        }
        if (numero == 1) {
            return "1";
        }
        return convertirABinario(numero / 2) + (numero % 2);
    }

    private void calcularMCD() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer número:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo número:"));
        int mcd = calcularMCDRecursivo(a, b);
        JOptionPane.showMessageDialog(null, "MCD: " + mcd);
    }

    private int calcularMCDRecursivo(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCDRecursivo(b, a % b);
    }

    private void calcularFibonacci() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el término deseado de Fibonacci:"));
        int fibonacci = calcularFibonacciRecursivo(n);
        JOptionPane.showMessageDialog(null, "Fibonacci: " + fibonacci);
    }

    private int calcularFibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return calcularFibonacciRecursivo(n - 1) + calcularFibonacciRecursivo(n - 2);
    }

    private static void busquedaBinaria() {
        String[] elementos = JOptionPane.showInputDialog("Ingrese una lista de números separados por comas:").split(",");
        int[] arr = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            arr[i] = Integer.parseInt(elementos[i]);
        }

        ordenarSeleccion(arr);

        int objetivo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número a buscar:"));
        int resultado = busquedaBinariaRecursiva(arr, objetivo, 0, arr.length - 1);

        if (resultado != -1) {
            JOptionPane.showMessageDialog(null, "Número encontrado en la posición: " + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Número no encontrado.");
        }
    }

    private static void ordenarSeleccion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minimo]) {
                    minimo = j;
                }
            }
            int temp = arr[minimo];
            arr[minimo] = arr[i];
            arr[i] = temp;
        }
    }

    private static int busquedaBinariaRecursiva(int[] arr, int objetivo, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }
        int medio = (inicio + fin) / 2;
        if (arr[medio] == objetivo) {
            return medio;
        }
        if (arr[medio] > objetivo) {
            return busquedaBinariaRecursiva(arr, objetivo, inicio, medio - 1);
        }
        return busquedaBinariaRecursiva(arr, objetivo, medio + 1, fin);
    }
}
