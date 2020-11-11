package listacomlistadencadeada;

public class TADLista {


	public static void main(String[] args) throws InvalidPositionException, BoundaryViolationException {
		ListaDEncadeada lista = new ListaDEncadeada();
		lista.addLast(10);
		lista.addLast(11);
		lista.addLast(12);
		lista.addFirst(14);
		lista.addLast(113);
		lista.remove(lista.first());
		System.out.println(lista.toString());
		System.out.print(lista.first().element());

	}

}
