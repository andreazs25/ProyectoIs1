package minesweeper;

public class BuilderTablero1 extends BuilderTablero {

	public BuilderTablero1() {
	}

	@Override
	public void buildDimensionesTablero() {
		this.tablero = new Tablero(7, 10, 10);
	}
}
