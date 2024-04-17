package uax.ginf.tecprog.grafos.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase contiene pruebas unitarias para la clase Vertice.
 */
class VerticeTest {

    /**
     * Esta prueba verifica el constructor de Vertice.
     * Crea un nuevo objeto Vertice y afirma que los campos id y dato se establecen correctamente.
     */
    @Test
    void testVerticeConstructor() {
        Vertice vertice = new Vertice("v1", "dato");

        assertEquals("v1", vertice.getId());
        assertEquals("dato", vertice.getDato());
    }

    /**
     * Esta prueba verifica los setters de la clase Vertice.
     * Crea un nuevo objeto Vertice, cambia sus campos id y dato usando los setters,
     * y afirma que los campos se han actualizado correctamente.
     */
    @Test
    void testVerticeSetters() {
        Vertice vertice = new Vertice("v1", "dato");

        vertice.setId("v2");
        vertice.setDato("newDato");

        assertEquals("v2", vertice.getId());
        assertEquals("newDato", vertice.getDato());
    }

    /**
     * Esta prueba verifica el método toString de la clase Vertice.
     * Crea un nuevo objeto Vertice y afirma que la representación de cadena del objeto es correcta.
     */
    @Test
    void testVerticeToString() {
        Vertice vertice = new Vertice("v1", "dato");

        String expected = "Vertice{id='v1', dato=dato}";
        assertEquals(expected, vertice.toString());
    }

    /**
     * Esta prueba verifica el método equals de la clase Vertice.
     * Crea tres objetos Vertice, dos con el mismo id y dato, y uno con un id diferente.
     * Afirma que los dos primeros objetos son iguales y que el primer y tercer objeto no son iguales.
     */
    @Test
    void testVerticeEquals() {
        Vertice vertice1 = new Vertice("v1", "dato");
        Vertice vertice2 = new Vertice("v1", "dato");
        Vertice vertice3 = new Vertice("v2", "dato");

        assertEquals(vertice1, vertice2);
        assertNotEquals(vertice1, vertice3);
    }
}