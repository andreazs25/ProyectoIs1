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

	public int getNumColumnas() {
		return numColumnas;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public int getNumMinas() {
		return numMinas;
	}

	public Casilla[][] getTablero() {
		return casillas;
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
		if ((this.numFilas * this.numColumnas) == this.numDesveladas
				+ this.numMinas) {
			todas = true;
		}
		return todas;
	}

	public void graficar() {

		for (int f = 0; f < this.numFilas; f++) {
			System.out.println("");
			for (int c = 0; c < this.numColumnas; c++) {
				System.out.print("[" + (f + 1) + "," + (c + 1) + "]");
				if (casillas[f][c] instanceof CasillaConMina) {
					System.out.print("-*-");
				}
				if (casillas[f][c] instanceof CasillaVacia) {
					System.out.print("-0-");
				}
				if (casillas[f][c] instanceof CasillaConNumero) {
					System.out.print("-"
							+ ((CasillaConNumero) casillas[f][c])
									.getNumeroCasillasAdj() + "-");
				}
			}
		}
	}

	public void descubrirCasillasAdj1(int f, int c) {

		this.descubrirCasillasAdj(f, c);
	}

	// En caso de descubrir casilla vacía, descubriremos las casillas vacías
	// adyacentes
	private void descubrirCasillasAdj(int f, int c) {

		if (this.getTablero()[f][c] instanceof CasillaVacia) {
			if (f - 1 > 0) {
				descubrirCasillasAdj(f - 1, c);
			} else if (c + 1 <= this.getNumColumnas() && f - 1 > 0) {
				descubrirCasillasAdj(f - 1, c + 1);

			} else if (c + 1 <= this.getNumColumnas()) {
				descubrirCasillasAdj(f, c + 1);

			} else if (f + 1 <= this.getNumFilas()
					&& c + 1 <= this.getNumColumnas()) {
				descubrirCasillasAdj(f + 1, c + 1);
			} else if (f + 1 <= this.getNumFilas()) {
				descubrirCasillasAdj(f + 1, c);
			} else if (f + 1 <= this.getNumFilas() && c - 1 > 0) {
				descubrirCasillasAdj(f + 1, c - 1);

			} else if (c - 1 > 0) {
				descubrirCasillasAdj(f, c - 1);
			} else if (f - 1 > 0 && c - 1 > 0) {
				descubrirCasillasAdj(f - 1, c - 1);
			}
			System.out.println("soyVacia");

		} else if (this.getTablero()[f][c] instanceof CasillaConNumero) {
			System.out.println("soy numero");
		} else {
			System.out.println("soy mina");
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

