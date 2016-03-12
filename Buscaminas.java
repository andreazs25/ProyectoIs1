package minesweeper3;

public class Buscaminas {
	//Atributos
	private Tablero tablero;
	private static Buscaminas miBuscaminas = null;
	private BuilderTablero constructorTablero;
	
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
		if (pNivel == 1){
			this.constructorTablero = new BuilderTablero1();
			tablero = this.constructorTablero.construirTableroPorNivel();
		}
		else if (pNivel == 2){
			this.constructorTablero = new BuilderTablero2();
			tablero = this.constructorTablero.construirTableroPorNivel();
		}
		else{
			this.constructorTablero = new BuilderTablero3();
			tablero = this.constructorTablero.construirTableroPorNivel();
		}
	}
	
	public Tablero getTablero() {
	return this.tablero;
	}
}
