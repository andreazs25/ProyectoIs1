package minesweeper;

public class DirectorTablero {
	private static DirectorTablero miDirectorTablero = null;
	private BuilderTablero builder;
	
	private DirectorTablero(){}
	
	public static DirectorTablero getDirectorTablero(){
		if (miDirectorTablero==null){
			miDirectorTablero= new DirectorTablero();
		}
		return miDirectorTablero;
	}
	
	public Tablero getTablero(int pNivel){
		if (pNivel == 1){
			this.builder = new BuilderTablero1();
		}
		else if (pNivel == 2){
			this.builder = new BuilderTablero2();
		}
		else{
			this.builder = new BuilderTablero3();
		}
		this.construirTablero();
		return this.builder.getTablero();
	}
	
	private void construirTablero(){
		this.builder.buildDimensionesTablero();
		this.builder.ponerMinas();
		this.builder.ponerRestoCasillas();
	}
}
