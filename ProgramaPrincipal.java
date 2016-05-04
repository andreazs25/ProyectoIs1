package minesweeper;

import ventanasProyecto.VentanaInicial;
import ventanasProyecto.VentanaRanking;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		CatalogoJugadores.getCatalogoJugadores().cargarJugadores();
		new VentanaInicial();
	}
}
