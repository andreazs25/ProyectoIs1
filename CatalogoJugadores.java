package minesweeper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Iterator;

public class CatalogoJugadores {
	private static CatalogoJugadores miCatalogoJugadores= new CatalogoJugadores();
	private ListaJugadores lista;
	String texto= "src/minesweeper/datosJugadores.txt";
	URL url;
	
	private CatalogoJugadores() {
		lista= new ListaJugadores();
	}
	
	public static CatalogoJugadores getCatalogoJugadores(){
		if (miCatalogoJugadores==null){
			miCatalogoJugadores= new CatalogoJugadores();
		}
		return miCatalogoJugadores;
	}
	
	public Iterator<Jugador> getIterador(){
		return lista.getIterador();}

	public Jugador anadirJugador(String pNombre) {
		return lista.anadirJugadorPorNombre(pNombre);
	}
	
	public boolean estaJ(String pNombre){
		boolean esta = true;
		if (lista.estaJ(pNombre)==null){
			esta = false;
		}
		return esta;
	}
	
	// Cargar los jugadores de un fichero
	public void cargarJugadores(){
		BufferedReader br;
	    File f = new File(texto);
	        try{
	            br=new BufferedReader(new FileReader(f));
	            String linea=br.readLine();
	            Jugador jugAux=null;
	            while(linea!=null)
	            {
	            	// Me mete en datos strings separados por ";"
	            	String[] datos= linea.split(";");
	            	jugAux=anadirJugador(datos[0]);
	            	jugAux.setPuntMax(1, Integer.parseInt(datos[1]));
	            	jugAux.setPuntMax(2, Integer.parseInt(datos[2]));
	            	jugAux.setPuntMax(3, Integer.parseInt(datos[3]));
	            	linea=br.readLine();
	            }
	        	br.close();
	        }
	        catch(Exception e){
	         System.out.println(e);}
		}
		
	
	// Me guarda los jugadores de la lista en el fichero
	public void guardarJugadores()
	{
		BufferedWriter bw;
    	File f = new File(texto);
    	try{
    		bw=new BufferedWriter(new FileWriter(f));
    		Jugador jugAux=null;
    		Iterator<Jugador> itr=this.getIterador();
    		while(itr.hasNext()){
        		jugAux=itr.next();
        		bw.write(jugAux.imprimirInformacion());
        		bw.write("\n");
    		}
    		bw.close();
    	}
    	catch(Exception e){
            System.out.println(e);}
	}

	
	// Me devuelve un string con los 10 mejores jugadores de un determinado nivel
	public String obtenerMejoresJugadores(int pNumJug, int pNivel){
		return lista.obtenerMejoresJugadores(pNumJug, pNivel);
	}
}
