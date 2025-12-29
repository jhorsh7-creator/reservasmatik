package modelo;

public class Cliente {

    private int id;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    public Cliente(int id, String nombre, String dni, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nombre + " - " + dni;
    }
}
