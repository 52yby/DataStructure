package com.dyg.datestucture.Queue;

import java.util.Scanner;
/*���ݽṹ֪ʶ�����ζ��п�����
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
			System.out.println("�������ˣ�������");
			return;
		}
		arr[rear] = data;
		rear = (rear + 1) % maxSize;
	}
	
	public  int  removeQueue(){
		if(isEmpty()){
			throw  new  RuntimeException("����Ϊ��");
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
			throw  new  RuntimeException("����Ϊ��");
		}
    	for(int i=front;i<front+DataSize();i++){
    		System.out.println("�����ǣ�"+arr[i%maxSize]);
    	}
    }
    
	public static void main(String[] args) {
		CritleArrayQueue queue = new CritleArrayQueue(4);
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
				System.out.println("�������");
				break;

			default:
				break;
			}
			
		}

	}
}
