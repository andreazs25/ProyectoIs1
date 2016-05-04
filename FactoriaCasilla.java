package minesweeper;

public class FactoriaCasilla {
	private static FactoriaCasilla miFactoriaCasilla = null;
	
	private FactoriaCasilla(){}
	
	//Métodos
	public static FactoriaCasilla getFactoriaCasilla(){
		if (miFactoriaCasilla==null){
			miFactoriaCasilla= new FactoriaCasilla();
		}
		return miFactoriaCasilla;
	}
	
	public Casilla crearCasilla(int pTipo){
		Casilla casilla;
		if (pTipo == 0){
			casilla = new CasillaVacia();
		}
		else if (pTipo == 1){
			casilla = new CasillaConNumero();
		}
		else{
			casilla = new CasillaConMina();
		}
		return casilla;
	}
}
