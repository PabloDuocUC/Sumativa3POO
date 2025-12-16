package data;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorUnidades {

    private List<Registrable> unidades;

    public GestorUnidades() {
        unidades = new ArrayList<>();
        cargarDesdeArchivos();
    }

    //metodo creado para leer ambos archivos de centros y plantas.txt.
    private void cargarDesdeArchivos() {
        cargarCentrosDesdeArchivo("archivos/centros.txt");
        cargarPlantasDesdeArchivo("archivos/plantas.txt");
        cargarProveedoresDesdeArchivo("archivos/proveedores.txt");
        cargarEmpleadosDesdeArchivo("archivos/empleados.txt");

        System.out.println("Carga completada. Total entidades: " + unidades.size());
    }
    // Metodo que lee archivo y los divide creando objetos

    private void cargarCentrosDesdeArchivo(String rutaArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                linea = linea.trim();

                // Si línea vacía, continuar con siguiente iteracion del bucle
                if (linea.isEmpty()) {
                    continue;
                }

                // Dividir datos de txt cuando encuentra un ";"
                String[] datos = linea.split(";");

                // Validacion simplecita
                if (datos.length != 3) {
                    System.err.println("Línea con formato incorrecto: " + linea);
                    continue; // Saltar esta línea
                }

                // Asignar datos a variables
                String nombre = datos[0].trim();
                String comuna = datos[1].trim();
                double toneladas = Double.parseDouble(datos[2].trim());

                unidades.add(new CentroCultivo(nombre, comuna, toneladas));

            }

            System.out.println("Centros de cultivo cargados desde: " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("Error en lectura de archivo: " + rutaArchivo);
        } catch (NumberFormatException e) {
            System.err.println("Error en formato numérico de linea revise archivo de entrada... " + e.getMessage());
        }

    }

    //Metodo para lectura de plantas.txt
    private void cargarPlantasDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] datos = linea.split(";");


                if (datos.length != 3) {
                    System.err.println("Línea con formato incorrecto (plantas.txt): " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                String comuna = datos[1].trim();
                double capacidad = Double.parseDouble(datos[2].trim());

                unidades.add(new PlantaProceso(nombre, comuna, capacidad));

            }

            System.out.println("Plantas de proceso cargadas desde: " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("Error en lectura de archivo: " + rutaArchivo);
        } catch (NumberFormatException e) {
            System.err.println("Error en formato numérico de linea revise archivo de entrada... " + e.getMessage());
        }

    }
    //Cargar proveedores
    private void cargarProveedoresDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty()) continue;

                String[] datos = linea.split(";");
                if (datos.length != 3) {
                    System.out.println("Linea con formato incorrecto (proveedores.txt): " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                String producto = datos[1].trim();
                int anios = Integer.parseInt(datos[2].trim());

                unidades.add(new Proveedor(nombre, producto, anios));
            }

            System.out.println("Proveedores cargados desde: " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("No se pudo cargar proveedores desde archivo: " + rutaArchivo);
        }
    }
    //Cargar empleados
    private void cargarEmpleadosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty()) continue;

                String[] datos = linea.split(";");
                if (datos.length != 3) {
                    System.out.println("Línea con formato incorrecto (empleados.txt): " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                String cargo = datos[1].trim();
                double salario = Double.parseDouble(datos[2].trim());

                unidades.add(new Empleado(nombre, cargo, salario));
            }

            System.out.println("Empleados cargados desde: " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("No se pudo cargar empleados desde archivo: " + rutaArchivo);
        }
    }

    // Metodo en caso que no exista el archivo. Para probar funcionamiento del programa


    public List<Registrable> getUnidades() {
        return unidades;
    }

    public void mostrarTodasLasUnidades() {
        System.out.println("Mostrando un total de: " + unidades.size() + " unidades");

        // Polimorfismo para mostrar informacion diversa
        for (Registrable unidad : unidades) {
            unidad.mostrarResumen();
        }
    }

    public void mostrarConInstanceof() {
        System.out.println("Uso de instanceof para verificar raíz de cada objeto");

        int centros = 0, plantas = 0, proveedores = 0, empleados = 0; //Contadores

        for (Registrable unidad : unidades) {
            if (unidad instanceof CentroCultivo) {
                centros++;
                CentroCultivo centro = (CentroCultivo) unidad;
                System.out.println("Centro: " + centro.getNombre() + " en " + centro.getComuna());
            } else if (unidad instanceof PlantaProceso) {
                plantas++;
                PlantaProceso planta = (PlantaProceso) unidad;
                System.out.println("Planta: " + planta.getNombre() + " en " + planta.getComuna());
            } else if (unidad instanceof Proveedor) {
                proveedores++;
                Proveedor prov = (Proveedor) unidad;
                System.out.println("Proveedor: " + prov.getNombre() + " - " + prov.getProducto());
            } else if (unidad instanceof Empleado) {
                empleados++;
                Empleado emp = (Empleado) unidad;
                System.out.println("Empleado: " + emp.getNombre() + " - " + emp.getCargo());
            }
        }

        System.out.println("..:RESUMEN:..");
        System.out.println("Centros: " + centros);
        System.out.println("Plantas: " + plantas);
        System.out.println("Proveedores: " + proveedores);
        System.out.println("Empleados: " + empleados);
    }
}