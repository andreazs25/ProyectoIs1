package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.Casilla;
import minesweeper3.CasillaConMina;
import minesweeper3.FactoriaCasilla;

public class CasillaConMinaTest {
	
	private Casilla casillaMina;

	@Before
	public void setUp() throws Exception {
		casillaMina = FactoriaCasilla.getFactoriaCasilla().crearCasilla(2);
	}

	@After
	public void tearDown() throws Exception {
		casillaMina = null;
	}

	/**@Test
	public void testDescubrir() {
		fail("Not yet implemented");
	}
	**/
	@Test
	public void testCasillaConMina() {
		assertTrue(casillaMina instanceof CasillaConMina);
	}

}
