package listaligada;

import treinandolistaligada.Celula;

public class ListaSEncadeada {
	
	protected NoLSE primeiro;
	protected NoLSE ultimo;
	protected long tamanhoLista;
	String retorno;
	
	public ListaSEncadeada() {
		this.primeiro = null;
		ultimo = null;
		tamanhoLista = 0;
	}
	
	public void inserirInicio(String elemento) {
		NoLSE novo = new NoLSE(elemento, primeiro);
		primeiro = novo;
		
		if (tamanhoLista == 0) {
			ultimo = primeiro;
		}
		
		tamanhoLista++;
	}
	
	public void inserirFim(String elemento) {
		
		if (tamanhoLista == 0) {
			inserirInicio(elemento);
		}else {
			NoLSE novo = new NoLSE(elemento);
			ultimo.setProximo(novo);
			ultimo = novo;
			tamanhoLista++;
		}
	}
	
	public void removerInicio() {
		if (primeiro == null) {
			throw new NullPointerException("Lista NULA! Impossível remover.");
		}else {
			retorno = primeiro.getElemento();
			NoLSE remover = primeiro;
			primeiro = primeiro.getProximo();
			remover.setProximo(null);
			tamanhoLista--;
		}
	}
	
	public String pop() {
		return retorno;
	}
	
	public void removerFim() {
		if (primeiro == null) {
			throw new NullPointerException("Lista NULA! Impossível remover.");
		}else {
			NoLSE atual = primeiro;
			for (int i=0; i<tamanhoLista - 1; i++) {
				atual = atual.getProximo();
			}
			atual.setProximo(null);
			ultimo = atual;
			tamanhoLista--;
		}
	}
	
	public long tamanhoLista() {
		return tamanhoLista;
	}

	public String toString() {		
		if (tamanhoLista == 0) {
			return "{}";
		}else {
			StringBuilder builder = new StringBuilder("");
			  NoLSE atual = this.primeiro;

			  // Percorrendo até o penúltimo elemento.
			  for (int i = 0; i < this.tamanhoLista - 1; i++) {
			    builder.append(atual.getElemento());
			    builder.append(" => ");
			    atual = atual.getProximo();
			  }

//			  // último elemento
			  builder.append(atual.getElemento());
			  builder.append("");
			  return builder.toString();
			  
		}		
	}
	
	public static void main(String[] args) {
		ListaSEncadeada lista = new ListaSEncadeada();
		
		lista.inserirInicio("Gerson");
		lista.inserirFim("Adna");
		lista.inserirInicio("José");
		lista.inserirFim("Edna");
//		lista.removerInicio();
		lista.removerFim();
		lista.removerFim();
		lista.removerFim();
		lista.removerFim();
		System.out.println(lista.toString());
	}
}
