package papeleria;

import java.util.Objects;

public class Lapiz extends Producto {

    private String dureza; //Se refiere a la dureza de la mina de un lápiz de grafito

    public Lapiz(String nombre, double precio, String dureza) {

        super(nombre, precio);
        this.dureza = dureza;
    }
    public Lapiz(){
        super("Sin nombre" , 0);
        this.dureza = "Sin dureza";

    }
    public String getDureza() {

        return this.dureza;
    }

    public void setDureza(String negror) {

        this.dureza = negror;
    }

    @Override
    public String toString() {
        System.out.println("**Lapiz**");
        return String.format("%sDureza del lapiz: %s",super.toString(),this.dureza);
    }

    @Override
    public boolean equals(Object obj) {

        if(!super.equals(obj)) {

            return false;
        }

        if(!(obj instanceof Lapiz)) {

            return false;
        }

        Lapiz fantasma = (Lapiz) obj;

        return this.dureza.equals(fantasma.dureza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dureza);
    }

}
