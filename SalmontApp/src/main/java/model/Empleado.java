package model;

public class Empleado implements Registrable{

    private String nombre;
    private String cargo;
    private double salario;

    public Empleado(String nombre, String cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre de empleado: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Sueldo: $" + salario);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }
}
