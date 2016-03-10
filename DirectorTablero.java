public class DirectorTablero {
	private BuilderTablero builder;

	public BuilderTablero getBuilder() {
		return builder;
	}

	public void setBuilder(BuilderTablero builder) {
		this.builder = builder;
	}
	
	public Tablero getTablero(){
		
		return this.getBuilder().getTableroBuilder();
	}
	
	public void construirTablero(){
		this.getBuilder().construirTableroPorNivel();
	}
}
