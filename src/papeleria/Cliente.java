package papeleria;

public class Cliente extends Persona {

    private String correo;
    private String direccion;
    private String telefono;
    private int idCliente; // Para equals

    // Constructor por defecto
    public Cliente() {
        super("N/A", "N/A");
        this.correo = "N/A";
        this.direccion = "N/A";
        this.telefono = "N/A";
        this.idCliente = 0;
    }

    // Constructor por parámetros
    public Cliente(String cedula, String nombre, String correo, String direccion, String telefono, int idCliente) {
        super(cedula, nombre);
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    // Getteres y setters
    public String getCorreo() {

        return this.correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getDireccion() {

        return this.direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getTelefono() {

        return this.telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    public int getIdCliente() {

        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {

        this.idCliente = idCliente;
    }

    // Sobreescritura de funciones:
    // Impresión de la forma canónica de la clase (características)
    @Override
    public String toString() {

        return String.format("%sDireccion: %s%nTelefono: %s%nCorreo Eletrónico: %s%n", super.toString(),
                this.direccion,
                this.telefono, this.correo);
    }

    // Métodos de comparación:
    /*
     * Equals: Se sobreescribe la función de la clase padre para añadir una
     * validación más a la hora de determinar
     * si dos objetos de tipo CLiente son iguales.
     */
    @Override
    public boolean equals(Object object) {

        if (super.equals(object)) {
            Cliente clienteC = (Cliente) object;
            return clienteC.idCliente == this.idCliente;
        }
        return false;
    }

    /*
     * HashCode: Se sobreescribe la función de la clase padre para añadir una
     * identificación propia de los objetos
     * de tipo cliente
     * La multipliacion de un hash por un numero primo (31 tipicamente) mejora la
     * distribución de cantidades para evitar
     * colisiones (la escaza posibilidad de que dos objetos tengan el mismo hash
     * dentro de este contexto)
     * Se utiliza el valor absoluto para trabajar solo con numeros positivos
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += 31 * this.correo.hashCode() + idCliente;
        return Math.abs(result);
    }
}