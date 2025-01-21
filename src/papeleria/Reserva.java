package papeleria;

import java.util.Objects;

public class Reserva extends Comprobante implements IVA, Cargo {

    private static int contador = 0;
    private int fechaLimite;
    private Vendedor vendedor;
    private double precioTarifa;
    private double cuotas;
    public static final Producto defProd = new Producto("N/A", 0) {
    } ;
    public Reserva(Vendedor vendedor) {
        super(++contador,defProd,"");
        this.vendedor = vendedor;
    }
    public Reserva(Producto producto, String fecha, int fechaLimite, Vendedor vendedor) {
        super(++contador,producto, fecha);
        this.fechaLimite = fechaLimite;
        this.vendedor = vendedor;
        this.precioTarifa = impuestoIVA() + calculoCargo();
        this.cuotas = (precioTarifa) / fechaLimite;
    }

    public int getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(int fechaLimite) throws IllegalArgumentException {
        if (fechaLimite <= 0 || fechaLimite > 30){
            throw new IllegalArgumentException("La fecha limite está fuera de lo que permitimos en la tienda, intente de nuevo");
        } else {
            this.fechaLimite = fechaLimite;
        }
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public static int getContador() {
        return contador;
    }
    public double getPrecioTarifa() {
        return precioTarifa;
    }

    public void setPrecioTarifa() {
        if(fechaLimite ==1){
            this.precioTarifa = impuestoIVA() + calculoCargo();
        }
        else{
            this.precioTarifa = impuestoIVA() + calculoCargo() + producto.getPrecio()*0.10;
        }
    }

    public double getCuotas() {
        return cuotas;
    }

    public void setCuotas() {
        if(fechaLimite == 1){
            this.cuotas = precioTarifa;
        }else {
            this.cuotas = ((precioTarifa) / fechaLimite) + 0.005;
        }
    }

    @Override
    public String toString() {
        return String.format("%sValor de crédito + IVA: %.2f%nPago en cuotas: %.2f%nVálido hasta: %s día/s%n%s%n¡A su servicio!%nNota: De sobrar saldo, se mantendrá como abono para próximas compras.",super.toString(),
                precioTarifa,this.cuotas,this.fechaLimite, this.vendedor.toString());
    }

    @Override
    public double impuestoIVA() {

        return (this.producto.getPrecio() * (1+IVA));
    }

    @Override
    public double calculoCargo() {
        if (producto.getPrecio() <= 2){
            return (Cargo.cargo) * producto.getPrecio(); // 10% del costo total
        } else if (producto.getPrecio() > 2 && producto.getPrecio() <= 3) {
            return (Cargo.cargo + 0.02) * producto.getPrecio() ; // 12% del costo total
        } else {
            return (Cargo.cargo + 0.05) * producto.getPrecio(); // 15% del costo total
        }
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) {
            return false;
        }

        if(!(obj instanceof NotaVenta)) {

            return false;
        }

        Reserva fantasma = (Reserva) obj;

        return this.fechaLimite == fantasma.fechaLimite && this.vendedor.equals(fantasma.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fechaLimite, this.vendedor);
    }

}
