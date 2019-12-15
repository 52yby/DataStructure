package com.dyg.datestucture.stack;

/*javaʹ��ջʵ�ּ����� (��׺���ʽ)
 *@author  dyg
 * */

public class Calculator {
	public static void main(String[] args) {
		System.out.println(Calculator.Cal("1+((2+2)/4)*5+4/4"));
	}

	public static int Cal(String expression) {
		Stack numstack = new Stack(1000);// ����ջ
		Stack operstack = new Stack(100);// ����ջ
		int num1 = 0;//
		int num2 = 0;//
		int index = 0;//����ָ�����ڱ������ʽ
		String knum = "";
		while (true) {

			char data = expression.substring(index, index + 1).charAt(0);
			if (operstack.isoper(data)) {
				if (operstack.isEmpty()||data=='(' ) {
					operstack.push(data);
				} else {
					if(data==')'){
						num1 = numstack.pop();
						num2 = numstack.pop();
						int oper = operstack.pop();
						int res = operstack.cal(num1, num2, oper);
						numstack.push(res);
						operstack.pop();
					}else{
					
					if (operstack.operrity(operstack.head()) > operstack.operrity(data)) {
						num1 = numstack.pop();
						num2 = numstack.pop();
						int oper = operstack.pop();
						int res = operstack.cal(num1, num2, oper);
						numstack.push(res);
						operstack.push(data);
					} else {
						operstack.push(data);
					}}
				}
			} else {
				knum += data;
				if (index != expression.length() - 1) {
					if (operstack.isoper(expression.substring(index + 1, index + 2).charAt(0))) {
						numstack.push(Integer.valueOf(knum.toString()));
						knum = "";
					}
				} else {
					numstack.push(Integer.valueOf(knum.toString()));
				}
				//
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
