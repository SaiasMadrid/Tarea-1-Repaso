/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_repaso;

import javax.swing.JOptionPane;

/**
 *
 * @author disma
 */
public class Tarea1_Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inventario inventario = new Inventario();
        Recursividad recursividad = new Recursividad();
        
        boolean menu = true;
        while (menu) {
            String[] opciones = {"Inventario", "Recursividad", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            if (eleccion == 0) {
                inventario.mostrarMenu();
            } else if (eleccion == 1) {
                recursividad.mostrarMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Adios");
                break;
            }
        }
    }
}
