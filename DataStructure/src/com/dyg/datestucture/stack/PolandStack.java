package com.dyg.datestucture.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java  实现后缀表达式计算器（逆波兰表达式）
//@author  dyg
public class PolandStack {
	public static void main(String[] args) {
		String s = "(10+1)*1  +5/5-1";
		s=s.replace(" ", "");
		System.out.println(stringtolist(s));
		System.out.println(midtoend(stringtolist(s)));
		System.out.println(cal(midtoend(stringtolist(s))));

	}

	//字符串转换成list便于使用
	public static List<String> stringtolist(String expression) {
		List<String> l = new ArrayList<>();
		int i = 0;
		String num;
		do {

			if (expression.charAt(i) < 48 || expression.charAt(i) > 57) {
				l.add(String.valueOf(expression.charAt(i)));
				i++;
			} else {
				num = "";
				while (i < expression.length() && expression.charAt(i) >= 48 && expression.charAt(i) <= 57) {
					num += expression.charAt(i);
					i++;
				}
				l.add(num);
			}

		} while (i < expression.length());
		return l;

	}
	//中缀转换成后缀
	public static List<String> midtoend(List<String> ls) {
		List<String> l = new ArrayList<>();

		Stack<String> stack = new Stack<>();

		for (String item : ls) {
			if (item.matches("\\d+")) {
				l.add(item);
			}
			else if ("(".equals(item)) {
				stack.add(item);
			} else if (")".equals(item)) {
				while (!stack.peek().equals("(")) {
					l.add(stack.pop());
				}
				stack.pop();
			} 
			else   {
				 while (stack.size() != 0&&operrity(stack.peek()) >= operrity(item)) {
						l.add(stack.pop());
						//stack.push(item);
					}
						stack.push(item);
					
				}
		}
		while(stack.size()!=0){
			l.add(stack.pop());
		}
		
		return l;

	}

	// 判断运算符优先级
	public static int operrity(String p) {
		if ("*".equals(p) || "/".equals(p)) {
			return 2;
		}
		if ("+".equals(p) || "-".equals(p)) {
			return 1;
		}
		return 0;
	}
    //对后缀表达式进行计算
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
