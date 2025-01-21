package papeleria;

import java.util.Objects;

public abstract class Comprobante {

    protected int numero;
    protected Producto producto;
    protected String fecha;

    public Comprobante(int numero,Producto producto, String fecha) {
        this.numero = numero;
        this.producto = producto;
        this.fecha = fecha;
    }

    public int getNumero() {
        return this.numero;
    }

    /*public void setNumero(String numero) {
        this.numero = numero;
    }*/

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("%d%n%s%n%s%n", this.numero, this.producto.toString(),this.fecha);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {

            return true;
        }

        if(obj == null || getClass() != obj.getClass()) {

            return false;
        }

        Comprobante fantasma = (Comprobante) obj;
        return this.numero == fantasma.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numero);
    }

}
