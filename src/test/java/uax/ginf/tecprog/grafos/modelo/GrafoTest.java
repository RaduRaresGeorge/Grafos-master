package uax.ginf.tecprog.grafos.modelo;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase contiene pruebas unitarias para la clase Grafo.
 */
class GrafoTest {

    /**
     * Prueba para el constructor de Grafo.
     */
    @Test
    void testGrafoConstructor() {
        // Crear el grafo
        Grafo grafoNoDirigido = new Grafo(false);
        Grafo grafoDirigido = new Grafo(true);

        // Verificar que el grafo se ha inicializado correctamente
        assertNotNull(grafoNoDirigido.getAdyacencias());
        assertFalse(grafoNoDirigido.isEsDirigido());

        assertNotNull(grafoDirigido.getAdyacencias());
        assertTrue(grafoDirigido.isEsDirigido());
    }

    /**
     * Prueba para el método addVertice.
     */
    @Test
    void testAddVertice() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear un vértice
        Vertice v1 = new Vertice("v1", "dato");

        // Añadir el vértice al grafo
        grafo.addVertice(v1);

        // Verificar que el vértice se ha añadido correctamente
        assertTrue(grafo.getAdyacencias().containsKey(v1));
    }

    /**
     * Prueba para el método addAristaPeso.
     */
    @Test
    void testAddAristaPeso() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear vértices
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Añadir vértices al grafo
        grafo.addVertice(v1);
        grafo.addVertice(v2);

        // Añadir arista con peso entre vértices
        grafo.addAristaPeso(v1, v2, 2.0);

        // Verificar que la arista se ha añadido correctamente
        boolean aristaExiste = grafo.getAdyacencias().get(v1).stream()
                .anyMatch(arista -> arista.getDestino().equals(v2) && arista.getPeso() == 2.0);
        assertTrue(aristaExiste);
    }

    /**
     * Prueba para el método addArista.
     */
    @Test
    void testAddArista() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear vértices
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Añadir vértices al grafo
        grafo.addVertice(v1);
        grafo.addVertice(v2);

        // Añadir arista entre vértices
        grafo.addArista(v1, v2);

        // Verificar que la arista se ha añadido correctamente
        boolean aristaExiste = grafo.getAdyacencias().get(v1).stream()
                .anyMatch(arista -> arista.getDestino().equals(v2) && arista.getPeso() == 1.0);
        assertTrue(aristaExiste);
    }

    /**
     * Prueba para el método deleteArista.
     */
    @Test
    void testDeleteArista() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear vértices
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Añadir vértices al grafo
        grafo.addVertice(v1);
        grafo.addVertice(v2);

        // Añadir arista entre vértices
        grafo.addArista(v1, v2);

        // Verificar que la arista se ha añadido correctamente
        boolean aristaExiste = grafo.getAdyacencias().get(v1).stream()
                .anyMatch(arista -> arista.getDestino().equals(v2) && arista.getPeso() == 1.0);
        assertTrue(aristaExiste);

        // Eliminar la arista
        grafo.deleteArista(v1, v2);

        // Verificar que la arista se ha eliminado correctamente
        aristaExiste = grafo.getAdyacencias().get(v1).stream()
                .anyMatch(arista -> arista.getDestino().equals(v2));
        assertFalse(aristaExiste);
    }

    /**
     * Prueba para el método deleteVertice.
     */
    @Test
    void testDeleteVertice() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear vértices
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");

        // Añadir vértices al grafo
        grafo.addVertice(v1);
        grafo.addVertice(v2);

        // Añadir arista entre vértices
        grafo.addArista(v1, v2);

        // Verificar que el vértice v1 se ha añadido correctamente
        assertTrue(grafo.getAdyacencias().containsKey(v1));

        // Eliminar el vértice v1
        grafo.deleteVertice(v1);

        // Verificar que el vértice v1 se ha eliminado correctamente
        assertFalse(grafo.getAdyacencias().containsKey(v1));

        // Verificar que todas las aristas asociadas a v1 se han eliminado correctamente
        boolean aristaExiste = grafo.getAdyacencias().values().stream()
                .anyMatch(aristas -> aristas.stream()
                        .anyMatch(arista -> arista.getOrigen().equals(v1) || arista.getDestino().equals(v1)));
        assertFalse(aristaExiste);
    }

    /**
     * Prueba para el método getAdyacentes.
     */
    @Test
    void getAdyacentes() {
        // Crear el grafo
        Grafo grafo = new Grafo(false);

        // Crear vértices
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");
        Vertice v3 = new Vertice("v3", "dato");

        // Añadir vértices al grafo
        grafo.addVertice(v1);
        grafo.addVertice(v2);
        grafo.addVertice(v3);

        // Añadir aristas entre vértices
        grafo.addArista(v1, v2);
        grafo.addArista(v1, v3);

        // Obtener los vértices adyacentes a v1
        Set<Vertice> adyacentes = grafo.getAdyacentes(v1);

        // Verificar que los vértices adyacentes a v1 son v2 y v3
        assertTrue(adyacentes.contains(v2));
        assertTrue(adyacentes.contains(v3));
        assertEquals(2, adyacentes.size());
    }

    /**
     * Prueba para el método addVertice con un vértice existente.
     * Verifica que si se intenta agregar un vértice que ya existe en el grafo, el tamaño del grafo no cambia.
     */
    @Test
    void testAddVerticeWithExistingVertex() {
        Grafo grafo = new Grafo(false);
        Vertice v1 = new Vertice("v1", "dato");
        grafo.addVertice(v1);
        int sizeBefore = grafo.getAdyacencias().size();
        grafo.addVertice(v1);
        int sizeAfter = grafo.getAdyacencias().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    /**
     * Prueba para el método addAristaPeso con vértices no existentes.
     * Verifica que si se intenta agregar una arista entre dos vértices que no existen en el grafo, se lanza una excepción NullPointerException.
     */
    @Test
    void testAddAristaPesoWithNonExistingVertices() {
        Grafo grafo = new Grafo(false);
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");
        assertThrows(NullPointerException.class, () -> grafo.addAristaPeso(v1, v2, 2.0));
    }

    /**
     * Prueba para el método deleteArista con vértices no existentes.
     * Verifica que si se intenta eliminar una arista entre dos vértices que no existen en el grafo, no se lanza ninguna excepción.
     */
    @Test
    void testDeleteAristaWithNonExistingVertices() {
        Grafo grafo = new Grafo(false);
        Vertice v1 = new Vertice("v1", "dato");
        Vertice v2 = new Vertice("v2", "dato");
        assertDoesNotThrow(() -> grafo.deleteArista(v1, v2));
    }

    /**
     * Prueba para el método deleteVertice con un vértice no existente.
     * Verifica que si se intenta eliminar un vértice que no existe en el grafo, no se lanza ninguna excepción.
     */
    @Test
    void testDeleteVerticeWithNonExistingVertex() {
        Grafo grafo = new Grafo(false);
        Vertice v1 = new Vertice("v1", "dato");
        assertDoesNotThrow(() -> grafo.deleteVertice(v1));
    }

    /**
     * Prueba para el método getAdyacentes con un vértice no existente.
     * Verifica que si se intenta obtener los vértices adyacentes a un vértice que no existe en el grafo, se lanza una excepción NullPointerException.
     */
    @Test
    void testGetAdyacentesWithNonExistingVertex() {
        Grafo grafo = new Grafo(false);
        Vertice v1 = new Vertice("v1", "dato");
        assertThrows(NullPointerException.class, () -> grafo.getAdyacentes(v1));
    }
}