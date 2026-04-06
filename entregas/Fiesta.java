import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Fiesta fiesta = new Fiesta("Cumpleaños de Carlos", "15/04/2025", "Salón Principal", 2);

        Invitado i1 = new Invitado("María López", "600123456");
        Invitado i2 = new Invitado("Pedro Sánchez", "600789012");
        Invitado i3 = new Invitado("Laura García", "600345678");

        fiesta.agregarInvitado(i1);
        fiesta.agregarInvitado(i2);
        fiesta.agregarInvitado(i3);

        fiesta.confirmarAsistencia(i1);
        fiesta.confirmarAsistencia(i2);
        fiesta.confirmarAsistencia(i3);

        fiesta.agregarArticulo(new ArticuloMenu("Bebida", "Refresco cola", 20, 1.5));
        fiesta.agregarArticulo(new ArticuloMenu("Comida", "Pizza", 15, 8.0));
        fiesta.agregarArticulo(new ArticuloMenu("Bebida", "Agua mineral", 30, 0.8));

        fiesta.mostrarResumen();

        System.out.println("Confirmados: " + fiesta.contarConfirmados());
    }
}

// 👇 ESTA CLASE NO ES PUBLIC
class Fiesta {
    private String nombre;
    private String fecha;
    private String lugar;
    private int aforo;

    private ArrayList<Invitado> invitados = new ArrayList<>();
    private ArrayList<ArticuloMenu> menu = new ArrayList<>();

    public Fiesta(String nombre, String fecha, String lugar, int aforo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.aforo = aforo;
    }

    public void agregarInvitado(Invitado invitado) {
        invitados.add(invitado);
    }

    public void confirmarAsistencia(Invitado invitado) {
        if (contarConfirmados() < aforo) {
            invitado.confirmar();
        } else {
            invitado.rechazar();
        }
    }

    public int contarConfirmados() {
        int contador = 0;
        for (Invitado i : invitados) {
            if (i.getEstado() == EstadoConfirmacion.CONFIRMADO) {
                contador++;
            }
        }
        return contador;
    }

    public void agregarArticulo(ArticuloMenu articulo) {
        menu.add(articulo);
    }

    public double calcularCosteTotal() {
        double total = 0;
        for (ArticuloMenu a : menu) {
            total += a.calcularSubtotal();
        }
        return total;
    }

    public void mostrarResumen() {
        System.out.println("Fiesta: " + nombre + " - " + fecha + " - " + lugar + " - Aforo: " + aforo);

        System.out.println("\nInvitados:");
        for (Invitado i : invitados) {
            System.out.println(i);
        }

        System.out.println("\nMenú:");
        for (ArticuloMenu a : menu) {
            System.out.println(a);
        }

        System.out.println("\nCoste total del menú: " + calcularCosteTotal() + "€");
    }
}

// ================= TU BLOQUE (INTOCABLE) =================

enum EstadoConfirmacion { PENDIENTE, CONFIRMADO, RECHAZADO }

public class Invitado {
    private String nombre;
    private String telefono;
    private EstadoConfirmacion estado;

    public Invitado(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = EstadoConfirmacion.PENDIENTE;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoConfirmacion getEstado() {
        return estado;
    }

    public void confirmar() {
        estado = EstadoConfirmacion.CONFIRMADO;
    }

    public void rechazar() {
        estado = EstadoConfirmacion.RECHAZADO;
    }

    public String toString() {
        return nombre + " - Tel: " + telefono + " - " + estado;
    }
}

public class ArticuloMenu {
    private String tipo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public ArticuloMenu(String tipo, String nombre, int cantidad, double precioUnitario) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public String toString() {
        return tipo + ": " + cantidad + " uds " + nombre + " ~ " + precioUnitario + " €/ud";
    }
}