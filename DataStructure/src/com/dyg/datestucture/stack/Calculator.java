package com.dyg.datestucture.stack;

//ʹ��ջʵ�ּ����� :������ֻ�ܵ�λ���ּ���
public class Calculator {
	public static void main(String[] args) {
	System.out.println(Calculator.Cal("1*5+4/4"));	}
	public  static int Cal(String expression) {
		Stack numstack = new Stack(1000);// ����ջ
		Stack operstack = new Stack(100);// ����ջ
		int num1 = 0;
		int num2 = 0;
		int index = 0;
		while (true) {
			char data = expression.substring(index, index + 1).charAt(0);
			if (operstack.isoper(data)) {
				if (operstack.isEmpty()) {
					operstack.push(data);
				} else {
					if (operstack.operrity(operstack.head()) > operstack.operrity(data)) {
						num1 = numstack.pop();
						num2 = numstack.pop();
						int oper = operstack.pop();
						int res = operstack.cal(num1, num2, oper);
						numstack.push(res);
						operstack.push(data);
					} else {
						operstack.push(data);
					}
				}
			} else {
				numstack.push(data - 48);
			}
			index++;
			if (index == expression.length()) {
				break;
			}
		}
		while (true) {
			if (operstack.isEmpty()) {
				break;
			}
			num1 = numstack.pop();
			num2 = numstack.pop();
			int oper = operstack.pop();
			int res = operstack.cal(num1, num2, oper);
			numstack.push(res);
		}
		return numstack.pop();
	}
}
