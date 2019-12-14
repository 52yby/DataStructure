package com.dyg.datestucture.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java  实现后缀表达式计算器（逆波兰表达式）
//@author  dyg
public class PolandStack {
	public static void main(String[] args) {
		String s = "30 4 + 5 * 6 -";
		System.out.println(cal(Polandlist(s)));
	}
	public boolean isoper(char p) {
		return p == '*' || p == '/' || p == '+' || p == '-';
	}
	public static List<String> Polandlist(String expression) {
		String  strarr[]=expression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String c : strarr) {
			list.add(c);
		}
		return list;
	}

	public static int cal(List<String> l) {
		Stack<String> stack = new Stack<String>();
		for (String item : l) {
			if (item.matches("\\d+")) {
				stack.push(item);
			} else {
				int num2 = Integer.valueOf(stack.pop());
				int num1 = Integer.valueOf(stack.pop());
				int res = 0;
				if ("+".equals(item)) {
					res = num1 + num2;
				}
				if ("-".equals(item)) {
					res = num1 - num2;
				}
				if ("*".equals(item)) {
					res = num1 * num2;
				}
				if ("/".equals(item)) {
					res = num1 / num2;
				}

				stack.push(String.valueOf(res));
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
