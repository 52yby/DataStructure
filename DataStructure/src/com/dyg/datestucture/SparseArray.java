package com.dyg.datestucture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*���ݽṹ֪ʶ��ϡ������
 * 1.���顪��ϡ������
 * 2.ϡ�����顪������
 * 3.ϡ�����顪���ļ�
 * 4.�ļ�����ϡ������
 * @author  dyg
 * */
public class SparseArray {
	// ����ת��ϡ������
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

	// ϡ������to����
	public static int[][] SpaseToArray(int SparseArray[][]) {
		int Array[][] = new int[SparseArray[0][0]][SparseArray[0][1]];
		for (int i = 1; i < SparseArray.length; i++) {
			Array[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
		}
		return Array;
	}

	// ��������
	public static void TraverseArray(int Array[][]) {
		for (int row[] : Array) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

	// ϡ������д���ļ�
	public static int ArrayToFile(int Array[][]) throws Exception {
		int    r=0;
		
		try {
			/* д��Txt�ļ� */
			File writename = new File("C:\\Users\\LENOVO\\Desktop\\DataSource\\array.data"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�

			writename.createNewFile(); // �������ļ�
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for (int i = 0; i < Array.length; i++) {
				for (int j = 0; j < Array[i].length; j++) {
					out.write(Array[i][j] + "#"); // \r\n��Ϊ����
				}
			}

			out.flush(); // �ѻ���������ѹ���ļ�
			out.close(); // ���ǵùر��ļ�
			return  r;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r=1;
			return r;
		}
	}
    //�����ļ�����ϡ������
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
    //����
	public static void main(String[] args) throws Exception {
		int Array[][] = new int[10][5];
		Array[2][3] = 7;
		Array[1][1] = 3;
		Array[4][3] = 3;
		Array[8][4] = 5;
		System.out.println("ԭ���飺");
		SparseArray.TraverseArray(Array);
		int sparseArray[][] = SparseArray.ArrayToSpase(Array);
		System.out.println("ϡ�����飺");
		SparseArray.TraverseArray(sparseArray);
		SparseArray.FileToArray();
		System.out.println("�ٴεĵ�ԭ���飺");
		SparseArray.TraverseArray(SparseArray.SpaseToArray(sparseArray));
		System.out.println("д���ļ���");
		int i=SparseArray.ArrayToFile(sparseArray);
		if(i==0){System.out.println("�ɹ�");}else{System.out.println("ʧ��");}
		System.out.println("��ȡ�ļ������飺");
	     SparseArray.TraverseArray(SparseArray.FileToArray());;

	}
}
