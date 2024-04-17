package uax.ginf.tecprog.grafos.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Arista.
 */
class AristaTest {

    /**
     * Prueba para el constructor de la clase Arista.
     * Verifica que los valores de origen, destino y peso se establezcan correctamente.
     */
    @Test
    void testAristaConstructor() {
        // Creación de vértices para la prueba
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Creación de la arista para la prueba
        Arista arista = new Arista(v1, v2, 2.0);

        // Verificación de que los valores se establecieron correctamente
        assertEquals(v1, arista.getOrigen());
        assertEquals(v2, arista.getDestino());
        assertEquals(2.0, arista.getPeso());
    }

    /**
     * Prueba para los métodos setter de la clase Arista.
     * Verifica que los valores de origen, destino y peso se puedan cambiar correctamente.
     */
    @Test
    void testAristaSetters() {
        // Creación de vértices para la prueba
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");
        Vertice v3 = new Vertice("v3", "dato");

        // Creación de la arista para la prueba
        Arista arista = new Arista(v1, v2, 2.0);

        // Cambio de los valores de origen, destino y peso
        arista.setOrigen(v3);
        arista.setDestino(v1);
        arista.setPeso(3.0);

        // Verificación de que los valores se cambiaron correctamente
        assertEquals(v3, arista.getOrigen());
        assertEquals(v1, arista.getDestino());
        assertEquals(3.0, arista.getPeso());
    }

    /**
     * Prueba para el método toString de la clase Arista.
     * Verifica que la representación en cadena de la arista sea la esperada.
     */
    @Test
    void testAristaToString() {
        // Creación de vértices para la prueba
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Creación de la arista para la prueba
        Arista arista = new Arista(v1, v2, 2.0);

        // Creación de la representación en cadena esperada
        String expected = "Arista{origen=" + v1 + ", destino=" + v2 + ", peso=2.0}";

        // Verificación de que la representación en cadena de la arista es la esperada
        assertEquals(expected, arista.toString());
    }
}