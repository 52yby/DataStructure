package com.dyg.datestucture.recursion;

/*java  ʵ�ֵݹ�  ��Ҫ��ʵ�����������ѭ��������
@author   dyg
�ݹ�1��ִ��һ������������һ��������ջ�ռ�
2���������ڲ��Ļ����������Ͳ�����
3�������������������ݻṲ��
4���ݹ�������˳������������������StackOverflowError (ջ�������)��������
5����ִ����һ�������󣬷��ص����ߡ�
*/
public class Recursion {

	public static void main(String[] args) {
		/*
		 * System.out.println(method2(4)); method1(4);
		 */
		// list(createmap());
		/*System.out.println("");
		int map[][] = createmap();
		move(map, 1, 1);
		list(map);*/
	
		queen(0);
		System.out.println(count);
	}

	// �ݹ鰸��1
	public static void method1(int n) {
		if (n > 2) {
			method1(n - 1);
		}
		System.out.println(n);
	}

	// �ݹ鰸��2
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

	// �ݹ鰸��3 ���Թ�
	public static boolean move(int arr[][], int col, int row) {
		if (arr[8][6] == 2) {
			return true;
		} else {
			if (arr[col][row] == 0) {
				arr[col][row] = 2;
				if (move(arr, col + 1, row)) {
					return true;
				} else if (move(arr, col, row + 1)) {
					return true;
				} else if (move(arr, col - 1, row - 1)) {
					return true;
				} else if (move(arr, col, row - 1)) {
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

	// ��ʼ���Թ���ͼ
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

	static int count = 0;// 8�ʺ�Ľ���ܺ�
	static int maxsize=8;
	static  int arr[]= new  int[maxsize];// ���8�ʺ�Ľ�����±��ʾ�У�arr[i]��ʾ��
	// ����4-- 8�ʺ�����
	public static  void queen(int n) {
		if(n==8){
			listqueen();
			return;
		}
		for (int i = 0; i < maxsize; i++) {
			arr[n] = i;
			if (ismove(n)) {
				queen(n + 1);
			}
		}

	}

	// �жϵ�ǰ��
	public static boolean ismove(int n) {
		for (int i = 0; i < n; i++) {
			if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
				return false;
			}
		}
		return true;
	}

	public static void listqueen() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();

	}

}
