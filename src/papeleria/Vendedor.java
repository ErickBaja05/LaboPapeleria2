package papeleria;

public class Vendedor extends Persona {

    private int horasTurno;
    private String puesto;

    // Constructor por defecto
    public Vendedor() {
        super("N/A", "N/A");
        this.horasTurno = 0;
        this.puesto = "N/A";
    }

    // Constructor por parámetros
    public Vendedor(String cedula, String nombre, int horasTurno, String puesto) {

        super(cedula, nombre);
        this.horasTurno = horasTurno;
        this.puesto = puesto;
    }

    // Getters y setters
    public int getHorasTurno() {

        return this.horasTurno;
    }

    public void setHorasTurno(int horasTurno) {

        this.horasTurno = horasTurno;
    }

    public String getPuesto() {

        return this.puesto;
    }

    public void setPuesto(String puesto) {

        this.puesto = puesto;
    }

    // Sobreescritura de funciones:
    // Impresión de la forma canónica de la clase (características)
    @Override
    public String toString() {
        return String.format("%sPuesto: %s%n", super.toString(), this.puesto);
    }

    /*
     * Equals: Se sobreescribe la función equals de la clase padre para incluir
     * verificaciones respecto al puesto
     * y horas del vendedor
     */
    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            Vendedor vendedorC = (Vendedor) object;
            return this.puesto.equals(vendedorC.puesto) && this.horasTurno == vendedorC.horasTurno;
        }
        return false;
    }

    /*
     * HashCode: Se sobreescribe el método hashCode de la clase padre para crear un
     * identificador único para cada instancia
     * de la clase vendedor, añadiendo el hash del string puesto
     * La multipliacion de un hash por un numero primo (31 tipicamente) mejora la
     * distribución de cantidades para evitar
     * colisiones (la escaza posibilidad de que dos objetos tengan el mismo hash
     * dentro de este contexto)
     * Se utiliza el valor absoluto para trabajar solo con numeros positivos
     */

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += 31 * this.puesto.hashCode();
        return Math.abs(result);
    }
}
