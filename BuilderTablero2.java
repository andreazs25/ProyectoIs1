package minesweeper;

public class BuilderTablero2 extends BuilderTablero {

	public BuilderTablero2() {
	}

	@Override
	public void buildDimensionesTablero() {
		this.tablero = new Tablero(10, 15, 30);
	}
}
