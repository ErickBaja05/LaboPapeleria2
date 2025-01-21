package papeleria;

import java.lang.Throwable;
import java.util.Objects;

public class Factura extends Comprobante implements IVA {

    private static int contador = 0;
    private Cliente cliente;
    private Vendedor vendedor;
    private boolean anulacion;

    public Factura(Producto producto, String fecha, Cliente cliente, Vendedor vendedor) {
        super(++contador, producto, fecha);
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.anulacion = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public boolean isAnulacion() {
        
        if(anulacion) {
            
            System.out.println("Esta factura ha sido anulada");
        } else {
            
            System.out.println("Esta factura es valida");
        }
        return anulacion;
    }
    
    public void setAnulacion(boolean anulacion) {
        this.anulacion = anulacion;
    }
    
    @Override
    public double impuestoIVA() {

        return (this.producto.getPrecio() * (1+IVA));
    }

    @Override
    public String toString() {
        return String.format("%s%s%sPrecio Final: %.2f",super.toString(),this.cliente.toString(),
                this.vendedor.toString(),this.impuestoIVA());
    }

//    @Override
//    public void finalize() throws Throwable {
//
//        try {
//
//            this.contador--;
//            System.out.printf("Se ha eliminado el comprobante %d.%n",this.numero);
//        } finally {
//
//            super.finalize();
//        }
//    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) {
            return false;
        }

        if(!(obj instanceof NotaVenta)) {

            return false;
        }

        Factura fantasma = (Factura) obj;

        return this.cliente.equals(fantasma.cliente) && this.vendedor.equals(fantasma.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cliente, this.vendedor);
    }


}
