package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.Casilla;
import minesweeper3.CasillaVacia;
import minesweeper3.FactoriaCasilla;

public class CasillaVaciaTest {
	
	private Casilla vacia;

	@Before
	public void setUp() throws Exception {
		vacia = FactoriaCasilla.getFactoriaCasilla().crearCasilla(0);
	}

	@After
	public void tearDown() throws Exception {
		vacia = null;
	}

	/**@Test
	public void testDescubrir() {
		fail("Not yet implemented");
	}
	**/
	@Test
	public void testCasillaVacia() {
		assertTrue(vacia instanceof CasillaVacia);
	}

}
