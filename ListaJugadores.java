package minesweeper;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ListaJugadores {
	
		private ArrayList<Jugador> lista;
		
		public ListaJugadores(){
			lista= new ArrayList<Jugador>();
		}

	    public Iterator<Jugador> getIterador() {
	        return lista.iterator();}
	    
	    //Si ya existe, devuelve el jugador con mismo nombre, si no, lo crea y devuelve
	    public Jugador anadirJugadorPorNombre(String pNombre){
	    	Jugador jugador;
	    	if (this.estaJ(pNombre)==null){
	    		jugador = new Jugador(pNombre);
		    	lista.add(jugador);
	    	}
	    	else {
	    		jugador = this.estaJ(pNombre);
	    	}
	    	return jugador;
	    }
	    
	    // Añadir jugador
	    public void addJugador(Jugador pJugador){
	    	lista.add(pJugador);}
	    
	    // Me devuelve el jugador al que corresponde el pNombre y si no esta devuelve null
	    public Jugador estaJ(String pNombre){
	    	Iterator<Jugador> itr=lista.iterator();
	    	boolean encontrado=false;
			Jugador jugAux=null;
	    	while(itr.hasNext()&&!encontrado){
	    		jugAux=itr.next();
	    		if(jugAux.getNombre().compareTo(pNombre)==0){
	    			encontrado=true;
	    		}
	    	}
	    	if(!encontrado){
	    		jugAux=null;
	    	}
	    	return jugAux;
	    }

	    // Me devuelve un string con los 10 mejores jugadores de un determinado nivel
		public String obtenerMejoresJugadores(int pNumJug, int pNivel) {
			StringWriter ranking=new StringWriter();
			ranking.write("Mejores 10 jugadores del nivel " + pNivel + " \n \n");
			// Obtenemos la lista de los jugadores ordenados por la puntuacion en el nivel que interesa
	    	ListaJugadores lista=this.getListaRanking(pNivel);
	    	Iterator<Jugador> itr=lista.getIterador();
	    	int i=1;
	    	// Me escribe el nombre y la puntuacion de los 10 mejores
	    	while (itr.hasNext() && i<=pNumJug){
	    		Jugador jugAux=itr.next();
	    		ranking.write(i+". "+jugAux.getNombre()+": "+ jugAux.getPuntMax(pNivel) +" pts.\n");
	    		i++;
	    	}
	    	return ranking.toString();
		}
	    
		// Nos devuelve una lista de jugadores ordenados por la puntuacion
	    public ListaJugadores getListaRanking(int pNivel){
	    	Iterator<Jugador> itr=lista.iterator();
	    	ListaJugadores listAux=new ListaJugadores();
	    	while(itr.hasNext()){
	    		Jugador jugAux=itr.next();
	    		if (jugAux.getPuntMax(pNivel)!=0){
	    		listAux.addJugador(jugAux);
	    		}
	    	}
	    	listAux.ordenaPorPuntuacion(pNivel);
	    	return listAux;
	    }
	    
	    // Me ordena la lista de jugadores por puntuacion, le introducimos el nivel que queremos que nos ordene
	    public void ordenaPorPuntuacion(int pNivel)
	    {
	 
			Collections.sort(lista, new Comparator<Jugador>(){
				@Override
				public int compare(Jugador arg0, Jugador arg1) {
					Integer punt1 = arg0.getPuntMax(pNivel);
					Integer punt2 = arg1.getPuntMax(pNivel);
					return punt1.compareTo(punt2);
				}
			});
			Collections.reverse(lista);
	    }
	}

