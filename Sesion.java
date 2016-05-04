package minesweeper;

import java.awt.GraphicsConfiguration;

public class Sesion {
	private Jugador jugador;
	private static Sesion miSesion= null;
	private int nivel;
	private int puntuacion;
	
	
	private Sesion() {
	}

	public static Sesion getSesion(){
		if (miSesion==null){
			miSesion= new Sesion();
		}
		return miSesion;
	}
	
	public void iniciarSesion(String pNombre, int pNiv){
		this.jugador = CatalogoJugadores.getCatalogoJugadores().anadirJugador(pNombre);
		this.nivel = pNiv;
	}
	
	public void actualizarTablero(){
		Buscaminas.getBuscaminas().construirTableroPorNivel(nivel);
	}

	public int getNivel() {
		return this.nivel;
	}
	
	public int getPuntuacion() {
		return this.puntuacion;
	}
	public void setPuntuacion(int pPunt) {
		this.puntuacion = pPunt;
	}
	
	public Jugador getJugador(){
		return this.jugador;
	}
	
}
