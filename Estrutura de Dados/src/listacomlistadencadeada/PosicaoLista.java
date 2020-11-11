package listacomlistadencadeada;

public interface PosicaoLista<T>{
	
	public long size();
	public boolean isEmpty();
	public Posicao<T> first();
	public Posicao<T> last();
	public Posicao<T> next(Posicao<T> posicao) throws InvalidPositionException, BoundaryViolationException;
	public Posicao<T> prev(Posicao<T> posicao) throws InvalidPositionException, BoundaryViolationException;
	public void addFirst(T elemento);
	public void addLast(T elemento);	
	public void addAfter(Posicao<T> posicao, T elemento) throws InvalidPositionException;
	public void addBefore(Posicao<T> posicao, T elemento) throws InvalidPositionException;
	public T remove(Posicao<T> posicao) throws InvalidPositionException;
	public T set(Posicao<T> posicao, T elemento) throws InvalidPositionException;

}
 