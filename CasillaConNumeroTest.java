package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.Casilla;
import minesweeper3.CasillaConNumero;
import minesweeper3.FactoriaCasilla;

public class CasillaConNumeroTest {
	
	private CasillaConNumero casillaNumero;
	
	@Before
	public void setUp() throws Exception {
		casillaNumero = new CasillaConNumero();
	}

	@After
	public void tearDown() throws Exception {
		casillaNumero = null;
	}

	/**@Test
	public void testDescubrir() {
		fail("Not yet implemented");
	}
	**/
	@Test
	public void testCasillaConNumero() {
		assertTrue(casillaNumero instanceof CasillaConNumero);
	}

	@Test
	public void testSetNumeroCasillasAdj() {
		casillaNumero.setNumeroCasillasAdj(2);
		assertEquals(casillaNumero.getNumeroCasillasAdj(), 2);
	}

	@Test
	public void testGetNumeroCasillasAdj() {
		// Probamos que se ha inicializado el atributo a 0
		assertEquals(casillaNumero.getNumeroCasillasAdj(), 0);
		// Le cambiamos el valor y lo probamos
		casillaNumero.setNumeroCasillasAdj(2);
		assertEquals(casillaNumero.getNumeroCasillasAdj(), 2);
	}

}
