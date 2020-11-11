package listacomlistadencadeada;

public class No<T> implements Posicao<Object> {
	
	private Object elemento;
	private No<T> proximo;
	private No<T> anterior;

	
	public No(No<T> anterior, No<T> proximo, Object elemento) {
		this.elemento = elemento;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public No(Object elemento) {
		this.elemento = elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public No<T> getProximo() {
		return proximo;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	public No<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	@Override
	public Object element() {
		return elemento;
	}
}
