package pilharubronegra;

import java.util.EmptyStackException;

public class PilhaRubroNegra implements IPilhaRubroNegra{
	
	protected int capacidade;
	protected Object pilha[];
	protected Object newPilha[];
	protected int top = -1;
	protected int bottom;
	protected int tamanho = 0;

	
	public int getCapacidade() {
		return this.capacidade;
	}
	
	public int getBottom() {
		return this.bottom;
	}
	
	public int getTop() {
		return this.top;
	}
	
	public void aumentaTamanho(int capacidade) {
		this.capacidade = capacidade;
		this.bottom = capacidade;
		newPilha = pilha.clone();
		pilha = new Object[capacidade];
		for (int i=0; i<newPilha.length; i++) {
			pilha[i] = newPilha[i];
		}
	}
	
	public void diminuiTamanho(int capacidade) {
		this.capacidade = capacidade/2;
		this.bottom = this.capacidade;
		newPilha = pilha.clone();
		pilha = new Object[capacidade];
		for (int i=0; i<pilha.length; i++) {
			pilha[i] = newPilha[i];
		}
	}

	public PilhaRubroNegra(int capacidade) {
		this.capacidade = capacidade;
		pilha = new Object[capacidade];
		this.bottom = capacidade;
	}
	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	@Override
	public Object top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return pilha[top];
	}
	
	@Override
	public void pushRed(Object elemento) {
		if(size() == this.capacidade) {
			aumentaTamanho(capacidade*2);
		}
		pilha[++top] = elemento;
		tamanho++;
	}
	@Override
	public void pushBlack(Object elemento) {
		
		if(size() == this.capacidade) {
			aumentaTamanho(capacidade*2);
		}
		pilha[--bottom] = elemento;
		tamanho++;
	}
	@Override
	public Object popRed() {
		Object elemento;
		if(isEmpty()) throw new EmptyStackException();
		if(size() <= this.capacidade) {
			elemento = pilha[top];
			pilha[top--] = null;
			tamanho--;
			diminuiTamanho(capacidade);
			return elemento;
		}
		elemento = pilha[top];
		pilha[top--] = null;
		tamanho--;
		return elemento;
	}
	@Override
	public Object popBlack() {
		Object elemento;
		if(isEmpty()) throw new EmptyStackException();
		if(size() <= this.capacidade) {
			elemento = pilha[bottom];
			pilha[bottom++] = null;
			tamanho--;
			diminuiTamanho(capacidade);
			return elemento;
		}
		elemento = pilha[bottom];
		pilha[bottom++] = null;
		tamanho--;
		return elemento;
	}
	
	public void status(String operacao, Object elemento) {
		System.out.println(operacao + ", " + "retorna: " + elemento + ".");
		System.out.println("Está vazia? " + isEmpty());
	}
	
	public String toString() {
		
		String s = "[";
		if(pilha.length>0) s += pilha[0];
		if (pilha.length>1) {
			for(int i=1; i<pilha.length; i++) {
				s+= " - " + pilha[i];
			}
		}
		return s + "]";
	}
	
	public static void main(String[] args) {
		Object o;
		PilhaRubroNegra pilhaRN = new PilhaRubroNegra(4);
		System.out.println("Valor do Top: " + pilhaRN.getTop());
		System.out.println("Valor do Bottom: " + pilhaRN.getBottom());
		System.out.println("Valor da Capacidade: " + pilhaRN.getCapacidade());
		pilhaRN.pushRed("primeiro");
		pilhaRN.pushRed("segundo");
		pilhaRN.pushRed("terceiro");
		pilhaRN.pushRed("quarto");
		pilhaRN.pushRed("quintoRed");
		pilhaRN.pushBlack("quinto");
		pilhaRN.pushBlack("sexto");
		pilhaRN.pushBlack("sétimo");
		pilhaRN.pushBlack("oitavo");
		pilhaRN.pushBlack("nono");
		System.out.println("Valor do Top: " + pilhaRN.getTop());
		System.out.println("Valor do Bottom: " + pilhaRN.getBottom());
		System.out.println("Valor da Capacidade: " + pilhaRN.getCapacidade());
		System.out.println(pilhaRN.toString());
		o = pilhaRN.popRed();
		pilhaRN.status("popRed: ", o);
		System.out.println(pilhaRN.toString());
		System.out.println("Valor do Bottom: " + pilhaRN.getBottom());
		System.out.println("Valor da Capacidade: " + pilhaRN.getCapacidade());
		o = pilhaRN.popBlack();
		pilhaRN.status("popBlack", o);
		System.out.println(pilhaRN.toString());
		System.out.println("Valor do Top: " + pilhaRN.getTop());
		System.out.println("Valor do Bottom: " + pilhaRN.getBottom());
		System.out.println("Valor da Capacidade: " + pilhaRN.getCapacidade());
		pilhaRN.pushBlack("nono");
		System.out.println(pilhaRN.toString());
		o = pilhaRN.popBlack();
		pilhaRN.status("popBlack", o);
		System.out.println(pilhaRN.toString());
	}
}
