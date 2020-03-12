package listacomlistadencadeada;

import listaligada.NoLDE;

public class No {
	
	private String elemento;
	private No proximo;
	private No anterior;

	
	public No(String elemento) {
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public No getAnterior() {
		return anterior;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
}
