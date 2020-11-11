package listacomlistadencadeada;

public class ListaDEncadeada implements PosicaoLista<Object> {
	
	protected No<Object> header;
	protected No<Object> trailer;
	protected long tamanhoLista;

	
	public ListaDEncadeada() {
		tamanhoLista = 0;
		header = new No<Object>(null);
		header.setAnterior(null);
		header.setProximo(trailer);
		trailer = new No<Object>(null);
		trailer.setAnterior(header);
		trailer.setProximo(null);
	}
	
	@Override
	public long size() {
		if (tamanhoLista == 0) {
			throw new NullPointerException("Não há elementos.");
		}else {return tamanhoLista;}
	}


	@Override
	public boolean isEmpty() {
		return (tamanhoLista == 0);
	}

	protected No<Object> checkPosicao(Posicao<Object> posicao)
			throws InvalidPositionException {
			if (posicao == null) {
				throw new InvalidPositionException("Posição nula.");
			}
			if (posicao == header) {
				throw new InvalidPositionException("Este nó não é uma posição válida.");
			}
			if (posicao == trailer) {
				throw new InvalidPositionException("Este nó não é uma posição válida.");
			}
			try {
				No<Object> temp = (No<Object>) posicao;
				if(temp.getAnterior() == null || temp.getProximo() == null) {
					throw new InvalidPositionException("A posição não pertence a uma lista válida.");
				}
				return temp;
			}catch(ClassCastException e) {
				throw new InvalidPositionException("A posição possui o tipo errado para essa lista.");
			}
	}

	@Override
	public Posicao<Object> first() {
		if (isEmpty()) {
			throw new NullPointerException("Lista vazia.");
		}
		return header.getProximo();
	}


	@Override
	public Posicao<Object> last() {
		if (isEmpty()) {
			throw new NullPointerException("Lista vazia.");
		}
		return trailer.getAnterior();
	}


	@Override
	public Posicao<Object> next(Posicao<Object> posicao) throws InvalidPositionException, BoundaryViolationException {
		No<Object> teste = checkPosicao(posicao);
		No<Object> next = teste.getProximo();
		if (next == trailer) {
			throw new BoundaryViolationException("Impossível pegar o próximo do último elemento;");
		}
		return next;
	}


	@Override
	public Posicao<Object> prev(Posicao<Object> posicao) throws InvalidPositionException, BoundaryViolationException {
		No<Object> teste = checkPosicao(posicao);
		No<Object> prev = teste.getAnterior();
		if(prev == header) {
			throw new BoundaryViolationException("Impossível pegar o anterior ao primeiro da lista.");
		}
		return prev;
	}


	@Override
	public void addFirst(Object elemento) {
		No<Object> novo = new No<Object>(elemento);
		novo.setProximo(header.getProximo());
		novo.setAnterior(header);
		if(tamanhoLista == 0) {
			header.setProximo(novo);
		}else {
			header.getProximo().setAnterior(novo);
			header.setProximo(novo);
		}
		tamanhoLista++;
	}


	@Override
	public void addLast(Object elemento) {
		No<Object> novo = new No<Object>(elemento);
		tamanhoLista++;
		novo.setProximo(trailer);
		novo.setAnterior(trailer.getAnterior());
		if(trailer.getAnterior() == null) {
			trailer.setAnterior(novo);
		}else {
			trailer.getAnterior().setProximo(novo);
			trailer.setAnterior(novo);
		}
	}


	@Override
	public void addAfter(Posicao<Object> posicao, Object elemento) throws InvalidPositionException {
		No<Object> atual = checkPosicao(posicao); 
		No<Object> after = new No<Object>(elemento);
		after.setAnterior(atual.getAnterior());
		after.setProximo(atual);
		atual.getProximo().setAnterior(after);
		atual.setProximo(after);
		tamanhoLista++;
	}


	@Override
	public void addBefore(Posicao<Object> posicao, Object elemento) throws InvalidPositionException {
		No<Object> atual = checkPosicao(posicao);
		No<Object> before = new No<Object>(elemento);
		before.setProximo(atual);
		before.setAnterior(atual.getAnterior());
		atual.getAnterior().setProximo(before);
		atual.setAnterior(before);
		tamanhoLista++;
		
	}


	@Override
	public Object remove(Posicao<Object> posicao) throws InvalidPositionException {
		No<Object> atual = checkPosicao(posicao);
		tamanhoLista--;
		No<Object> atualPrev = atual.getAnterior();
		No<Object> atualNext = atual.getProximo();
		atualPrev.setProximo(atualNext);
		atualNext.setAnterior(atualPrev);
		Object elemento = atual.element();
		atual.setAnterior(null);
		atual.setProximo(null);
		return elemento;
	}


	@Override
	public Object set(Posicao<Object> posicao, Object elemento) throws InvalidPositionException {
		No<Object> atual = checkPosicao(posicao);
		Object elementoAntigo = atual.element();
		atual.setElemento(elemento);
		return elementoAntigo;
	}
	
	public String toString() {
		String s = new String();
		
		No<Object> atual = header.getProximo();
		
		while(atual.element() != null) {
			s += atual.element();
			s += " => ";
			atual = atual.getProximo();
		}
		return s;
	}
}
