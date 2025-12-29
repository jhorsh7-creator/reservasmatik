package modelo;

public class PaqueteTuristico {

    private int id;
    private String nombre;
    private int dias;
    private double precio;
    private String guia;
    private String transportista;

    public PaqueteTuristico(int id, String nombre, int dias, double precio,
                            String guia, String transportista) {
        this.id = id;
        this.nombre = nombre;
        this.dias = dias;
        this.precio = precio;
        this.guia = guia;
        this.transportista = transportista;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDias() {
        return dias;
    }

    public double getPrecio() {
        return precio;
    }

    public String getGuia() {
        return guia;
    }

    public String getTransportista() {
        return transportista;
    }

    // 🔥 ESTE ES EL ÚNICO toString QUE DEBE EXISTIR
    @Override
    public String toString() {
        return nombre + " (" + dias + " días) - S/ " + precio +
                " | Guía: " + guia +
                " | Transporte: " + transportista;
    }
}
