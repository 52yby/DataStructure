package com.dyg.datestucture.hash;

public class EmpLinkedlist {
	Employee head;

	public void add(Employee emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Employee cur = head;
		boolean falg = false;
	
		while (true) {
			if (cur.next==null) {
				break;
			}
			if (cur.getId() == emp.getId()) {
				falg = true;
				break;
			}
			cur = cur.getNext();
		}
		if (cur.getId() == emp.getId()) {
			falg = true;
		}
		if (falg) {
			cur.setName(emp.getName());
		} else {
			cur.next=emp;
		}
	}

	public void del(int no) {
		if (head == null) {
			System.out.println("链表为空");
			return;
		}
		boolean falg = false;
		Employee cur = head;
		if (cur.getId() == no) {
			cur=cur.next;
			head=cur;
			return;
		}
		while (cur.next != null) {
			if (cur.next.getId() == no) {
				falg = true;
				break;
			}
			cur = cur.getNext();
		}
		if (falg) {
			cur.next=cur.next.next;
		} else {
			System.out.println("元素不存在");
		}
	}

	public void list(int i) {
		if (head == null) {
			System.out.println("第" + i + "条链表为空");
			return;
		}
		System.out.println("第" + i + "条链表数据是");
		Employee cur = head;
		while (cur != null) {
			System.out.println("工号" + cur.getId() + "姓名" + cur.getName());
			cur = cur.getNext();
		}

	}

	public void update(Employee emp) {
		if (head == null) {
			System.out.println("链表为空");
			return;
		}
		Employee cur = head;
		boolean falg = false;
		while (cur!= null) {
			if (cur.getId() == emp.getId()) {
				falg = true;
				break;
			}
			cur = cur.getNext();
		}
		if (falg) {
			cur.setName(emp.getName());
		} else {
			System.out.println("元素不存在");
		}

	}

	public Employee get(int no) {
		if (head == null) {
			return null;
		}
		Employee cur = head;
		while (cur != null) {
			if (cur.getId() == no) {
				break;
			}
			cur = cur.getNext();
		}
		return cur;
	}
}
