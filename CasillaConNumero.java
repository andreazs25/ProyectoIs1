package minesweeper;

public class CasillaConNumero extends Casilla {
	private int numeroCasillasAdj;

	public CasillaConNumero() {
		this.numeroCasillasAdj = 0;
	}

	@Override
	public void descubrir() {
		super.descubrir();
	}

	public void setNumeroCasillasAdj(int pNumero) {
		this.numeroCasillasAdj = pNumero;
	}

	public int getNumeroCasillasAdj() {
		return this.numeroCasillasAdj;
	}

}
