package papeleria;

import java.util.Objects;

public class Borrador extends Producto {
    
    private double peso;
    private String tipo; //Se refiere a si es de queso, blanco, de colores, etc.
    
    public Borrador(String nombre, double precio, double peso, String tipo) {
        
        super(nombre, precio);
        this.peso = peso;
        this.tipo = tipo;
    }

    public Borrador() {
        super("Sin nombre" , 0);
        this.peso = 0;
        this.tipo = "Sin tipo";
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        System.out.println("**Borrador**");
        return String.format("%sBorrador %s con un peso de %.2f gramos%n",super.toString(), this.tipo, this.peso);
    }

    @Override
    public boolean equals(Object obj) {

        if(!super.equals(obj)) {

            return false;
        }

        if(!(obj instanceof Borrador)) {

            return false;
        }

        Borrador fantasma = (Borrador) obj;

        return this.peso == fantasma.peso && this.tipo.equals(fantasma.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso, tipo);
    }

}
