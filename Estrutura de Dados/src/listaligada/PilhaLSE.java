package listaligada;

public class PilhaLSE {
	
	protected ListaSEncadeada pilha = new ListaSEncadeada();
	protected long totalElementos;
	
	public PilhaLSE() {
		totalElementos = 0;
	}
	public boolean isEmpty() {
		if (pilha.tamanhoLista() == 0) return true;
		return false;
	}
	
	public String pop() {
		if (isEmpty()) {
			return "Pilha vazia.";
		}
		pilha.removerInicio();
		this.totalElementos--;
		return pilha.pop();
	}
	
	public void push(String elemento) {
		pilha.inserirInicio(elemento);
		this.totalElementos++;
	}
	
	public long size() {
		return totalElementos;
	}

	public static void main(String[] args) {
		PilhaLSE pilha = new PilhaLSE();
		System.out.println(pilha.isEmpty());
		pilha.push("D");
		pilha.push("C");
		pilha.push("B");
		pilha.push("A");
		System.out.println(pilha.size());
		System.out.println(pilha.isEmpty());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.size());
	}
}
