package pilharubronegra;

import java.util.EmptyStackException;

public interface Stack<E> {
	
	public int size();
	public boolean isEmpty();
	public E top() throws Exception;
	public void push(E element) throws Exception;
	public E pop() throws EmptyStackException;

}
