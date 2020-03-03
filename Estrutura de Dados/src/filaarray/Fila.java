package filaarray;

public class Fila {
	
	private Object[] filaArray;
	private int tamanho;
	private int tamanhoFila;
	private int primeiroDaFila = 0;
	
	public Fila(int tamanhoFila) {
		this.tamanhoFila = tamanhoFila;
		this.filaArray = new Object[tamanhoFila];
		this.tamanho = -1;
	}
	
	public static void main (String[] args) {
		
		Fila fila = new Fila(6);
		System.out.println(fila.size());
		fila.push("Primeiro");
		fila.push("Segundo");
		fila.push("Terceiro");
		fila.push("Quarto");
		fila.push("Quinto");
		System.out.println(fila.size());
		System.out.println(fila.pop());
		System.out.println(fila.pop());
		System.out.println(fila.pop());
		System.out.println(fila.pop());
		System.out.println(fila.pop());
	}
	
	public boolean isEmpty() {
		if (tamanho ==  -1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		if(tamanho == - 1) {
			return 0;
		}
		return tamanho + 1;
	}
	
	public String isFull() {
		if (tamanho == tamanhoFila - 1) {
			return ("Fila cheia!");
		}
		return "A fila não está cheia.";
	}
	
	public void push(Object objeto) {
		if (tamanho > tamanhoFila) {
		} else {
			this.filaArray[++tamanho] = objeto;
		}
	}
	
	public Object pop() {
			if (tamanho >= 0) {	
				Object objeto = this.filaArray[0];
				for (int i=0; i<=tamanho; i++) {
					this.filaArray[i] = this.filaArray[i+1];
				}
				tamanho--;
				return objeto;
			}
		return "null";
	}

}
