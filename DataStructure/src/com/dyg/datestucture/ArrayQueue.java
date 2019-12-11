package com.dyg.datestucture;

import java.util.Scanner;
/*数据结构知识：队列一次性不可重用
 * @author  dyg
 * */
public class ArrayQueue {
	public static void main(String[] args) {
		FirstArrayQueue queue = new FirstArrayQueue(4);
		char a;
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("s:查看队列");
			System.out.println("a:进入队列");
			System.out.println("r:移出队列");
			System.out.println("h:查看队定数据");
			System.out.println("e:退出");
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
				System.out.println("输入一个数");
				int data = sc.nextInt();

				queue.addQueue(data);
				break;
			case 'r':
				try {
				int  res=	queue.removeQueue();
				System.out.println("移出数据+"+res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;

			case 'h':
				try {
				int  d=	queue.headQueue();
					System.out.println("队列顶+"+d);
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
			System.out.println("程序结束");
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
			System.out.println("队列满了，无法加入");
			return;
		}
		rear=rear+1;
		arr[rear] = data;
	}

	public int removeQueue() {

		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法再次去出数据");
			
		}
		return arr[++front];
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front +1];
	}

	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		for (int data : arr) {
			System.out.println(data);
		}
	}

}
