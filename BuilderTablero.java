package minesweeper3;

public abstract class BuilderTablero {
protected Tablero tablero;

	public BuilderTablero() {
	}

	public Tablero construirTableroPorNivel() {
		this.tablero = new Tablero();
		this.buildDimensionesTablero();
		this.inicializarTablero();
		return tablero;
	}

	public abstract void buildDimensionesTablero();



	// Coloca todas las minas, casillas vacias y con número independientemente
	// de su nivel
	public void inicializarTablero() {
		// 1.Coloca las minas dependiendo del numero de filas y columnas
		this.ponerMinas();
		// 2.Coloca el resto de casillas
		for (int f = 0; f < this.getTableroBuilder().getNumFilas(); f++) {
			for (int c = 0; c < this.getTableroBuilder().getNumColumnas(); c++) {
				// Si la casilla no tiene mina
				if (!(this.getTableroBuilder().getTablero()[f][c] instanceof CasillaConMina)) {
					// Obtenemos las casillas adyacentes
					int adj = this.obtenerAdyacentes(f, c);
					// Si no tiene minas adyacentes
					if (adj == 0) {
						this.getTableroBuilder().getTablero()[f][c] = FactoriaCasilla
								.getFactoriaCasilla().crearCasilla(0);
					}
					// Si tiene al menos una mina adyacente
					else {
						this.getTableroBuilder().getTablero()[f][c] = FactoriaCasilla
								.getFactoriaCasilla().crearCasilla(1);
						((CasillaConNumero) this.getTableroBuilder()
								.getTablero()[f][c]).setNumeroCasillasAdj(adj);
					}
				}
			}
		}
	}

	// Obtiene el numero de minas adyacentes que tiene una casilla
	private int obtenerAdyacentes(int f, int c) {
		int adj = 0;

		if (f == 0) {

			if (this.tablero.getTablero()[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}

			if (c == 0) {
				if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f + 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
			} else if (c == this.tablero.getNumColumnas() - 1) {

				if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f + 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			} else {
				if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f + 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f + 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			}
		}

		else if (f == this.tablero.getNumFilas() - 1) {

			if (this.tablero.getTablero()[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}

			if (c == 0) {
				if (this.tablero.getTablero()[f - 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
			} else if (c == this.tablero.getNumColumnas() - 1) {

				if (this.tablero.getTablero()[f - 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			} else {
				if (this.tablero.getTablero()[f - 1][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f - 1][c - 1] instanceof CasillaConMina) {
					adj++;
				}
				if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
					adj++;
				}
			}
		}

		else if (c == 0) {

			if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f - 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
		}

		else if (c == this.tablero.getNumColumnas() - 1) {

			if (this.tablero.getTablero()[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f - 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
		} else {
			if (this.tablero.getTablero()[f - 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c - 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f - 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f - 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f][c + 1] instanceof CasillaConMina) {
				adj++;
			}
			if (this.tablero.getTablero()[f + 1][c + 1] instanceof CasillaConMina) {
				adj++;
			}
		}

		return adj;
	}

	// Coloca minas en x lugares random independientemente del nivel
	private void ponerMinas() {
		for (int i = 0; i < this.tablero.getNumMinas(); i++) {
			int fila = ((int) (Math.random() * this.tablero.getNumFilas()));
			int columna = ((int) (Math.random() * this.tablero.getNumColumnas()));

			if (this.tablero.getTablero()[fila][columna] instanceof CasillaConMina) {
				i = i - 1;
			} else {
				this.tablero.getTablero()[fila][columna] = new CasillaConMina(
						fila + 1, columna + 1);
			}
		}
	}

	public void graficar() {

		for (int f = 0; f < this.tablero.getNumFilas(); f++) {
			System.out.println("");
			for (int c = 0; c < this.tablero.getNumColumnas(); c++) {
				System.out.print("[" + (f + 1) + "," + (c + 1) + "]");
				if (this.tablero.getTablero()[f][c] instanceof CasillaConMina) {
					System.out.print("-*-");
				}
				if (this.tablero.getTablero()[f][c] instanceof CasillaVacia) {
					System.out.print("-0-");
				}
				if (this.tablero.getTablero()[f][c] instanceof CasillaConNumero) {
					System.out
							.print("-"
									+ ((CasillaConNumero) this.tablero
											.getTablero()[f][c])
											.getNumeroCasillasAdj() + "-");
				}
			}
		}
	}

	public Casilla obtenerCasilla(int f, int c) {
		return this.tablero.getTablero()[f][c];
	}

	public Tablero getTableroBuilder() {
		return this.tablero;
	}

