package papeleria;

public abstract class Persona {

    protected String cedula;
    protected String nombre;

    public Persona(String cedula, String nombre) {

        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {

        return this.cedula;
    }

    public void setCedula(String cedula) {

        this.cedula = cedula;
    }

    public String getNombre() {

        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    // Sobreescritura de funciones:
    // Impresión de la forma canónica de la clase (características)
    @Override
    public String toString() {

        return String.format("Nombre: %s%nCedula: %s%n", this.nombre, this.cedula);
    }

    // Métodos de comparación de objetos:
    /*
     * Equals: Se compara cada atributo de los objetos, no sin antes, verificar que
     * el parámetro
     * no sean nulo o de diferente clase
     */
    @Override
    public boolean equals(Object object) {

        if (object == null || !(this.getClass() == object.getClass()))
            return false;
        Persona personaC = (Persona) object;
        return this.nombre.equals(personaC.nombre) && this.cedula.equals(personaC.cedula);
    }

    /*
     * HashCode: El hashCode del número de cédula es el identificador de cada objeto
     * de tipo Persona
     * La multipliacion de un hash por un numero primo (31 tipicamente) mejora la
     * distribución de cantidades para evitar
     * colisiones (la escaza posibilidad de que dos objetos tengan el mismo hash
     * dentro de este contexto)
     * Se utiliza el valor absoluto para trabajar solo con numeros positivos
     */
    @Override
    public int hashCode() {

        return Math.abs(this.cedula.hashCode());
    }
}