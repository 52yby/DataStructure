package com.dyg.datestucture.stack;

//java ÊµÏÖÕ»
public class Stack {

	private int top;
	private int maxsize;
	private int arr[];

	public Stack(int size) {
		maxsize = size;
		arr = new int[maxsize];
		top = -1;
	}

	public boolean isFull() {
		return top == maxsize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("Õ»Âú£¡£¡");
			return;
		}
		top = top + 1;
		arr[top] = data;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Õ»¿Õ£¡£¡");
		}
		int value = arr[top];
		top = top - 1;
		return value;
	}

	public void show() {
		if (isEmpty()) {
			System.out.println("Õ»¿Õ£¡£¡");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}

	}

	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("Õ»¿Õ£¡£¡");
		}
		return arr[top];
	}

	public int operrity(int p) {
		if (p == '*' || p == '/') {
			return 2;
		}
		if (p == '+' || p == '-') {
			return 1;
		}
		return 0;
	}

	public boolean isoper(char p) {
		return p == '*' || p == '/' || p == '+' || p == '-';
	}

	public int cal(int num1, int num2, int p) {
		int res = 0;
		switch (p) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;

		default:
			break;
		}
		return res;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.show();
		stack.pop();
		stack.show();
		System.out.println(stack.head());
	}
}
