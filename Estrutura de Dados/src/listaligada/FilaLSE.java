package listaligada;

public class FilaLSE {
	
	protected ListaSEncadeada fila = new ListaSEncadeada();
	protected long elementosFila;

	public FilaLSE() {
		elementosFila = 0;
	}
	
	public boolean isEmpty() {
		if (fila.tamanhoLista() == 0) 
			return true;
		return false;
	}
	
	public String dequeue() {
		if (isEmpty()) {
			return "Fila vazia.";
		}
		fila.removerInicio();
		elementosFila--;
		return fila.pop();
	}
	
	public void queue(String elemento) {
		fila.inserirFim(elemento);
		elementosFila++;
	}
	
	public long size() {
		return elementosFila;
	}
	
	public static void main(String[] args) {
		FilaLSE fila = new FilaLSE();
		System.out.println(fila.isEmpty());
		fila.queue("D");
		fila.queue("C");
		fila.queue("B");
		fila.queue("A");
		System.out.println(fila.size());
		System.out.println(fila.isEmpty());
		System.out.println(fila.dequeue());
		System.out.println(fila.dequeue());
		System.out.println(fila.dequeue());
		System.out.println(fila.dequeue());
		System.out.println(fila.size());
	}
}
