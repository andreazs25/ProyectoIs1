package minesweeper;

public class Casilla {
	// Atributos
	protected boolean descubierta;
	protected boolean marcada;

	// Constructor
	public Casilla() {
		this.descubierta = false;
		this.marcada = false;
	}

	// Métodos
	public void descubrir() {
		this.descubierta = true;
	}
	public boolean esDercubierta(){
		return this.descubierta;
	}
	
	public void marcar() {
		this.marcada = true;
	}
	public boolean esMarcada(){
		return this.marcada;
	}

	public void desmarcar() {
		this.marcada = false;
		
	}
}
