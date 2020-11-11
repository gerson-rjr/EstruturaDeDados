package vectorcomarray;

public class Vector {
	
	protected Object[] vector;
	protected int rank;
	protected int totalElementos;
	protected int tamanhoArray;
	
	public Vector(int tamanhoArray) {
		this.tamanhoArray = tamanhoArray;
		this.vector = new Object[tamanhoArray];
		this.totalElementos = 0;
	}
	
	public void aumentaTamanho() {
			tamanhoArray = tamanhoArray*2;
			Object[] novoArray = new Object[tamanhoArray];
			System.arraycopy(vector, 0, novoArray, 0, vector.length);
			vector = new Object[tamanhoArray];
			vector = novoArray;
	}
	
	public int size() {
		return totalElementos;
	}
	
	public boolean isEmpty() {
		return totalElementos == 0;
	}
	
	public Object elementAtRank(int rank) {
		return vector[rank];
	}
	
	public Object replaceAtRank(int rank, Object elemento) {
		Object oldValue = vector[rank];
		vector[rank] = elemento;
		return oldValue;
	}
	
	public void insertAtRank(int rank, Object elemento) {
		totalElementos++;
		if (totalElementos + 1 == tamanhoArray) {
			aumentaTamanho();
		}else{
			for (int i = rank; i<totalElementos - 1; i++) {
				vector[rank+1] = vector[rank];
			}
			vector[rank] = elemento;
		}
	}
	
	public Object removeAtRank(int rank) {
		Object retorno = vector[rank];
		for (int i=rank; i<totalElementos; i++) {
			vector[rank] = vector[rank+1];
		}
		totalElementos--;
		return retorno;
	}
	
	public String toString() {
		String s = new String();
		
		s = "vector[0] = " + vector[0] + "\n";
		
		for (int i = 1; i<totalElementos; i++) {
			s += "vector[" + i + "] = " + vector[i] + "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		Vector vector = new Vector(2);
		
		vector.insertAtRank(0, 1);
		vector.insertAtRank(1, 2);
		vector.insertAtRank(2, 3);
		vector.insertAtRank(3, 4);
		vector.insertAtRank(4, 5);
		vector.elementAtRank(3);
		System.out.println(vector.replaceAtRank(2, 10));
		System.out.print(vector.toString());
		
	}
}
