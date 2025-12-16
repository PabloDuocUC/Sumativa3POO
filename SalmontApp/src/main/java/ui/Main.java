package ui;

import data.GestorUnidades;
import model.*;
import javax.swing.*;
import java.util.List;

public class Main {

    //Metodo para agregar empleados desde interfaz gui
    private static void agregarEmpleado(GestorUnidades gestor) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del empleado: ");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String cargo = JOptionPane.showInputDialog("Puesto de trabajo de " + nombre + ":");
            if (cargo == null || cargo.trim().isEmpty()) return;

            String salarioTexto = JOptionPane.showInputDialog("Saldo de: " + nombre + ":");
            if (salarioTexto == null || salarioTexto.trim().isEmpty()) return;

            double salario = Double.parseDouble(salarioTexto);
            gestor.getUnidades().add(new Empleado(nombre, cargo, salario));

            JOptionPane.showMessageDialog(null, "Empleado agregado: " + nombre);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }

    //Metodo para agregar proveedor desde interfaz gui
    private static void agregarProveedor(GestorUnidades gestor) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del proveedor:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String producto = JOptionPane.showInputDialog("Producto ofrecido por " + nombre + ":");
            if (producto == null || producto.trim().isEmpty()) return;

            String aniosTexto = JOptionPane.showInputDialog("Años de servicio de " + nombre + ":");
            if (aniosTexto == null || aniosTexto.trim().isEmpty()) return;

            int anios = Integer.parseInt(aniosTexto);
            gestor.getUnidades().add(new Proveedor(nombre, producto, anios));

            JOptionPane.showMessageDialog(null, "Proveedor agregado: " + nombre);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }
    //Metodo para la opcion de mostrar Resumen
    private static void mostrarResumen(GestorUnidades gestor) {
        List<Registrable> entidades = gestor.getUnidades();

        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay entidades.");
            return;
        }

        int centros = 0, plantas = 0, proveedores = 0, empleados = 0;
        StringBuilder resumen = new StringBuilder("..:RESUMEN DEL SISTEMA:..");
        System.out.println("");

        for (Registrable entidad : entidades) {
            if (entidad instanceof CentroCultivo) {
                centros++;
                CentroCultivo c = (CentroCultivo) entidad;
                resumen.append("Centro: ").append(c.getNombre()).append("\n");
            } else if (entidad instanceof PlantaProceso) {
                plantas++;
                PlantaProceso p = (PlantaProceso) entidad;
                resumen.append("Planta: ").append(p.getNombre()).append("\n");
            } else if (entidad instanceof Proveedor) {
                proveedores++;
                Proveedor pr = (Proveedor) entidad;
                resumen.append("Proveedor: ").append(pr.getNombre()).append("\n");
            } else if (entidad instanceof Empleado) {
                empleados++;
                Empleado e = (Empleado) entidad;
                resumen.append("Empleado: ").append(e.getNombre()).append("\n");
            }
        }

        resumen.append("RESUMEN SALMONTTAPP:\n");
        resumen.append("Centros: ").append(centros).append("\n");
        resumen.append("Plantas: ").append(plantas).append("\n");
        resumen.append("Proveedores: ").append(proveedores).append("\n");
        resumen.append("Empleados: ").append(empleados).append("\n");
        resumen.append("Total: ").append(entidades.size()).append(" entidades existentes en programa");

        JTextArea area = new JTextArea(resumen.toString(), 15, 40);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        JOptionPane.showMessageDialog(null, scroll, "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo para inicar la interfaz gui
    private static void iniciarInterfaz(GestorUnidades gestor) {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"Agregar Empleado", "Agregar Proveedor", "Mostrar Resumen", "Salir"};

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "SALMONTTAPP\nSeleccione una opcion:",
                    "..:Menu Principal:..",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    agregarEmpleado(gestor);
                    break;
                case 1:
                    agregarProveedor(gestor);
                    break;
                case 2:
                    mostrarResumen(gestor);
                    break;
                case 3:
                case -1:
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar gestor de SalmontAPP.");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        System.out.println("Bienvenido a SalmontAPP");

        // Cargar archivos utilizando gestor
        GestorUnidades gestor = new GestorUnidades();

        // demostracion de uso de instanceof
        System.out.println("\nDemostracion de instanceof:");
        gestor.mostrarConInstanceof();

        System.out.println("\nIniciando interfaz grafica...");


        iniciarInterfaz(gestor);
    }
}
