package pilharubronegra;

import java.util.EmptyStackException;

public interface IPilhaRubroNegra {
	
	public int size();
	public boolean isEmpty();
	public Object top() throws EmptyStackException;
	public void pushRed(Object elemento);
	public void pushBlack(Object elemento);
	public Object popRed();
	public Object popBlack();
}
