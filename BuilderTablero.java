package minesweeper;

public abstract class BuilderTablero {
	protected Tablero tablero;
	
	public BuilderTablero(){}

	public Tablero getTablero(){
		return this.tablero;
	}
	
	// Coloca minas en x lugares random independientemente del nivel
	public void ponerMinas(){
		for (int i = 0; i < this.tablero.getNumMinas(); i++) {
			int fila = ((int) (Math.random() * this.tablero.getNumFilas()));
			int columna = ((int) (Math.random() * this.tablero.getNumColumnas()));

			if ((this.tablero.esCasillaConMina(fila, columna))) {
				i = i - 1;
			} else {
				this.tablero.ponerCasillaEnPosicion(2, fila, columna);
			}
		}
	}
	
	//Coloca el resto de casillas
	public void ponerRestoCasillas(){
		for (int f=0; f<this.tablero.getNumFilas(); f++){
			for (int c=0; c<this.tablero.getNumColumnas(); c++){
				//Si la casilla no tiene mina
				if (!this.tablero.esCasillaConMina(f, c)){
					//Obtenemos las casillas adyacentes
					int adj = this.tablero.obtenerAdyacentes(f,c);
					//Si no tiene minas adyacentes
					if (adj==0){
						this.tablero.ponerCasillaEnPosicion(0, f, c);
					}
					//Si tiene al menos una mina adyacente
					else{
						this.tablero.ponerCasillaEnPosicion(1, f, c);
						((CasillaConNumero)this.tablero.obtenerCasilla(f,c)).setNumeroCasillasAdj(adj);
					}
				}
			}
		}
	}
	
	public abstract void buildDimensionesTablero();
}