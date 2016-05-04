package minesweeper;

import java.util.Observable;

public class Tablero extends Observable {
	// Atributos
	private Casilla[][] casillas;
	private int numFilas;
	private int numColumnas;
	private int numMinas;
	private int numDesveladas;
	private int numMarcadas;

	// Constructor
	public Tablero(int pNumF, int pNumC, int pNumM) {
		this.casillas = new Casilla[pNumF][pNumC];
		this.numFilas = pNumF;
		this.numColumnas = pNumC;
		this.numMinas = pNumM;
		this.numDesveladas = 0;
		this.numMarcadas = 0;
	}

	// Métodos
	public Casilla obtenerCasilla(int pNumF, int pNumC) {
		return casillas[pNumF][pNumC];
	}

	// Obtiene el numero de minas adyacentes que tiene una casilla
	public int obtenerAdyacentes(int f, int c) {
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

	// En caso de descubrir casilla vacía, descubriremos las casillas vacías adyacentes
	private void descubrirCasillasAdy(int f, int c) {
		this.numDesveladas = this.numDesveladas + 1;
		this.casillas[f][c].descubrir();

		if (f == 0) {

			if (!casillas[f + 1][c].descubierta) {
				this.aumentarMarcados(f+1,c);
				if (casillas[f + 1][c] instanceof CasillaConNumero) {
					casillas[f + 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c);
				}
			}

			if (c == 0) {
				if (!casillas[f][c + 1].descubierta) {
					this.aumentarMarcados(f,c+1);
					if (casillas[f][c + 1] instanceof CasillaConNumero) {
						casillas[f][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c + 1);
					}
				}
				if (!casillas[f + 1][c + 1].descubierta) {
					this.aumentarMarcados(f+1,c+1);
					if (casillas[f + 1][c + 1] instanceof CasillaConNumero) {
						casillas[f + 1][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f + 1, c + 1);
					}
				}
			} else if (c == this.numColumnas - 1) {
				if (!casillas[f][c - 1].descubierta) {
					this.aumentarMarcados(f,c-1);
					if (casillas[f][c - 1] instanceof CasillaConNumero) {
						casillas[f][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c - 1);
					}
				}
				if (!casillas[f + 1][c - 1].descubierta) {
					this.aumentarMarcados(f+1,c-1);
					if (casillas[f + 1][c - 1] instanceof CasillaConNumero) {
						casillas[f + 1][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f + 1, c - 1);
					}
				}
			} else {
				if (!casillas[f][c + 1].descubierta) {
					this.aumentarMarcados(f,c+1);
					if (casillas[f][c + 1] instanceof CasillaConNumero) {
						casillas[f][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c + 1);
					}
				}

				if (!casillas[f + 1][c + 1].descubierta) {
					this.aumentarMarcados(f+1,c+1);
					if (casillas[f + 1][c + 1] instanceof CasillaConNumero) {
						casillas[f + 1][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f + 1, c + 1);
					}
				}

				if (!casillas[f][c - 1].descubierta) {
					this.aumentarMarcados(f,c-1);
					if (casillas[f][c - 1] instanceof CasillaConNumero) {
						casillas[f][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c - 1);
					}
				}

				if (!casillas[f + 1][c - 1].descubierta) {
					this.aumentarMarcados(f+1,c-1);
					if (casillas[f + 1][c - 1] instanceof CasillaConNumero) {
						casillas[f + 1][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f + 1, c - 1);
					}
				}
			}
		}

		else if (f == this.numFilas - 1) {
			if (!casillas[f - 1][c].descubierta) {
				this.aumentarMarcados(f-1,c);
				if (casillas[f - 1][c] instanceof CasillaConNumero) {
					casillas[f - 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c);
				}
			}

			if (c == 0) {
				if (!casillas[f - 1][c + 1].descubierta) {
					this.aumentarMarcados(f-1,c+1);
					if (casillas[f - 1][c + 1] instanceof CasillaConNumero) {
						casillas[f - 1][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f - 1, c + 1);
					}
				}
				if (!casillas[f][c + 1].descubierta) {
					this.aumentarMarcados(f,c+1);
					if (casillas[f][c + 1] instanceof CasillaConNumero) {
						casillas[f][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c + 1);
					}
				}
			} else if (c == this.numColumnas - 1) {
				
				if (!casillas[f - 1][c - 1].descubierta) {
					this.aumentarMarcados(f-1,c-1);
					if (casillas[f - 1][c - 1] instanceof CasillaConNumero) {
						casillas[f - 1][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f - 1, c - 1);
					}
				}
				if (!casillas[f][c - 1].descubierta) {
					this.aumentarMarcados(f,c-1);
					if (casillas[f][c - 1] instanceof CasillaConNumero) {
						casillas[f][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c - 1);
					}
				}
			} else {
				if (!casillas[f - 1][c + 1].descubierta) {
					this.aumentarMarcados(f-1,c+1);
					if (casillas[f - 1][c + 1] instanceof CasillaConNumero) {
						casillas[f - 1][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f - 1, c + 1);
					}
				}
				if (!casillas[f][c + 1].descubierta) {
					this.aumentarMarcados(f,c+1);
					if (casillas[f][c + 1] instanceof CasillaConNumero) {
						casillas[f][c + 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c + 1);
					}
				}
				if (!casillas[f - 1][c - 1].descubierta) {
					this.aumentarMarcados(f-1,c-1);
					if (casillas[f - 1][c - 1] instanceof CasillaConNumero) {
						casillas[f - 1][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f - 1, c - 1);
					}
				}
				if (!casillas[f][c - 1].descubierta) {
					this.aumentarMarcados(f,c-1);
					if (casillas[f][c - 1] instanceof CasillaConNumero) {
						casillas[f][c - 1].descubrir();
						this.numDesveladas = this.numDesveladas + 1;
					} else {
						this.descubrirCasillasAdy(f, c - 1);
					}
				}
			}
		}

		else if (c == 0) {
			if (!casillas[f][c + 1].descubierta) {
				this.aumentarMarcados(f,c+1);
				if (casillas[f][c + 1] instanceof CasillaConNumero) {
					casillas[f][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f, c + 1);
				}
			}
			if (!casillas[f - 1][c].descubierta) {
				this.aumentarMarcados(f-1,c);
				if (casillas[f - 1][c] instanceof CasillaConNumero) {
					casillas[f - 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c);
				}
			}
			if (!casillas[f - 1][c + 1].descubierta) {
				this.aumentarMarcados(f-1,c+1);
				if (casillas[f - 1][c + 1] instanceof CasillaConNumero) {
					casillas[f - 1][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c + 1);
				}
			}
			if (!casillas[f + 1][c].descubierta) {
				this.aumentarMarcados(f+1,c);
				if (casillas[f + 1][c] instanceof CasillaConNumero) {
					casillas[f + 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c);
				}
			}
			if (!casillas[f + 1][c + 1].descubierta) {
				this.aumentarMarcados(f+1,c+1);
				if (casillas[f + 1][c + 1] instanceof CasillaConNumero) {
					casillas[f + 1][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c + 1);
				}
			}
		}

		else if (c == this.numColumnas - 1) {
			if (!casillas[f - 1][c].descubierta) {
				this.aumentarMarcados(f-1,c);
				if (casillas[f - 1][c] instanceof CasillaConNumero) {
					casillas[f - 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c);
				}
			}
			if (!casillas[f - 1][c - 1].descubierta) {
				this.aumentarMarcados(f-1,c-1);
				if (casillas[f - 1][c - 1] instanceof CasillaConNumero) {
					casillas[f - 1][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c - 1);
				}
			}
			if (!casillas[f][c - 1].descubierta) {
				this.aumentarMarcados(f,c-1);
				if (casillas[f][c - 1] instanceof CasillaConNumero) {
					casillas[f][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f, c - 1);
				}
			}
			if (!casillas[f + 1][c - 1].descubierta) {
				this.aumentarMarcados(f+1,c-1);
				if (casillas[f + 1][c - 1] instanceof CasillaConNumero) {
					casillas[f + 1][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c - 1);
				}
			}
			if (!casillas[f + 1][c].descubierta) {
				this.aumentarMarcados(f+1,c);
				if (casillas[f + 1][c] instanceof CasillaConNumero) {
					casillas[f + 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c);
				}
			}
		} else {
			if (!casillas[f - 1][c - 1].descubierta) {
				this.aumentarMarcados(f-1,c-1);
				if (casillas[f - 1][c - 1] instanceof CasillaConNumero) {
					casillas[f - 1][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c - 1);
				}
			}
			if (!casillas[f][c - 1].descubierta) {
				this.aumentarMarcados(f,c-1);
				if (casillas[f][c - 1] instanceof CasillaConNumero) {
					casillas[f][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f, c - 1);
				}
			}
			if (!casillas[f + 1][c - 1].descubierta) {
				this.aumentarMarcados(f+1,c-1);
				if (casillas[f + 1][c - 1] instanceof CasillaConNumero) {
					casillas[f + 1][c - 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
					if (this.casillas[f+1][c-1].marcada){
						this.numMarcadas = this.numMarcadas -1;
					}
				} else {
					this.descubrirCasillasAdy(f + 1, c - 1);
				}
			}
			if (!casillas[f - 1][c].descubierta) {
				this.aumentarMarcados(f-1,c);
				if (casillas[f - 1][c] instanceof CasillaConNumero) {
					casillas[f - 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c);
				}
			}
			if (!casillas[f + 1][c].descubierta) {
				this.aumentarMarcados(f+1,c);
				if (casillas[f + 1][c] instanceof CasillaConNumero) {
					casillas[f + 1][c].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c);
				}
			}
			if (!casillas[f - 1][c + 1].descubierta) {
				this.aumentarMarcados(f-1,c+1);
				if (casillas[f - 1][c + 1] instanceof CasillaConNumero) {
					casillas[f - 1][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f - 1, c + 1);
				}
			}
			if (!casillas[f][c + 1].descubierta) {
				this.aumentarMarcados(f,c+1);
				if (casillas[f][c + 1] instanceof CasillaConNumero) {
					casillas[f][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f, c + 1);
				}
			}
			if (!casillas[f + 1][c + 1].descubierta) {
				this.aumentarMarcados(f+1,c+1);
				if (casillas[f + 1][c + 1] instanceof CasillaConNumero) {
					casillas[f + 1][c + 1].descubrir();
					this.numDesveladas = this.numDesveladas + 1;
				} else {
					this.descubrirCasillasAdy(f + 1, c + 1);
				}
			}
		}
	}

	// Descubre casilla en x posición
	// Si es con MINA --> PIERDES
	// Si se han descubierto todas las que no tienen minas --> GANAS
	// Si es con número --> SE DESCUBRE
	// Si es vacía --> SE DESCUBRE y se DESCUBREN LAS VACIAS ADYACENTES
	public void descubrirCasilla(int f, int c) {
		if (!this.casillas[f][c].marcada){
			String valor;
			if (this.casillas[f][c] instanceof CasillaConMina){
				valor = "perdido";
			}
			else if (this.casillas[f][c] instanceof CasillaVacia) {
				this.descubrirCasillasAdy(f, c);
				valor = "descubrirVacia";
			} else {
				this.numDesveladas = this.numDesveladas + 1;
				this.casillas[f][c].descubrir();
				valor = "descubrirNumero";
			}
			if (this.todasDescubiertas()){
				valor = "ganado";
				this.ganarPartida();
			}
			setChanged();
			notifyObservers(valor);
		}
	}
	
	private void aumentarMarcados(int f, int c){
		if (this.casillas[f][c].marcada){
			this.numMarcadas = this.numMarcadas -1;
		}
	}
	
	// La partida se ha ganado
	private void ganarPartida(){
		Sesion.getSesion().getJugador().setPuntMax(Sesion.getSesion().getNivel(), Sesion.getSesion().getPuntuacion());
		CatalogoJugadores.getCatalogoJugadores().guardarJugadores();
	}

	// Devuelve true en caso de que todas las casillas SIN minas esten descubiertas
	public boolean todasDescubiertas() {
		boolean todas = false;
		if ((this.numFilas * this.numColumnas) == this.numDesveladas + this.numMinas) {
			todas = true;
		}
		return todas;
	}

	// Marca/Desmarcar la carsilla que se indica
	public void marcarDesmarcarCasilla(int f, int c) {
		if (!this.obtenerCasilla(f, c).esDercubierta()){
			String valor;
			if (!this.obtenerCasilla(f, c).marcada){
				this.numMarcadas = this.numMarcadas + 1;
				this.obtenerCasilla(f, c).marcar();
				valor = "marcar";
			}
			else{
				this.obtenerCasilla(f, c).desmarcar();
				this.numMarcadas = this.numMarcadas - 1;
				valor = "desmarcar";
			}
			setChanged();
			notifyObservers(valor);
		}
	}
	
	// Pone casilla de tipo que queramos en la posicion que le indiquemos
	public void ponerCasillaEnPosicion(int pTipo, int fila, int columna) {
		this.casillas[fila][columna] = FactoriaCasilla.getFactoriaCasilla().crearCasilla(pTipo);
	}

	// Me indica si una casilla es mina
	public boolean esCasillaConMina(int fila, int columna) {
		boolean es = false;
		if (this.casillas[fila][columna] instanceof CasillaConMina) {
			es = true;
		}
		return es;
	}
	
	public int getNumMinas() {
		return this.numMinas;
	}

	public int getNumFilas() {
		return this.numFilas;
	}

	public int getNumColumnas() {
		return this.numColumnas;
	}

	public int getNumDesveladas() {
		return this.numDesveladas;
	}

	public int getNumMarcadas() {
		return this.numMarcadas;
	}
}
