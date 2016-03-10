package minesweeper3;

public abstract class BuilderTablero {
	
	public BuilderTablero(){}

	public Tablero construirTableroPorNivel() {
		Tablero tablero = new Tablero();
		this.buildDimensionesTablero(tablero);
		tablero.inicializarTablero();
		return tablero;
	}

	public abstract void buildDimensionesTablero(Tablero tablero);
}