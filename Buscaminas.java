package minesweeper;

public class Buscaminas {
	//Atributos
	private Tablero tablero;
	private static Buscaminas miBuscaminas = null;
	
	//Constructor
	private Buscaminas(){}
	
	//Métodos
	public static Buscaminas getBuscaminas(){
		if (miBuscaminas==null){
			miBuscaminas= new Buscaminas();
		}
		return miBuscaminas;
	}
	
	public void construirTableroPorNivel(int pNivel){
			this.tablero = DirectorTablero.getDirectorTablero().getTablero(pNivel);
	}
	
	public Tablero getablero(){
		return this.tablero;
	}
	
	public void descubrirCasilla(int pF, int pC){
		this.tablero.descubrirCasilla(pF, pC);
	}
	
	public void marcarDesmarcarCasilla(int pF, int pC){
		this.tablero.marcarDesmarcarCasilla(pF, pC);
	}
	
	public Casilla obtenerCasilla(int pF, int pC){
		return this.getablero().obtenerCasilla(pF, pC);
	}
}
