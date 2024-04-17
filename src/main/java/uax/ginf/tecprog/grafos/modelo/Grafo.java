package uax.ginf.tecprog.grafos.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase representa una estructura de datos de Grafo.
 * Contiene métodos para agregar y eliminar vértices y aristas (con o sin peso),
 * y para obtener vértices adyacentes a un vértice dado.
 */
public class Grafo {
    private Map<Vertice, Set<Arista>> adyacencias;  // Mapa de adyacencias para almacenar las aristas de cada vértice
    private boolean esDirigido; // Indica si el grafo es dirigido o no

    /**
     * Constructor para la clase Grafo.
     * @param esDirigido un booleano que indica si el grafo es dirigido o no.
     */
    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.adyacencias = new HashMap<>();
    }

    /**
     * Agrega un vértice al grafo.
     * @param vertice el vértice a agregar.
     */
    public void addVertice(Vertice vertice) {
        adyacencias.putIfAbsent(vertice, new HashSet<>()); // Si el vértice no existe, lo añade
    }

    /**
     * Agrega una arista ponderada entre dos vértices en el grafo.
     * @param origen el vértice de origen.
     * @param destino el vértice de destino.
     * @param peso el peso de la arista.
     */
    public void addAristaPeso(Vertice origen, Vertice destino, double peso) {
        adyacencias.get(origen).add(new Arista(origen, destino, peso)); // Añade la arista al vértice de origen
        if(!esDirigido) {   // Si el grafo no es dirigido, añade la arista al vértice de destino
            adyacencias.get(destino).add(new Arista(destino, origen, peso));    // Añade la arista al vértice de destino
        }
    }

    /**
     * Agrega una arista entre dos vértices en el grafo. El peso de la arista es 1.0.
     * @param origen el vértice de origen.
     * @param destino el vértice de destino.
     */
    public void addArista(Vertice origen, Vertice destino ) {
        this.addAristaPeso(origen, destino, 1.0);   // Añade la arista con peso 1.0
    }

    /**
     * Elimina una arista entre dos vértices en el grafo.
     * @param origen el vértice de origen.
     * @param destino el vértice de destino.
     */
    public void deleteArista(Vertice origen, Vertice destino) { // Elimina la arista entre los vértices origen y destino
        Set<Arista> aristasOrigen = adyacencias.get(origen);    // Obtiene las aristas del vértice origen
        if (aristasOrigen != null) {    // Si existen aristas
            aristasOrigen.removeIf(arista -> arista.getDestino().equals(destino));  // Elimina la arista
        }

        if (!esDirigido) {  // Si el grafo no es dirigido
            Set<Arista> aristasDestino = adyacencias.get(destino);  // Obtiene las aristas del vértice destino
            if (aristasDestino != null) {   // Si existen aristas
                aristasDestino.removeIf(arista -> arista.getOrigen().equals(origen));   // Elimina la arista
            }
        }
    }

    /**
     * Devuelve un conjunto de vértices adyacentes a un vértice dado.
     * @param vertice el vértice.
     * @return un conjunto de vértices adyacentes al vértice dado.
     */
    public Set<Vertice> getAdyacentes(Vertice vertice) {
        Set<Vertice> adyacentes = new HashSet<>();
        for (Arista arista : adyacencias.get(vertice)) {
            adyacentes.add(arista.getDestino());
        }
        return adyacentes;
    }

    /**
     * Elimina un vértice y todas sus aristas asociadas del grafo.
     * @param vertice el vértice a eliminar.
     */
    public void deleteVertice(Vertice vertice) {
        adyacencias.remove(vertice);

        for (Set<Arista> aristas : adyacencias.values()) {
            aristas.removeIf(arista -> arista.getOrigen().equals(vertice) || arista.getDestino().equals(vertice));
        }
    }

    /**
     * Devuelve una representación de cadena del grafo.
     * @return una representación de cadena del grafo.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for( Map.Entry<Vertice, Set<Arista>> entry : adyacencias.entrySet() ){
            for( Arista arista : entry.getValue()) {
                builder.append(arista.getOrigen().getId())
                        .append(" -> ")
                        .append(arista.getDestino().getId())
                        .append(" [")
                        .append(arista.getPeso())
                        .append("]\n");
            }
        }
        return builder.toString();
    }

    /**
     * Devuelve el mapa de adyacencia del grafo.
     * @return el mapa de adyacencia del grafo.
     */
    public Map<Vertice, Set<Arista>> getAdyacencias() {
        return adyacencias;
    }

    /**
     * Devuelve si el grafo es dirigido o no.
     * @return verdadero si el grafo es dirigido, falso en caso contrario.
     */
    public boolean isEsDirigido() {
        return esDirigido;
    }
}