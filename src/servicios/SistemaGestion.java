package servicios;

import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class SistemaGestion {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<PaqueteTuristico> paquetes = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void agregarProveedor(Proveedor p) {
        proveedores.add(p);
    }

    public void agregarPaquete(PaqueteTuristico p) {
        paquetes.add(p);
    }

    public void crearReserva(Cliente c, PaqueteTuristico p) {
        Reserva r = new Reserva(c, p, new Date(), p.getPrecio());
        reservas.add(r);
    }

    public List<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
