package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.BuilderTablero;
import minesweeper3.Buscaminas;
import minesweeper3.Casilla;
import minesweeper3.Tablero;

public class TableroTest {
	
	private Tablero tablero;
	

	@Before
	public void setUp() throws Exception {
		tablero = new Tablero();
	}

	@After
	public void tearDown() throws Exception {
		tablero = null;
	}

	@Test
	public void testTablero() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertEquals(tablero.getNumColumnas(),10);
	}

	@Test
	public void testSetDimensionesTablero() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertEquals(tablero.getNumFilas(),7);
		assertEquals(tablero.getNumColumnas(),10);
	}

	@Test
	public void testObtenerCasilla() {
		tablero.setDimensionesTablero(7, 10, 10);
		Casilla casilla = tablero.obtenerCasilla(1, 2);
		assertNull(casilla);
	}

	@Test
	public void testGetNumColumnas() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertEquals(tablero.getNumColumnas(),10);
	}

	@Test
	public void testGetNumFilas() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertEquals(tablero.getNumFilas(),7);
	}

	@Test
	public void testGetNumMinas() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertEquals(tablero.getNumMinas(),10);
	}

	@Test
	public void testGetTablero() {
		tablero.setDimensionesTablero(7, 10, 10);
		assertNotNull(tablero.getTablero());
	}

	// No se pueden probar los siguientes metodos porque no estan completos 
	/**@Test
	public void testDescubrirCasilla() {
		tablero = Buscaminas.getBuscaminas().getTablero();
		tablero.descubrirCasilla(1, 2);
		assertTrue(tablero.obtenerCasilla(1, 2).estaDescubierta());
	}
	
	@Test
	public void testDescubrirCasillasAdj1() {
		fail("Not yet implemented");
	}
	**/
}
