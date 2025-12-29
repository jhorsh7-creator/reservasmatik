package modelo;

import java.util.Date;

public class Reserva {

    private int id;
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private Date fecha;
    private double total;

    public Reserva(Cliente cliente, PaqueteTuristico paquete, Date fecha, double total) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.fecha = fecha;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }
}
