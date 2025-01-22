package papeleria;

import java.util.Objects;

public class NotaVenta extends Comprobante {

    private static int contador = 0;
    private Cliente cliente;
    //no hay impuestos


    public NotaVenta(Producto[] producto, String fecha, Cliente cliente) {

        super(++contador,producto, fecha);
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return String.format("%sCLIENTE:%n%s ", super.toString(), this.cliente.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) {
            return false;
        }

        if(!(obj instanceof NotaVenta)) {

            return false;
        }

        NotaVenta fantasma = (NotaVenta) obj;

        return this.cliente.equals(fantasma.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cliente);
    }
}
