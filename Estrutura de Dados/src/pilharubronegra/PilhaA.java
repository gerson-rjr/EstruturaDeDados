package pilharubronegra;

import java.util.EmptyStackException;

public class PilhaA<E> implements Stack<E> {

	protected int capacidade;
	public static final int CAPACITY = 1000;
	protected E S[];
	protected int top = -1;
	
//	public PilhaA() {
//		this(CAPACITY);
//	}
	
	public PilhaA() {
		this.capacidade = 10;
		S = (E[]) new Object[10];
	}
	
	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);		
	}

	@Override
	public E top() throws EmptyStackException {
		E element;
		if (isEmpty()) throw new EmptyStackException();
		element = S[top];
		S[top--] = element;
		return element;
		
		
	}

	@Override
	public void push(E element) throws FullStackException {
		if(size() == this.capacidade) throw new FullStackException("A pilha está cheia.");
		S[++top] = element;
	}
	@Override
	public E pop() throws EmptyStackException {
		E element;
		if (isEmpty()) throw new EmptyStackException();
		element = S[top];
		S[top--] = null;
		return element;
	}

	
	public void status(String operacao, Object elemento) {
		System.out.println(operacao + ", " + "retorna: " + elemento + ".");
		System.out.println("tamanho: " + size() + " Está vazia? " + isEmpty());
	}
	
	
	public static void main(String[] args) throws FullStackException, EmptyStackException {
		Object o;
		PilhaA<Integer> pilha = new PilhaA<Integer>();
		pilha.push(5);
		pilha.push(4);
		pilha.push(3);
		pilha.push(2);
		pilha.status("Pilha1", null);
		o = pilha.pop();
		pilha.status("Pilha1", o);
		o = pilha.pop();
		pilha.status("Pilha1", o);
		o = pilha.pop();
		pilha.status("Pilha1", o);
		o = pilha.pop();
		pilha.status("Pilha1", o);
	}
		
	
	

}
	