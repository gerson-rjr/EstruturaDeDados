package stackwitharray;

import java.util.Scanner;

public class Stack {
	
	public Object[] stackArray;
	public int currentPositionStack;

	public Stack() {
		this.stackArray = new Object[20];
		this.currentPositionStack = -1;
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		System.out.println("Stack size: " + stack.stackSize());
		stack.stackPush("First");
		stack.stackPush("Second");
		stack.stackPush("Third");
		stack.stackPush("Forth");
		stack.stackPush("Fifth");
		System.out.println("Stack size: " + stack.stackSize());
		System.out.println(stack.stackPop());
		System.out.println(stack.stackPop());
		System.out.println(stack.stackPop());
		System.out.println(stack.stackPop());
		System.out.println(stack.stackPop());
		System.out.println(stack.stackPop());
	}
	
	public boolean stackIsEmpty() {
		if (this.currentPositionStack == -1) {
			return true;
		} return false;
	}
	
	public int stackSize() {
		return this.currentPositionStack + 1;
	}
	
	public void stackPush(Object object) {
		if (this.currentPositionStack < this.stackArray.length - 1) {
			this.currentPositionStack++;
 			this.stackArray[this.currentPositionStack] = object;
		}
	}
	
	public Object stackPop() {
		if (stackIsEmpty()) {
			return "The stack is empty!";
		} return this.stackArray[this.currentPositionStack--];
	}
}
