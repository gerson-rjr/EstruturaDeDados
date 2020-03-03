package listaligada;

public class Deque {
	
	protected ListaDEncadeada deque = new ListaDEncadeada();
	protected long elementosDeque;

	public boolean isEmpty() {
		if (deque.tamanhoLista == 0) 
			return true;
		return false;
	}
	
	
	public void insertFirst(String elemento) {
		deque.inserirInicio(elemento);
		elementosDeque++;
	}
	
	public void insertLast(String elemento) {
		deque.inserirFim(elemento);
		elementosDeque++;
	}
	
	public String removeFirst() {
		deque.removeInicio();
		elementosDeque--;
		return "O próximo elemento é: " + deque.pop();
	}
	
	public String removeLast() {
		deque.removeFim();
		elementosDeque--;
		return "O elemento anterior é: " + deque.pop();
	}
	
	public long size() {
		return elementosDeque;
	}
	
	public static void main(String[] args) {
		Deque deque = new Deque();
		
		System.out.println(deque.isEmpty());
		deque.insertFirst("A");
		deque.insertLast("C");
		deque.insertFirst("B");
		deque.insertLast("D");
		deque.insertFirst("3");
		deque.insertLast("1");
		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeLast());

		
	}
}
