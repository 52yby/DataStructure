package com.dyg.datestucture;

import java.util.Scanner;
/*���ݽṹ֪ʶ������һ���Բ�������
 * @author  dyg
 * */
public class ArrayQueue {
	public static void main(String[] args) {
		FirstArrayQueue queue = new FirstArrayQueue(4);
		char a;
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("s:�鿴����");
			System.out.println("a:�������");
			System.out.println("r:�Ƴ�����");
			System.out.println("h:�鿴�Ӷ�����");
			System.out.println("e:�˳�");
			a = sc.next().charAt(0);
			switch (a) {
			case 's':
				try {
					queue.showQueue();
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'a':
				System.out.println("����һ����");
				int data = sc.nextInt();

				queue.addQueue(data);
				break;
			case 'r':
				try {
				int  res=	queue.removeQueue();
				System.out.println("�Ƴ�����+"+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;

			case 'h':
				try {
				int  d=	queue.headQueue();
					System.out.println("���ж�+"+d);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case 'e':
				loop = false;
				break;

			default:
				break;
			}
			System.out.println("�������");
		}

	}

}

class FirstArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int  arr[];

	public FirstArrayQueue(int size) {
		this.maxSize=size;
		arr=new int [maxSize];
		rear = -1;
		front = -1;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int data) {

		if (isFull()) {
			System.out.println("�������ˣ��޷�����");
			return;
		}
		rear=rear+1;
		arr[rear] = data;
	}

	public int removeQueue() {

		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷��ٴ�ȥ������");
			
		}
		return arr[++front];
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front +1];
	}

	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		for (int data : arr) {
			System.out.println(data);
		}
	}

}
