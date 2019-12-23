package com.dyg.datestucture.hash;

import java.util.Scanner;

public class HashTable {

	int size;
	EmpLinkedlist[] linkedlists;

	public HashTable(int size) {
		super();
		this.size = size;
		linkedlists = new EmpLinkedlist[size];
		for (int i = 0; i < linkedlists.length; i++) {
			linkedlists[i] = new EmpLinkedlist();
		}
	}

	public int funhashcoe(int n) {
		return n % size;
	}

	public void add(Employee emp) {
		int index = funhashcoe(emp.getId());
		linkedlists[index].add(emp);
	}

	public void del(int no) {
		int index = funhashcoe(no);
		linkedlists[index].del(no);
	}

	public Employee get(int no) {
		int index = funhashcoe(no);
		return linkedlists[index].get(no);
	}

	public void update(Employee emp) {
		int index = funhashcoe(emp.getId());
		linkedlists[index].update(emp);
	}

	public void list() {
		for (int i = 0; i < linkedlists.length; i++) {
			linkedlists[i].list(i + 1);
		}
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(8);
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			
			System.out.println("add ���");
			System.out.println("upd  �޸�");
			System.out.println("del ɾ��");
			System.out.println("get ����");
			System.out.println("list ����");
			System.out.println("exit �˳�");
			String key = sc.next();
			switch (key) {
			case "add":
				System.out.println("����Ա���ţ�");
				int no = sc.nextInt();
				System.out.println("����Ա��������");
				String name = sc.next();
				Employee emp = new Employee(no, name);
				hashTable.add(emp);
				break;
			case "del":
				System.out.println("����Ա���ţ�");
				no = sc.nextInt();
				hashTable.del(no);
				break;
			case "upd":
				System.out.println("����Ա���ţ�");
				no = sc.nextInt();
				System.out.println("����Ա��������");
				name = sc.next();
				emp = new Employee(no, name);
				hashTable.update(emp);
				;
				break;
			case "get":
				System.out.println("����Ա���ţ�");
				no = sc.nextInt();
				System.out.println(hashTable.get(no).getId() + " " + hashTable.get(no).getName());
				break;
			case "list":
				hashTable.list();
				break;
			case "exit":
				loop=false;
				System.out.println("exit");
				sc.close();
				break;

			default:
				break;
			}
		}
	}
}
