package minesweeper3;


public class Tablero {
	// Atributos
	private Casilla[][] casillas;
	private int numColumnas;
	private int numFilas;
	private int numMinas;
	private int numDesveladas;

	// Constructor
	public Tablero() {
		this.numDesveladas = 0;
	}

	// Métodos
	public void setDimensionesTablero(int pNumF, int pNumC, int pNumM) {
		this.casillas = new Casilla[pNumF][pNumC];
		this.numFilas = pNumF;
		this.numColumnas = pNumC;
		this.numMinas = pNumM;
	}

	public Casilla obtenerCasilla(int pNumF, int pNumC) {
		return casillas[pNumF][pNumC];
	}

	public void inicializarTablero(){
		//1.Coloca las minas dependiendo del numero de filas y columnas
		this.ponerMinas();	
		//2.Coloca el resto de casillas
		for (int f=0; f<this.numFilas; f++){
			for (int c=0; c<this.numColumnas; c++){
				//Si la casilla no tiene mina
				if (!(this.casillas[f][c] instanceof CasillaConMina)){
					//Obtenemos las casillas adyacentes
					int adj = this.obtenerAdyacentes(f,c);
					//Si no tiene minas adyacentes
					if (adj==0){
						this.casillas[f][c]= FactoriaCasilla.getFactoriaCasilla().crearCasilla(0);
					}
					//Si tiene al menos una mina adyacente
					else{
						this.casillas[f][c]= FactoriaCasilla.getFactoriaCasilla().crearCasilla(1);
						((CasillaConNumero)casillas[f][c]).setNumeroCasillasAdj(adj);
					}
				}
			}
		}
	}

	// Obtiene el numero de minas adyacentes que tiene una casilla
	private int obtenerAdyacentes(int f, int c) {
		int adj = 0;

		if (f == 0) {

			if (casillas[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}

			if (c == 0) {
				if (casillas[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f + 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
			} else if (c == this.numColumnas - 1) {

				if (casillas[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f + 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			} else {
				if (casillas[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f + 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f + 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			}
		}

		else if (f == this.numFilas - 1) {

			if (casillas[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}

			if (c == 0) {
				if (casillas[f - 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
			} else if (c == this.numColumnas - 1) {

				if (casillas[f - 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			} else {
				if (casillas[f - 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f - 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (casillas[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			}
		}

		else if (c == 0) {

			if (casillas[f][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f - 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
		}

		else if (c == this.numColumnas - 1) {

			if (casillas[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f - 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
		} else {
			if (casillas[f - 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f - 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (casillas[f + 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
		}
		return adj;
	}

	// Coloca minas en x lugares random independientemente del nivel
	private void ponerMinas() {
		for (int i = 0; i < this.numMinas; i++) {
			int fila = ((int) (Math.random() * this.numFilas));
			int columna = ((int) (Math.random() * this.numColumnas));

			if (this.casillas[fila][columna] instanceof CasillaConMina) {
				i = i - 1;
			} else {
				this.casillas[fila][columna] = FactoriaCasilla.getFactoriaCasilla().crearCasilla(2);
			}
		}
	}

	// En caso de descubrir casilla vacía, descubriremos las casillas vacías
	// adyacentes
	private void descubrirCasillasAdy(int f, int c) {
		this.casillas[f][c].descubrir();
	}

	// Descubre casilla en x posición
	// Si es con MINA --> PIERDES
	// Si se han descubierto todas las que no tienen minas --> GANAS
	// Si es con número --> SE DESCUBRE
	// Si es vacía --> SE DESCUBRE y se DESCUBREN LAS VACIAS ADYACENTES
	public void descubrirCasilla(int f, int c) {
		this.numDesveladas = this.numDesveladas + 1;
		if (this.casillas[f][c] instanceof CasillaConMina) {
			// this.finFracaso();
		} else if (this.todasDescubiertas()) {
			// this.finExito();
		} else {
			if (this.casillas[f][c] instanceof CasillaVacia) {
				this.descubrirCasillasAdy(f, c);
			} else {
				this.casillas[f][c].descubrir();
			}
		}
	}

	// Devuelve true en caso de que todas las casillas SIN minas esten
	// descubiertas
	private boolean todasDescubiertas() {
		boolean todas = false;
		if ((this.numFilas*this.numColumnas) == this.numDesveladas + this.numMinas) {
			todas = true;
		}
		return todas;
	}
	
	public void graficar(){
		
		for (int f=0; f<this.numFilas; f++){
			System.out.println("");
			for (int c=0; c<this.numColumnas; c++){
				System.out.print("["+(f+1)+","+(c+1)+"]");
				if(casillas[f][c] instanceof CasillaConMina){
				System.out.print("-*-");
				}
				if(casillas[f][c] instanceof CasillaVacia){
				System.out.print("-0-");
				}
				if(casillas[f][c] instanceof CasillaConNumero){
				System.out.print("-"+((CasillaConNumero) casillas[f][c]).getNumeroCasillasAdj()+"-");
				}
			}
		}
	}

	/**
	 * //En caso de descubrir todas las casillas que no son minas, ganamos
	 * public void finExito(){ System.out.print("Has ganado"); }
	 * 
	 * //Cuando se pierde al descubrir casilla con mina public void
	 * finFracaso(){ System.out.print("Has perdido"); }
	 **/
}
