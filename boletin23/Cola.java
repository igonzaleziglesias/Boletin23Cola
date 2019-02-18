package boletin23;

import java.util.ArrayList;
import java.util.Queue;
import utilidades.pedirDatos;

public class Cola {

    private int tamaño;

    private Persona crearPersona() {
        return new Persona((int) (Math.random() * 56) + 5);
    }

    private void añadirPersona(Queue<Persona> cola) {
        cola.add(crearPersona());
    }

    public Cola(Queue<Persona> cola) throws ForaDeRangoException {

        this.tamaño = pedirDatos.enteiro("Tamaño de la cola(0-50 personas):");

        if ((tamaño < 0) || (tamaño > 50)) {
            throw new ForaDeRangoException("Cola fora dos parametros.");
        }

        for (int i = 0; i < tamaño; i++) {
            añadirPersona(cola);
        }
    }

    public float obtenerPrecio(Queue<Persona> cola) {

        float recaudacion = 0;

        if ((cola.peek().getIdade() >= 5) && (cola.peek().getIdade() <= 10)) {
            recaudacion = recaudacion + 1;
        } else if ((cola.peek().getIdade() >= 11) && (cola.peek().getIdade() <= 17)) {
            recaudacion = recaudacion + (float) 2.50;
        } else if (cola.peek().getIdade() >= 18) {
            recaudacion = recaudacion + (float) 3.50;
        }
        return recaudacion;
    }

    public float recaudacion(Queue<Persona> cola) {
        float recaudacion = 0;
        while (cola.peek() != null) {
            recaudacion = recaudacion + obtenerPrecio(cola);
            cola.poll();
        }
        return recaudacion;

    }

    public void amosarCola(Queue<Persona> cola) {

        for (Persona ele : cola) {
            System.out.println(ele);
        }
    }
}
