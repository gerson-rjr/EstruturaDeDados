package listaligada;

public class ListaDEncadeada {
	
	protected NoLDE primeiro;
	protected NoLDE ultimo;
	protected long tamanhoLista;
	protected String retorne;
	
	
	public ListaDEncadeada() {
		tamanhoLista = 0;
		primeiro.setAnterior(null);
		ultimo.setProximo(null);
	}
	
	public void inserirInicio(String elemento) {
		NoLDE novo = new NoLDE(elemento);
		novo.setAnterior(null);
		novo.setProximo(primeiro);
		primeiro = novo;
		tamanhoLista++;
		if (tamanhoLista == 0) {
			ultimo = primeiro;
		}
	}
	
	public void inserirFim(String elemento) {
		if (tamanhoLista == 0) {
			inserirInicio(elemento);
		}else {
			NoLDE novo = new NoLDE(elemento);
			novo.setAnterior(ultimo);
			novo.setProximo(null);
			ultimo = novo;
			tamanhoLista++;
		}	
	}
	
	public void removeInicio() {
		if (tamanhoLista == 0) {
			throw new NullPointerException("Lista vazia.");
		}else {
			NoLDE atual = primeiro.getProximo();
			atual.setAnterior(null);
			primeiro = atual;
			tamanhoLista--;
			retorne = primeiro.getElemento();
		}
	
	}
	public void removeFim() {
		if (tamanhoLista == 0) {
			throw new NullPointerException("Lista vazia.");
		}else {
			retorne = ultimo.getElemento();
			NoLDE atual = ultimo.getAnterior();
			atual.setProximo(null);
			ultimo = atual;
			tamanhoLista--;
			retorne = ultimo.getElemento();

		}
	}
	
//	public String toString() {		
//		if (tamanhoLista == 0) {
//			return "{}";
//		}else {
//			StringBuilder builder = new StringBuilder("");
//			  NoLDE atual = this.primeiro;
//
//			  // Percorrendo até o penúltimo elemento.
//			  for (int i = 0; i < this.tamanhoLista - 1; i++) {
//			    builder.append(atual.getElemento());
//			    builder.append(" => ");
//			    atual = atual.getProximo();
//			  }
//
////			  // último elemento
//			  builder.append(atual.getElemento());
//			  builder.append("");
//			  return builder.toString();
//			  
//		}		
//	}
	
	public String pop() {
		return retorne;
	}
	
	public static void main(String[] args) {
		ListaDEncadeada lista = new ListaDEncadeada(); 
			lista.inserirInicio("A");
//			lista.inserirFim("B");
			lista.inserirInicio("C");
//			lista.inserirFim("D");
			System.out.println(lista.toString());
		
	}
}
