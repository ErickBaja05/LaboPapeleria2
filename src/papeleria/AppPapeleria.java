package papeleria;

import java.util.InputMismatchException;
import java.util.Scanner;

//import java.lang.Throwable;

public class AppPapeleria {
    //extends Throwable{
    private static final String usuarioAdmin = "admin";
    private static final String contraseniaAdmin = "admin";
    private static Vendedor vendedor1 = new Vendedor("0321456987", "Pedro", 8, "Vendedor");


    private static Lapiz lapiz1 = new Lapiz("Mongol", 0.8, "HB");
    private static Borrador borrador1 = new Borrador("Borrador", 0.5, 0.25, "De queso");
    private static Cuaderno cuaderno1 = new Cuaderno("Norma", 3.1, 60, "Dos lineas");


    public static void main(String[] args) {
            ejecutar();
    }


    public static void ejecutar(){
        Scanner sc = new Scanner(System.in);
        boolean enEjecucion = true;
        while (enEjecucion) {
            int op = -1;
            while (op < 1 || op > 3) {
                try {
                    System.out.println(menuPrincipal());
                    op = sc.nextInt();
                    if ((op < 1) || (op > 3)) {
                        System.out.println("Ingrese una opcion valida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                    sc.nextLine();
                }
            }

            switch (op) {
                case 1:
                    int opCliente = -1;
                    while (opCliente < 1 || opCliente > 2) {
                        try {
                            System.out.println(menuCliente());
                            opCliente = sc.nextInt();
                            if ((opCliente < 1) || (opCliente > 2)) {
                                System.out.println("Ingrese una opcion valida.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                            sc.nextLine();
                        }
                    }
                    if (opCliente == 1) {
                        manejar();
                    } else {
                        reservarProducto();
                    }
                    break;
                case 2:
                    boolean admin = validacionAdmin();
                    if (admin) {
                        int opProductoVerificacion = -1;
                        System.out.println(menuValidaciones());
                        while (opProductoVerificacion < 1 || opProductoVerificacion > 3) {
                            try {
                                opProductoVerificacion = sc.nextInt();
                                if ((opProductoVerificacion < 1) || (opProductoVerificacion > 3)) {
                                    System.out.println("Ingrese una opcion valida.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                                sc.nextLine();
                            }
                        }
                        switch (opProductoVerificacion) {
                            case 1:
                                boolean existeLapiz = verificarLapiz();
                                if (existeLapiz) {
                                    System.out.println("HAY STOCK DEL PRODUCTO");
                                } else {
                                    System.out.println("NO SE ENCONTRADO");
                                }
                                break;
                            case 2:
                                boolean existeCuaderno = verificarCuaderno();
                                if (existeCuaderno) {
                                    System.out.println("HAY STOCK DEL PRODUCTO");
                                } else {
                                    System.out.println("NO SE ENCONTRADO");
                                }
                                break;
                            case 3:
                                boolean existeBorrador = verificarBorrador();
                                if (existeBorrador) {
                                    System.out.println("HAY STOCK DEL PRODUCTO");
                                } else {
                                    System.out.println("NO SE ENCONTRADO");
                                }
                                break;
                        }
                    } else {
                        System.out.println("CREDENCIALES INCORRECTAS.");

                    }
                    break;
                case 3:
                    enEjecucion = false;
                    sc.close();
            }
        }
    }

    public static boolean validacionAdmin() {
        boolean Aprobado = false;
        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        String contrasenia;
        System.out.println("Ingrese el nombre de usuario: ");
        nombreUsuario = sc.nextLine();
        System.out.println("Ingrese la contraseña: ");
        contrasenia = sc.nextLine();
        if (nombreUsuario.equals(usuarioAdmin) && contrasenia.equals(contraseniaAdmin)) {
            Aprobado = true;
        }
        return Aprobado;
    }

    public static String menuValidaciones() {
        StringBuilder menu = new StringBuilder();
        menu.append("*****OPCIONES DE ADMINISTRADOR*******\n");
        menu.append("1. VERIFICAR EXISTENCIA DE UN PRODUCTO\n");
        menu.append("2. MODIFICAR STOCK EXISTENTE\n");
        menu.append("3. \n");
        menu.append("ESCOJA UNA OPCION:");
        return menu.toString();
    }

    public static boolean verificarLapiz() {
        Scanner sc = new Scanner(System.in);
        Lapiz lapiz = new Lapiz();
        System.out.println("Ingrese el nombre/marca del lapiz:  ");
        String nombre = sc.nextLine();
        lapiz.setNombre(nombre);
        System.out.println("Ingrese el precio del lapiz: ");
        double precio = sc.nextDouble();
        lapiz.setPrecio(precio);
        sc.nextLine();
        System.out.println("Ingrese la dureza del lapiz:");
        String dureza = sc.nextLine();
        lapiz.setDureza(dureza);
        return lapiz1.equals(lapiz);
    }

    public static boolean verificarCuaderno() {
        Scanner sc = new Scanner(System.in);
        Cuaderno cuaderno = new Cuaderno();
        System.out.println("Ingrese el nombre/marca del cuaderno:  ");
        String nombre = sc.nextLine();
        cuaderno.setNombre(nombre);
        System.out.println("Ingrese el precio del cuaderno: ");
        double precio = sc.nextDouble();
        cuaderno.setPrecio(precio);
        System.out.println("Ingrese el numero de hojas del cuaderno:");
        int nHojas = sc.nextInt();
        cuaderno.setNroHojas(nHojas);
        sc.nextLine();
        System.out.println("Ingrese el tipo de linea: ");
        String tipo = sc.nextLine();
        cuaderno.setLinea(tipo);
        return cuaderno1.equals(cuaderno);
    }

    public static boolean verificarBorrador() {
        Scanner sc = new Scanner(System.in);
        Borrador borrador = new Borrador();
        System.out.println("Ingrese el nombre/marca del borrador:  ");
        String nombre = sc.nextLine();
        borrador.setNombre(nombre);
        System.out.println("Ingrese el precio del borrador: ");
        double precio = sc.nextDouble();
        borrador.setPrecio(precio);
        System.out.println("Ingrese el peso del borrador :");
        double peso = sc.nextDouble();
        borrador.setPeso(peso);
        sc.nextLine();
        System.out.println("Ingrese el tipo de borrador: ");
        String tipo = sc.nextLine();
        borrador.setTipo(tipo);
        return borrador1.equals(borrador);
    }


    public static String menuCliente() {
        StringBuilder menu = new StringBuilder();
        menu.append("****OPCIONES DISPONIBLES********\n");
        menu.append("1. COMPRAR UN PRODUCTO \n");
        menu.append("2. RESERVAR UN PRODUCTO\n");
        menu.append("ESCOJA UNA OPCION:");
        return menu.toString();
    }


    public static void comprarProducto() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int opProductoCompra = -1;
        int cantidad = 0;
        while (opProductoCompra < 1 || opProductoCompra > ArrayProductos.getContadorProductosValidos()) {
            try {
                System.out.println("Que producto desea comprar?: ");
                opProductoCompra = sc.nextInt();
                if ((opProductoCompra < 1) || opProductoCompra > ArrayProductos.getContadorProductosValidos()) {
                    System.out.println("Ingrese una opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                sc.nextLine();
            }
            do {
                try {
                    System.out.println("INGRESE LA CANTIDAD DE PRODUCTO A COMPRAR");
                    cantidad = sc.nextInt();
                    if (cantidad < 0) {
                        System.out.println("INGRESE UNA OPCION VALIDA");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("INGRESE UNA OPCION VALIDA");
                }
            } while (cantidad < 0);

            // Agregacion de productos al carrito del user
            if(ArrayProductos.verificarExistencias(cantidad, opProductoCompra)) {
                ArrayCarrito.agregarProducto(ArrayProductos.getProductosVenta()[opProductoCompra], cantidad);
                ArrayProductos.reducirStock(cantidad, opProductoCompra);
                System.out.println("PRODUCTO AGREGADO AL CARRITO");
            }
            else{
                System.out.println("LA CANTIDAD INGRESADA SUPERA EL STOCK DISPONIBLE");

            }
        }


    }

    public static void facturacion(){
        int opFacturacion = -1;
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println(mostrarOpcionesFacturacion());
        while (opFacturacion < 1 || opFacturacion > 2) {
            try {
                System.out.println("ESCOJA LA OPCION DE FACTURACION: ");
                opFacturacion = sc.nextInt();
                if ((opFacturacion < 1) || (opFacturacion > 2)) {
                    System.out.println("Ingrese una opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.println("INGRESE SU NUMERO DE CEDULA: ");
        String cedula = sc.nextLine();
        cliente.setCedula(cedula);
        System.out.println("INGRESE SU NOMBRE: ");
        String nombre = sc.nextLine();
        cliente.setNombre(nombre);

        switch (opFacturacion) {
            case 1:
                NotaVenta notaVenta = new NotaVenta(null, "1/15/2025", cliente);
                notaVenta.setProducto(ArrayCarrito.getCarritoCompras());
                System.out.println(notaVenta);
                break;
            case 2:
                System.out.println("INGRESE SU DIRECCION");
                String direccion = sc.nextLine();
                cliente.setDireccion(direccion);
                System.out.println("INGRESE SU CORREO");
                String correo = sc.nextLine();
                cliente.setCorreo(correo);
                System.out.println("INGRESE SU TELEFONO");
                String telefono = sc.nextLine();
                cliente.setTelefono(telefono);
                Factura factura = new Factura(null, "15/01/2024", cliente, vendedor1);
                factura.setProducto(ArrayCarrito.getCarritoCompras());
                System.out.println(factura);
                break;
        }
    }

    public static String menuReserva(){
        StringBuilder opciones = new StringBuilder("MENU RESERVAS\n");
        opciones.append("1. ESCOJER PRODUCTO\n");
        opciones.append("2. FINALIZAR PROCESO DE RESERVA\n");
        opciones.append("3. VOLVER AL MENU PRINCIPAL\n");
        return opciones.toString();

    }

    public static void reservarProducto() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        Reserva rsv = new Reserva(vendedor1);
        int opProductoReserva = -1;
        int opMenuReserva = -1;
        int cantidad = 0;
        while(opMenuReserva != 3) {
            opMenuReserva = -1;
            while (opMenuReserva < 1 || opMenuReserva > 3){
                try {
                    System.out.println(menuReserva());
                    System.out.println("Que desea realizar?");
                    opMenuReserva = sc.nextInt();
                    if (opMenuReserva < 1 || opMenuReserva > 3) {
                        System.out.println("Ingrese una opcion valida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese una opcion valida.");

                } catch (InputMismatchException e) {
                    System.out.println("Ingrese datos validos");
                    sc.nextLine();
                }
            }
            if (opMenuReserva == 1) {
                ArrayProductos.imprimirProductosVenta();
                opProductoReserva = -1;
                while (opProductoReserva< 1 || opProductoReserva > ArrayProductos.getContadorProductosValidos()) {
                    try {
                        System.out.println("Que producto desea reservar?: ");
                        opProductoReserva = sc.nextInt();
                        if ((opProductoReserva < 1) || opProductoReserva > ArrayProductos.getContadorProductosValidos()) {
                            System.out.println("Ingrese una opcion valida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                        sc.nextLine();
                    }
                    do {
                        try {
                            System.out.println("INGRESE LA CANTIDAD DE PRODUCTO A RESERVAR");
                            cantidad = sc.nextInt();
                            if (cantidad < 0) {
                                System.out.println("INGRESE UNA OPCION VALIDA");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("INGRESE UNA OPCION VALIDA");
                        }
                    } while (cantidad < 0);

                    // Agregacion de productos al carrito del user
                    if(ArrayProductos.verificarExistencias(cantidad, opProductoReserva)) {
                        ArrayCarrito.agregarProducto(ArrayProductos.getProductosVenta()[opProductoReserva], cantidad);
                        ArrayProductos.reducirStock(cantidad, opProductoReserva);
                        System.out.println("PRODUCTO AGREGADO AL CARRITO");

                    }
                    else{
                        System.out.println("LA CANTIDAD INGRESADA SUPERA EL STOCK DISPONIBLE");
                    }
                }
            }else{
                rsv.setProducto(ArrayCarrito.getCarritoCompras());
                while(!valid){
                    try{
                        sc.nextLine();
                        System.out.println("Ingrese el plazo en días (1-30) para pagar el producto");
                        int fecha = Integer.parseInt(sc.nextLine());
                        rsv.setFechaLimite(fecha);
                    } catch (NumberFormatException e) {
                        System.out.println("El plazo en dias ingresado no es un número valido, intente de nuevo");
                        continue;
                    } catch (IllegalArgumentException e1) {
                        System.out.println("La fecha limite está fuera de lo que permitimos en la tienda, intente de nuevo");
                        continue;
                    }
                    valid = true;
                    rsv.setPrecioTarifa();
                    rsv.setCuotas();
                    System.out.println(rsv);
                    opMenuReserva = 3;
                }
            }

        }


    }

    public static String mostrarMenuCompras() {
        StringBuilder opciones = new StringBuilder("MENU COMPRAS\n");
        opciones.append("1. COMPRAR PRODUCTOS\n");
        opciones.append("2. MOSTRAR CARRITO\n");
        opciones.append("3. MODIFICAR CANTIDAD DE PRODUCTOS\n");
        opciones.append("4. ELIMINAR PRODUCTO DEL CARRITO\n");
        opciones.append("5. FINALIZAR PROCESO\n");
        opciones.append("6. SALIR AL MENU PRINCIPAL\n");
        return opciones.toString();
    }

    public static void manejar() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            do {
                try {
                    System.out.println(mostrarMenuCompras());
                    System.out.println("INGRESE UNA OPCION");
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > 6) {
                        System.out.println("INGRESE UNA OPCION VALIDA");
                    } else {

                    }
                } catch (InputMismatchException e) {
                    System.out.println("SOLO SE ADMITEN VALORES NUMEROS");
                }
            } while (opcion < 1 || opcion > 6);

        switch (opcion) {
            case 1:
                System.out.println("*****PRODUCTOS DISPONIBLES*****");
                ArrayProductos.imprimirProductosVenta();
                comprarProducto();
                break;
            case 2:
                System.out.println("*****CARRITO*****");
                if (ArrayCarrito.getContadorProductosValidos() == 0) {
                    System.out.println("EL CARRITO ESTA VACÍO");
                } else {
                    System.out.println(ArrayCarrito.arrayCarritoToString());;
                }
                break;
            case 3:
                System.out.println("*****MODIFIACIÓN CANTIDAD DE PRODUCTOS*****");
                if (ArrayCarrito.getContadorProductosValidos() == 0) {
                    System.out.println("EL CARRITO ESTA VACÍO");
                } else {
                    modificarProductoDelCarrito();
                }
                break;
            case 4:
                System.out.println("*****ELIMINAR PRODUCTO DE CARRITO*****");
                if (ArrayCarrito.getContadorProductosValidos() == 0) {
                    System.out.println("EL CARRITO ESTA VACIO");
                } else {
                    eliminarProductoDelCarrito();
                }
                break;
            case 5:
                facturacion();
                break;
            case 6:
                break;
        }
    } while (opcion !=6);
    }

    public static void modificarProductoDelCarrito() {
        Scanner sc = new Scanner(System.in);
        ArrayCarrito.arrayCarritoToString();
        int producto = 0;
        int cantidad = 0;
        do {
            try {
                System.out.println("INGRESE EL PRODUCTO A MODIFICAR");
                producto = sc.nextInt();
                if (producto < 1 || producto > ArrayCarrito.getContadorProductosValidos()) {
                    System.out.println("INGRESE UNA OPCION VALIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("INGRESE UNA OPCION VALIDA");
            }
        } while (producto < 1 || producto > ArrayCarrito.getContadorProductosValidos());

        do {
            try {
                System.out.println("INGRESE LA CANTIDAD DEL PRODUCTO A ELIMINAR");
                cantidad = sc.nextInt();
                if (cantidad < 0) {
                    System.out.println("INGRESE UNA OPCION VALIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("INGRESE UNA OPCION VALIDA");
            }
        } while (cantidad < 0);
        ArrayCarrito.reducirCantidad(cantidad, producto);
        System.out.println("MODIFICACIÓN EXITOSA");
    }

    public static void eliminarProductoDelCarrito() {
        Scanner sc = new Scanner(System.in);
        ArrayCarrito.imprimirCarritoCompras();
        int producto = 0;
        do {
            try {
                System.out.println("INGRESE EL PRODUCTO A ELIMINAR");
                producto = sc.nextInt();
                if (producto < 1 || producto > ArrayCarrito.getContadorProductosValidos()) {
                    System.out.println("INGRESE UNA OPCION VALIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("INGRESE UNA OPCION VALIDA");
            }
        } while (producto < 1 || producto > ArrayCarrito.getContadorProductosValidos());
        ArrayCarrito.eliminarProducto(producto);

    }


    public static String mostrarOpcionesFacturacion() {
        StringBuilder opciones = new StringBuilder();
        opciones.append("OPCIONES DE FACTURACION DISPONIBLES:\n");
        opciones.append("1. NOTA DE VENTA \n");
        opciones.append("2. FACTURA \n");
        return opciones.toString();
    }

    // MODO ADMIN PARA PROBAR LOS EQUALS.
    public static String menuPrincipal() {
        StringBuilder menu = new StringBuilder();
        menu.append("******SISTEMA DE GESTION DE PAPELERIA*****\n");
        menu.append("1. INGRESAR COMO CLIENTE\n");
        menu.append("2. INGRESAR COMO ADMIN (SISTEMA DE INVENTARIO)\n");
        menu.append("3. SALIR\n");
        menu.append("ESCOJA UNA OPCION:");
        return menu.toString();
    }

}
