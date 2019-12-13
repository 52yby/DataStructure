package com.dyg.datestucture.Queue;

import java.util.Scanner;
/*数据结构知识：环形队列可重用
 * @author  dyg
 * */
public class CritleArrayQueue {

	private int front;
	private int rear;

	private int maxSize;
	private int arr[];

	public CritleArrayQueue(int Size) {
		maxSize = Size;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int data) {
		if (isFull()) {
			System.out.println("队列满了！！！！");
			return;
		}
		arr[rear] = data;
		rear = (rear + 1) % maxSize;
	}
	
	public  int  removeQueue(){
		if(isEmpty()){
			throw  new  RuntimeException("队列为空");
		}
		int  value=arr[front];
		front=(front+1)%maxSize;
		return  value;	
	}
	public int  DataSize(){
		return  (rear-front+maxSize)%maxSize;
	}
	public int  headQueue(){
		return  arr[front];
	}
    public void  showQueue(){
    	if(isEmpty()){
			throw  new  RuntimeException("队列为空");
		}
    	for(int i=front;i<front+DataSize();i++){
    		System.out.println("数据是："+arr[i%maxSize]);
    	}
    }
    
	public static void main(String[] args) {
		CritleArrayQueue queue = new CritleArrayQueue(4);
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
				System.out.println("程序结束");
				break;

			default:
				break;
			}
			
		}

	}
}
