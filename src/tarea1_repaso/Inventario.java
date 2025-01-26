/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author disma
 */
public class Inventario {
    private static class Vehiculo {
        private String matricula;
        private String marca;
        private String modelo;
        private String color;
        private int anio;
        private double precio;

        public Vehiculo(String matricula, String marca, String modelo, String color, int anio, double precio) {
            this.matricula = matricula;
            this.marca = marca;
            this.modelo = modelo;
            this.color = color;
            this.anio = anio;
            this.precio = precio;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public String getColor() {
            return color;
        }

        public int getAnio() {
            return anio;
        }

        public double getPrecio() {
            return precio;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Año: " + anio + ", Precio: " + precio;
        }
    }

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void mostrarMenu() {
        while (true) {
            String[] opciones = {"Agregar", "Listar", "Modificar", "Eliminar", "Vehículo más antiguo", "Vehículos rojos", "Diferencia de años", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Inventario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                switch (eleccion) {
                    case 0: 
                        agregarVehiculo(); 
                    break;

                    case 1: 
                        listarVehiculos(); 
                    break;

                    case 2: 
                        modificarVehiculo(); 
                    break;

                    case 3: 
                        eliminarVehiculo(); 
                    break;

                    case 4: 
                        mostrarVehiculoMasAntiguo(); 
                    break;

                    case 5: 
                        listarVehiculosRojos(); 
                    break;

                    case 6: 
                        diferenciaDeAnios(); 
                    break;

                    case 7:
                        return;

                    default: 
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
        }
    }
        
            
            

    private void agregarVehiculo() {
        if (vehiculos.size() > 50) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más vehículos. Límite alcanzado.");
            return;
        }
        String matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación del vehículo:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehículo:"));

        vehiculos.add(new Vehiculo(matricula, marca, modelo, color, anio, precio));
        JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
    }

    private void listarVehiculos() {
        if(vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
            return;
        }
        
        for (int i = 0; i < vehiculos.size() - 1; i++) {
            for (int j = i + 1; j < vehiculos.size(); j++) {
                if (vehiculos.get(i).getMarca().compareToIgnoreCase(vehiculos.get(j).getMarca()) > 0) {
                    Vehiculo temp = vehiculos.get(i);
                    vehiculos.set(i, vehiculos.get(j));
                    vehiculos.set(j, temp);
                }
            }
        }

        String lista = "Lista de vehículos: \n";
        for (Vehiculo v : vehiculos) {
            lista += v.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    private void modificarVehiculo() {
        if(vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
            return;
        }
        
        String matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo a modificar:");
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setMarca(JOptionPane.showInputDialog("Nueva marca:", vehiculo.getMarca()));
            vehiculo.setModelo(JOptionPane.showInputDialog("Nuevo modelo:", vehiculo.getModelo()));
            vehiculo.setColor(JOptionPane.showInputDialog("Nuevo color:", vehiculo.getColor()));
            vehiculo.setAnio(Integer.parseInt(JOptionPane.showInputDialog("Nuevo año:", vehiculo.getAnio())));
            vehiculo.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", vehiculo.getPrecio())));
            JOptionPane.showMessageDialog(null, "Vehículo modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    private void eliminarVehiculo() {
        if(vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
            return;
        }
        
        String matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo a eliminar:");
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehículo eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    private Vehiculo buscarVehiculo(String matricula) {        
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }

    private void mostrarVehiculoMasAntiguo() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.");
            return;
        }

        Vehiculo masAntiguo = vehiculos.get(0);
        for (Vehiculo v : vehiculos) {
            if (v.getAnio() < masAntiguo.getAnio()) {
                masAntiguo = v;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo más antiguo: \n" + masAntiguo);
    }

    private void listarVehiculosRojos() {
        if(vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
            return;
        }
        
        String lista = "Vehículos rojos: ";
        for (Vehiculo v : vehiculos) {
            if (v.getColor().equalsIgnoreCase("rojo")) {
                lista += v.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    private void diferenciaDeAnios() {
        if(vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
            return;
        }
        
        String matricula1 = JOptionPane.showInputDialog("Ingrese la matrícula del primer vehículo:");
        String matricula2 = JOptionPane.showInputDialog("Ingrese la matrícula del segundo vehículo:");
        Vehiculo vehiculo1 = buscarVehiculo(matricula1);
        Vehiculo vehiculo2 = buscarVehiculo(matricula2);

        if (vehiculo1 != null && vehiculo2 != null) {
            int diferencia = Math.abs(vehiculo1.getAnio() - vehiculo2.getAnio());
            JOptionPane.showMessageDialog(null, "Diferencia de años: " + diferencia);
        } else {
            JOptionPane.showMessageDialog(null, "Uno o ambos vehículos no fueron encontrados.");
        }
    }

}
