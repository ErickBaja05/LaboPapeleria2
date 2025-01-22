package papeleria;



public class ArrayCarrito {
    private static int contadorProductosValidos = 0;
    public static Producto[] carritoCompras= new Producto[20];
    public static int[] unidades = new int[20];

    public static Producto[] getProductosVenta() {
        return carritoCompras;
    }

    // Imprimir todos los productos
    public static void imprimirCarritoCompras() {
        for(int i = 0; i < contadorProductosValidos; i++) {
            System.out.println(carritoCompras[i]);
        }
    }

    public static void agregarProducto(Producto productoComprado, int uni) {
        if(contadorProductosValidos < carritoCompras.length) {
            carritoCompras[contadorProductosValidos] = productoComprado;
            contadorProductosValidos++;
            unidades[contadorProductosValidos] = uni;
        }else{
            System.out.println("NO SE PUEDE AGREGAR EL PRODUCTO AL CARRITO DE COMPRAS");
        }
    }

    public static void eliminarProducto(int indice) {
        for(int i = indice; i < contadorProductosValidos -1; i++) {
            carritoCompras[i] = carritoCompras[i+1];
        }
        contadorProductosValidos--;
    }

    public static void reducirCantidad(int cantidad, int indice) {
        unidades[indice-1] -= cantidad;
    }

}
