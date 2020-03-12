package listacomlistadencadeada;

public class ListaDEncadeada {
	
	protected No primeiro;
	protected No ultimo;
	protected No cabeca;
	protected No cauda;
	protected long tamanhoLista;
	
	public ListaDEncadeada() {
		tamanhoLista = 0;
		cabeca.setProximo(primeiro);
		cauda.setAnterior(ultimo);
		primeiro.setAnterior(cabeca);
		ultimo.setProximo(cauda);
	}
	
	public void inserirInicio(String elemento) {
		No novo = new No(elemento);
		novo.setProximo(primeiro);
		primeiro = novo;
		tamanhoLista++;
	}
	
	public void inserirFim(String elemento) {
		No novo = new No(elemento);
		novo.setAnterior(ultimo);
		ultimo = novo;
		tamanhoLista++;
	}
	
	public void inserirDepoisInicio(String elemento) {
		No novo = new No(elemento);
		novo.setAnterior(primeiro);
		novo.setProximo(primeiro.getProximo());
		primeiro.setProximo(novo);
		tamanhoLista++;
	}
	
	public void inserirAntesFim(String elemento) {
		No novo = new No(elemento);
		novo.setAnterior(ultimo.getAnterior());
		novo.setProximo(ultimo);
		ultimo.setAnterior(novo);
		tamanhoLista++;
	}
	
	public void removeInicio() {
		if (tamanhoLista == 0) {
			throw new NullPointerException("Lista Vazia");
		}else {
		No novo = primeiro.getProximo();
		primeiro.setProximo(null);
		primeiro = novo;
		tamanhoLista--;
		}
	}
	
	public void removeFim() {
		if (tamanhoLista == 0) {
			throw new NullPointerException("Lista Vazia");
		} else {
			No novo = ultimo.getAnterior();
			ultimo.setAnterior(null);
			ultimo = novo;
			tamanhoLista--;
		}
		
	}
}
