package listaligada;

public class NoLSE {
	
	private String elemento;
	private NoLSE proximo;
	
	public NoLSE(String elemento, NoLSE proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	public NoLSE(String elemento) {
		this.elemento = elemento;
	}
	
	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public NoLSE getProximo() {
		return proximo;
	}

	public void setProximo(NoLSE proximo) {
		this.proximo = proximo;
	}

}
