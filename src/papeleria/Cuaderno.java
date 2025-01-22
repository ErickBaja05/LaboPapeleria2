package papeleria;

import java.util.Objects;

public class Cuaderno extends Producto {

    private int nroHojas;
    private String linea; //Se refiere al tipo de cuaderno, es decir, si es de cuadros, lineas, etc.

    public Cuaderno(String nombre, double precio, int nroHojas, String linea) {

        super(nombre, precio);
        this.nroHojas = nroHojas;
        this.linea = linea;
    }
    public Cuaderno(){
        super("Sin nombre", 0);
        this.nroHojas = 0;
        this.linea = "";
    }

    public int getNroHojas() {

        return this.nroHojas;
    }

    public void setNroHojas(int nroHojas) {

        this.nroHojas = nroHojas;
    }

    public String getLinea() {

        return this.linea;
    }

    public void setLinea(String linea) {

        this.linea = linea;
    }

    @Override
    public String toString() {
        System.out.println("**Cuaderno**");
        return String.format("%sNro de hojas: %d%nTipo de linea: %s",super.toString(),this.nroHojas,this.linea);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!super.equals(obj)) {
            
            return false;
        }
        
        if(!(obj instanceof Cuaderno)) {
            
            return false;
        }
        
        Cuaderno fantasma = (Cuaderno)obj;
        return this.nroHojas == fantasma.nroHojas && this.linea.equals(fantasma.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroHojas, linea);
    }

}
