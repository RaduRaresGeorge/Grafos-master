package uax.ginf.tecprog.grafos.modelo;

/**
 * La clase Arista representa una arista en un grafo.
 * Cada arista tiene un vértice de origen, un vértice de destino y un peso.
 */
public class Arista {
    private Vertice origen; // Vértice de origen de la arista
    private Vertice destino; // Vértice de destino de la arista
    private double peso; // Peso de la arista

    /**
     * Constructor para crear una nueva arista con peso predeterminado de 1.0.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     */
    public Arista(Vertice origen, Vertice destino) {
        this(origen, destino, 1.0);
    }

    /**
     * Constructor para crear una nueva arista con peso especificado.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     * @param peso El peso de la arista.
     */
    public Arista(Vertice origen, Vertice destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Devuelve una representación en cadena de esta arista.
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Arista{" +
                "origen=" + origen +
                ", destino=" + destino +
                ", peso=" + peso +
                '}';
    }

    /**
     * Obtiene el vértice de origen de esta arista.
     * @return El vértice de origen.
     */
    public Vertice getOrigen() {
        return origen;
    }

    /**
     * Establece el vértice de origen de esta arista.
     * @param origen El nuevo vértice de origen.
     */
    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el vértice de destino de esta arista.
     * @return El vértice de destino.
     */
    public Vertice getDestino() {
        return destino;
    }

    /**
     * Establece el vértice de destino de esta arista.
     * @param destino El nuevo vértice de destino.
     */
    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el peso de esta arista.
     * @return El peso.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de esta arista.
     * @param peso El nuevo peso.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
}