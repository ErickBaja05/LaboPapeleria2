package papeleria;

import java.util.Objects;

public abstract class Producto {

    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    @Override
    public String toString() {

        return String.format("Marca: %s; PVP: %.2f%n",this.nombre, this.precio);
    }

    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
            
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()) {
            
            return false;
        }
        
        Producto fantasma = (Producto) obj;
        return this.nombre.equals(fantasma.nombre) && this.precio == fantasma.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

}
