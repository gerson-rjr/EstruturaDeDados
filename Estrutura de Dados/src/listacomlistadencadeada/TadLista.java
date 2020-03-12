package listacomlistadencadeada;

public class TadLista {
	
	private ListaDEncadeada lista = new ListaDEncadeada();
	
	public long size() {
		return lista.tamanhoLista;
	}
	
	public boolean isEmpty() {
		if (lista.tamanhoLista != 0) {
			return false;
		} return true;
	}
	
	
}
