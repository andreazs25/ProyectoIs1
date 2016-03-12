package pruebasMinesweeper;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import minesweeper3.Casilla;
import minesweeper3.CasillaConMina;
import minesweeper3.CasillaConNumero;
import minesweeper3.CasillaVacia;
import minesweeper3.FactoriaCasilla;

public class FactoriaCasillaTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFactoriaCasilla() {
		assertNotNull(FactoriaCasilla.getFactoriaCasilla());
	}

	@Test
	public void testCrearCasilla() {
		assertTrue(FactoriaCasilla.getFactoriaCasilla().crearCasilla(0) instanceof CasillaVacia);
		assertTrue(FactoriaCasilla.getFactoriaCasilla().crearCasilla(1) instanceof CasillaConNumero);
		assertTrue(FactoriaCasilla.getFactoriaCasilla().crearCasilla(2) instanceof CasillaConMina);
	}

}
