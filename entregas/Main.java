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
    }
}
