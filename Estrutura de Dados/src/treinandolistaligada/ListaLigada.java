package treinandolistaligada;

public class ListaLigada {
	
	private Celula primeira;
	
	private Celula ultima;
	
	private int totalDeElementos;
	
	public void adicionaComeco(Object elemento) {
		Celula nova = new Celula(primeira, elemento);
		this.primeira = nova;
		
		if (this.totalDeElementos == 0) {
			this.ultima = this.primeira;
		}
		this.totalDeElementos++;
	}
	
	public void adicionaFim(Object elemento) {
		if (this.totalDeElementos == 0) {
			adicionaComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			totalDeElementos++;			
		}	
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}
		return atual;
	}
	
	public void adicionaPosicao(int posicao, Object elemento) {
		if (posicao == 0) {
			adicionaComeco(elemento);
		} else if (posicao == this.totalDeElementos) {
			adicionaFim(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula nova = new Celula(anterior.getProxima(), elemento);
			anterior.setProxima(nova);
			this.totalDeElementos++;
		}
		
	}
	
	public Object pegarObjeto(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void removeComeco() {
		if(!posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		this.primeira = this.primeira.getProxima();
		this.totalDeElementos--;
		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}
	public void removeFim() {
		if (!posicaoOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		if (this.totalDeElementos == 1) {
			removeComeco();
			this.totalDeElementos--;
		} else {
			Celula penultima = pegaCelula(this.totalDeElementos - 1);
			this.ultima = penultima;
			this.totalDeElementos--;
		}	
	}
	public void removePosicao(int posicao) {}
	public int tamanhoLista() {return this.totalDeElementos;}
	public boolean contemEsteObjeto(Object elemento) {return false;}
	public String toString() {

		  // Verificando se a Lista está vazia
		  if(this.totalDeElementos == 0){
		    return "{}";
		  }
		  
		  StringBuilder builder = new StringBuilder("");
		  Celula atual = primeira;

		  // Percorrendo até o penúltimo elemento.
		  for (int i = 0; i < this.totalDeElementos - 1; i++) {
		    builder.append(atual.getElemento());
		    builder.append(" => ");
		    atual = atual.getProxima();
		  }

//		  // último elemento
		  builder.append(atual.getElemento());
//		  builder.append("");
		  
		  return builder.toString();
		}
	
	
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		System.out.println(lista.toString());
		lista.adicionaComeco("a");
		lista.adicionaComeco("b");
		lista.adicionaFim("Gerson");
		lista.adicionaFim("Luca");
		lista.adicionaFim("Emerson");
		lista.adicionaFim("Júnior");
		lista.adicionaFim("Felipe");
		lista.adicionaComeco("Lauren");
		System.out.println(lista.toString());
		System.out.println(lista.tamanhoLista());
		lista.removeFim();
		lista.removeComeco();
		lista.removeFim();
		System.out.println(lista.tamanhoLista());
		System.out.println(lista.toString());
	}
}


