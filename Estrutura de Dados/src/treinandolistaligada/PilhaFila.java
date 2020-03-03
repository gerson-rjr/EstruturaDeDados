package treinandolistaligada;

import java.util.Scanner;

public class PilhaFila extends ListaLigada {
	
	static ListaLigada pilha = new ListaLigada();
	static ListaLigada fila = new ListaLigada();
	static int elementosPilha;
	static int elementosFila;
	
	
	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
		String elemento;
		boolean bool = true;
		int operacao;
		while(bool) {
			menuInicial();
			operacao = s.nextInt();
			switch (operacao){
			case 1:
				System.out.print("Adicione algo a pilha: ");
				elemento = s.next();
				inserirPilha(elemento);
				System.out.println("O elemento foi inserido");
				break;
			case 2:
				removePilha();
				System.out.println(pilha.toString());
				break;
			case 3:
				System.out.println(pilha.tamanhoLista());
				break;
			case 4:
				System.out.println(pilha.toString());
				break;		
			case 5:
				System.out.print("Adicione algo a fila: ");
				elemento = s.next();
				inserirFila(elemento);
				System.out.println("O elemento foi inserido!");
			case 6: 
				removeFila();
				System.out.println(fila.toString());
				break;
			case 7:
				System.out.println(fila.tamanhoLista());
				break;
			case 8:
				System.out.println(fila.toString());
				break;
			case 0:
				bool = false;
				System.out.println("Programa encerrado!");
				break;	
			}

			
		}
	}
	
	
	private static void removeFila() {
		fila.removeComeco();
		elementosFila--;
	}

	private static void inserirFila(Object obj) {
		fila.adicionaComeco(obj);
		elementosFila++;
	}

	private static void menuInicial() {
		System.out.println("----- Criando Pilha ou Fila -----");
		System.out.println("1 - Inserir elementos na Pilha;");
		System.out.println("2 - Remover elementos da Pilha;");
		System.out.println("3 - Visualizar a quantidade de itens da Pilha;");
		System.out.println("4 - Visualizar itens da Pilha;");
		System.out.println("5 - Inserir elementos na Fila;");
		System.out.println("6 - Remover elementos da Fila;");
		System.out.println("7 - Visualizar a quantidade de itens da Fila;");
		System.out.println("8 - Visualizar itens da Fila;");
		System.out.println("0 - Sair");
	}
	
	private static void inserirPilha(Object obj) {
		pilha.adicionaFim(obj);
		elementosPilha++;
	}
	
	private static void removePilha() {
		pilha.removeFim();
		elementosPilha--;
	}
}
