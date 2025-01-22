package papeleria;


import java.util.Arrays;

public class ArrayProductos {
    private static int contadorProductosValidos;
    private static Producto[] productosVenta = new Producto[20];
    private static int[] stock = new int[20];
    static {
        // Agregando Lapices
        productosVenta[0] = new Lapiz("Lapiz BIC Evolution", 0.8, "HB");
        productosVenta[1] = new Lapiz("Lapiz MONGOL", 0.8, "2B");
        productosVenta[2] = new Lapiz("Lapiz Faber Castell 9000", 0.8, "3B");
        // Agregando Cuadernos
        productosVenta[3] = new Cuaderno("Cuaderno Norma Universitario", 2.60, 100, "cuadros");
        productosVenta[4] = new Cuaderno("Cuaderno Norma Universitario", 2.20, 100, "1 linea");
        productosVenta[5] = new Cuaderno("Cuaderno Norma Universitario", 2.80, 100, "4 lineas");
        productosVenta[6] = new Cuaderno("Cuaderno Estilo Universitario", 2.55, 100, "cuadros");
        productosVenta[7] = new Cuaderno("Cuaderno Estilo Universitario", 2.25, 100, "1 linea");
        // Agregando Borradores
        productosVenta[8] = new Borrador("Borrador Staedtler Mars Plastic", 0.5, 0.25, "De queso");
        productosVenta[9] = new Borrador("Borrador Pelikan B 40", 0.65, 0.25, "Goma de Caucho");
        productosVenta[10] = new Borrador("Borrador Moldeable Faber-Castell", 1.00, 0.350, "Goma Moldeable");
        productosVenta[11] = new Borrador("Borrador Moldeable Faber-Castell", 1.00, 0.350, "Goma Moldeable");
        contadorProductosValidos = 12;
        // Inicializar los stock con 5 unidades de cada producto
        for(int i = 0 ; i < contadorProductosValidos ; i++){
            stock[i] = 5;
        }

    };

    public static Producto[] getProductosVenta() {
        return productosVenta;
    }


    // Imprimir todos los productos
    public static void imprimirProductosVenta() {
        for(int i = 0 ; i < contadorProductosValidos ; i++){
            System.out.printf("%d. %s",i+1,productosVenta[i]);
            System.out.printf("%nSTOCK: %d\n", stock[i]);
        }
    }

    // Las unidades permiten agregar el valor de que el vendedor dedica de x producto.
    public static void agregarProducto(Producto producto, int unidades) {

        int  indiceNuevoProducto = 0;

        // Añadiendo los elementos al array
        if(contadorProductosValidos < productosVenta.length){
            for (int j = 0; j < productosVenta.length; j++) {
                if (productosVenta[j] == null) {
                    productosVenta[j] = producto;
                    indiceNuevoProducto = j;
                    contadorProductosValidos++;
                    // Añadiendo stock
                    stock[indiceNuevoProducto] += unidades;
                    break;
                }
            }
        }else{
            System.out.println("No se pueden agregar mas productos a esta tienda");
        }
    }

    public static void eliminarProducto(Producto[] productosCompra) {
        for (Producto productosCarrito : productosCompra) {
            for (int i = 0; i < productosVenta.length; i++) {
                if (productosVenta[i] != null && productosCarrito.equals(productosVenta[i])) {
                    // Desplazando elementos hacia la izquierda
                    for (int j = i; j < productosVenta.length - 1; j++) {
                        productosVenta[j] = productosVenta[j + 1];
                    }
                    productosVenta[productosVenta.length - 1] = null; // Último elemento a null
                    break; // Saliendo del bucle después de la eliminación
                }
            }
        }
    }

    public static boolean verificarExistencias(int unidadesComprar, int indice){
        boolean resultado;
        if(unidadesComprar > stock[indice]){
            resultado = false;
        }
        else{
            resultado = true;
        }
        return resultado;
    }
    public static void reducirStock(int unidades, int indice){
        stock[indice-1] = stock[indice-1] - unidades;
    }
}

