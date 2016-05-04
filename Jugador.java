package minesweeper;

public class Jugador{

	private String nombre;
	private int puntMaxNivel1;
	private int puntMaxNivel2;
	private int puntMaxNivel3;

	public Jugador(String pNombre) {
		this.nombre=pNombre;
		this.puntMaxNivel1=0;
		this.puntMaxNivel2=0;
		this.puntMaxNivel3=0;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getPuntMax(int pNivel) {
		int nivel = 0;
		if (pNivel == 1){
			nivel = this.puntMaxNivel1;
		}
		else if (pNivel == 2){
			nivel = this.puntMaxNivel2;
		}
		else if(pNivel == 3){
			nivel = this.puntMaxNivel3;
		}
		return nivel;
	}
	
	public void setPuntMax(int pNivel, int pPunt){
		if (pNivel == 1){
			if (this.puntMaxNivel1==0){
			this.puntMaxNivel1 = pPunt;
			}
			else if (pPunt > this.puntMaxNivel1){
				this.puntMaxNivel1 = pPunt;
			}
		}
		if (pNivel == 2){
			if (this.puntMaxNivel2==0){
			this.puntMaxNivel2 = pPunt;
			}
			else if (pPunt > this.puntMaxNivel2){
				this.puntMaxNivel2 = pPunt;
			}
		}
		if (pNivel == 3){
			if (this.puntMaxNivel3==0){
			this.puntMaxNivel3 = pPunt;
			}
			else if (pPunt > this.puntMaxNivel3){
				this.puntMaxNivel3 = pPunt;
			}
		}
	}

	public String imprimirInformacion() {
		String info = this.nombre + ";" + this.puntMaxNivel1 +  ";" + this.puntMaxNivel2 +  ";" + this.puntMaxNivel3;
		return info;
	}
}
