package com.dyg.datestucture.recursion;
/*java  实现递归
@author   dyg
递归1、执行一个方法，建立一个保护的栈空间
2、方法的内部的基本数据类型不共享
3、方法的引用类型数据会共享
4、递归必须向退出条件靠近，否则出现StackOverflowError (栈溢出问题)，死归了
5、当执行完一个方法后，返回调用者。
*/
public class Recursion {

	public static void main(String[] args) {
		/*
		 * System.out.println(method2(4)); method1(4);
		 */
	//	list(createmap());
		System.out.println("");
		int  map[][]=createmap();
		move(map, 1, 1);
		list(map);
	}
     
	//递归案例1
	public static void method1(int n) {
		if (n > 2) {
			method1(n - 1);
		}
		System.out.println(n);
	}
	//递归案例2
	public static int method2(int n) {
		if (n == 1) {
			return n;
		} else {
			return method2(n - 1) * n;
		}
	}

	public static void list(int arr[][]) {
		for (int item[] : arr) {
			for (int data : item) {
				System.out.print(data);
			}
			System.out.println();
		}
	}
	//递归案例3 走迷宫
	public static boolean move(int arr[][], int col, int row) {
		if (arr[8][6] == 2) {
			return true;
		} else {
			if (arr[col][row] == 0) {
				arr[col][row] = 2;
				if (move(arr, col +1, row)) {
					return true;
				} else if (move(arr, col , row+1)) {
					return true;
				} else if (move(arr, col-1, row - 1)) {
					return true;
				} else if (move(arr, col, row -1)) {
					return true;
				} else {
					arr[col][row] = 3;
					return false;
				}
			} else {
				return false;
			}
		}

	}

	public static int[][] createmap() {
		int arr[][] = new int[10][8];

		for (int i = 0; i < 10; i++) {
			arr[i][0] = 1;
			arr[i][7] = 1;
		}
		for (int j = 0; j < 8; j++) {
			arr[0][j] = 1;
			arr[9][j] = 1;
		}
		arr[3][1] = 1;
		arr[3][2] = 1;
		return arr;
	}
}
