package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.Casilla;

public class CasillaTest {

	private Casilla casilla;
	
	@Before
	public void setUp() throws Exception {
		casilla = new Casilla();
	}

	@After
	public void tearDown() throws Exception {
		casilla = null;
	}

	@Test
	public void testCasilla() {
		assertNotNull(casilla);
	}

	/**@Test
	public void testDescubrir() {
		casilla.descubrir();
		
	}
	**/
}
