package papeleria;



public class ArrayCarrito {
    private static int contadorProductosValidos = 0;
    private static Producto[] carritoCompras= new Producto[20];
    private static int[] unidades = new int[20];

    public static Producto[] getProductosVenta() {
        return carritoCompras;
    }

    // Imprimir todos los productos
    public static void imprimirCarritoCompras() {
        for(int i = 0; i < contadorProductosValidos; i++) {
            System.out.println(carritoCompras[i] + "  CANTIDAD  " + unidades[i]);
        }
    }

    public static void agregarProducto(Producto productoComprado, int uni) {
        if(contadorProductosValidos < carritoCompras.length) {
            carritoCompras[contadorProductosValidos] = productoComprado;
            unidades[contadorProductosValidos] = uni;
            contadorProductosValidos++;
        }else{
            System.out.println("NO SE PUEDE AGREGAR EL PRODUCTO AL CARRITO DE COMPRAS");
        }
    }

    public static void eliminarProducto(int indice) {
        for(int i = indice; i < contadorProductosValidos -1; i++) {
            carritoCompras[i] = carritoCompras[i+1];
        }
        for(int i = indice; i < contadorProductosValidos -1; i++) {
            unidades[i] = unidades[i+1];
        }
        unidades[indice-1] = 0;
        contadorProductosValidos--;
    }

    public static void reducirCantidad(int cantidad, int indice) {
        unidades[indice-1] -= cantidad;
    }

    public static int getContadorProductosValidos() {
        return contadorProductosValidos;
    }

    public static Producto[] getCarritoCompras() {
        return carritoCompras;
    }

    public static int[] getUnidades() {
        return unidades;
    }

    public static String arrayCarritoToString() {
        StringBuilder stringCarritoCompras = new StringBuilder();
        for(int i = 0; i < contadorProductosValidos; i++) {
            stringCarritoCompras.append(String.format("%-45s",carritoCompras[i].getNombre())).append("Cantidad:").append(String.format("%-3d",unidades[i])).append("    Precio Unitario:").append(String.format("$%.2f",carritoCompras[i].getPrecio())).append("\n");
        }
        return stringCarritoCompras.toString();
    }

}
