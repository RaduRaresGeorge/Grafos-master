package uax.ginf.tecprog.grafos.modelo;

import java.util.Objects;

/**
 * La clase Vertice representa un vértice en un grafo.
 * Cada vértice tiene un identificador único y un dato asociado.
 */
public class Vertice {
    private String id; // Identificador único para el vértice
    private Object dato; // Permite almacenar la info asociada al vértice

    /**
     * Constructor para crear un nuevo vértice.
     * @param id El identificador único del vértice.
     * @param dato El dato asociado al vértice.
     */
    public Vertice(String id, Object dato) {
        this.id = id;
        this.dato = dato;
    }

    /**
     * Comprueba si este vértice es igual a otro objeto.
     * @param o El objeto con el que comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(id, vertice.id);
    }

    /**
     * Genera un hashcode para este vértice.
     * @return El hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, dato);
    }

    /**
     * Devuelve una representación en cadena de este vértice.
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Vertice{" +
                "id='" + id + '\'' +
                ", dato=" + dato +
                '}';
    }

    /**
     * Obtiene el identificador de este vértice.
     * @return El identificador.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de este vértice.
     * @param id El nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el dato asociado a este vértice.
     * @return El dato.
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Establece el dato asociado a este vértice.
     * @param dato El nuevo dato.
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }
}