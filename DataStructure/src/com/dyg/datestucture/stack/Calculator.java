package com.dyg.datestucture.stack;

/*java使用栈实现计算器 (中缀表达式)
 *@author  dyg
 * */

public class Calculator {
	public static void main(String[] args) {
		System.out.println(Calculator.Cal("100*5+4/4"));
	}

	public static int Cal(String expression) {
		Stack numstack = new Stack(1000);// 数字栈
		Stack operstack = new Stack(100);// 符号栈
		int num1 = 0;//
		int num2 = 0;//
		int index = 0;//辅助指针用于遍历表达式
		String knum = "";
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
