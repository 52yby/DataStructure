package com.dyg.datestucture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*数据结构知识：稀疏数组
 * 1.数组——稀疏数组
 * 2.稀疏数组——数组
 * 3.稀疏数组——文件
 * 4.文件——稀疏数组
 * @author  dyg
 * */
public class SparseArray {
	// 数组转成稀疏数组
	public static int[][] ArrayToSpase(int Array[][]) {
		int sum = 0;
		for (int row[] : Array) {
			for (int data : row) {
				if (data != 0) {
					sum++;
				}
			}
		}
		int SparseArray[][] = new int[sum + 1][3];
		SparseArray[0][0] = Array.length;
		SparseArray[0][1] = Array[0].length;
		SparseArray[0][2] = sum;
		int count = 0;
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				if (Array[i][j] != 0) {
					count++;
					SparseArray[count][0] = i;
					SparseArray[count][1] = j;
					SparseArray[count][2] = Array[i][j];
				}
			}
		}

		return SparseArray;
	}

	// 稀疏数组to数组
	public static int[][] SpaseToArray(int SparseArray[][]) {
		int Array[][] = new int[SparseArray[0][0]][SparseArray[0][1]];
		for (int i = 1; i < SparseArray.length; i++) {
			Array[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
		}
		return Array;
	}

	// 遍历数组
	public static void TraverseArray(int Array[][]) {
		for (int row[] : Array) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

	// 稀疏数组写入文件
	public static int ArrayToFile(int Array[][]) throws Exception {
		int    r=0;
		
		try {
			/* 写入Txt文件 */
			File writename = new File("C:\\Users\\LENOVO\\Desktop\\DataSource\\array.data"); // 相对路径，如果没有则要建立一个新的output。txt文件

			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for (int i = 0; i < Array.length; i++) {
				for (int j = 0; j < Array[i].length; j++) {
					out.write(Array[i][j] + "#"); // \r\n即为换行
				}
			}

			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
			return  r;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r=1;
			return r;
		}
	}
    //解析文件生成稀疏数组
	public static int[][] FileToArray() throws Exception {
		int Array[][] = null;
		try {
			File file = new File("C:\\Users\\LENOVO\\Desktop\\DataSource\\array.data");
			FileReader reader = new FileReader(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(reader);
			String line = "";

			line = br.readLine();

			String data[] = line.split("#");
			Array = new int[data.length/3][3];
			for (int i = 0; i < data.length; i++) {
				Array[i / 3][i % 3] = Integer.parseInt(data[i]);
			}

			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Array;

	}
    //测试
	public static void main(String[] args) throws Exception {
		int Array[][] = new int[10][5];
		Array[2][3] = 7;
		Array[1][1] = 3;
		Array[4][3] = 3;
		Array[8][4] = 5;
		System.out.println("原数组：");
		SparseArray.TraverseArray(Array);
		int sparseArray[][] = SparseArray.ArrayToSpase(Array);
		System.out.println("稀疏数组：");
		SparseArray.TraverseArray(sparseArray);
		SparseArray.FileToArray();
		System.out.println("再次的到原数组：");
		SparseArray.TraverseArray(SparseArray.SpaseToArray(sparseArray));
		System.out.println("写入文件：");
		int i=SparseArray.ArrayToFile(sparseArray);
		if(i==0){System.out.println("成功");}else{System.out.println("失败");}
		System.out.println("读取文件的数组：");
	     SparseArray.TraverseArray(SparseArray.FileToArray());;

	}
}
