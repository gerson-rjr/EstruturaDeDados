package listaligada;

public class NoLDE {
	
	private String elemento;
	private NoLDE anterior;
	private NoLDE proximo;
	
	public NoLDE(String elemento, NoLDE anterior, NoLDE proximo) {
		this.elemento = elemento;
		this.anterior = anterior;
		this.proximo = proximo;
	}
	
	public NoLDE(String elemento) {
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public NoLDE getAnterior() {
		return anterior;
	}

	public void setAnterior(NoLDE anterior) {
		this.anterior = anterior;
	}

	public NoLDE getProximo() {
		return proximo;
	}

	public void setProximo(NoLDE proximo) {
		this.proximo = proximo;
	}

}
