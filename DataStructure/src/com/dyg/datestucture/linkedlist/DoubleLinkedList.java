package com.dyg.datestucture.linkedlist;

/*javaʵ��˫������
 * @author  dyg
*/
public class DoubleLinkedList {
   //˫������β����������
	public void addDoubleLinkedList(LinkedNode head, LinkedNode node) {
		while (head.next != null) {
			head = head.next;
		}
		head.next = node;
		node.per = head;
	}
	//˫������˳���������
	public void addDoubleLinkedListOrder(LinkedNode head, LinkedNode node) {
		boolean flag = true;
		while (true) {
			if(head.next==null){
				break;
			}
			if(head.next.no>node.no){
				break;
			}
			if(head.next.no==node.no){
				flag=false;
				break;
			}
			head=head.next;
		}
		if(flag){
			if(head.next==null){
				head.next=node;
				node.per=head;
			}
			else{
				/**˳�����ҪҪ��������ѭ��**/
				head.next.per=node;
				node.next=head.next;
				head.next=node;
				node.per=head;	
			}
		}
		else{
			System.out.println("�������ݴ��ڣ�����");
		}
		
	}
    //�鿴����
	public void showDoubleLinkedList(LinkedNode head) {
		while (head.next != null) {
			System.out.println(head.next);
			head = head.next;
		}
	}
    //�޸�����
	public void updateDoubleLinkedList(LinkedNode head, LinkedNode node) {
		boolean flag = true;
		while (head.next != null) {
			if (head.next.no == node.no) {
				flag=false;
				break;
			}
			head = head.next;
		}
		if(flag){
			System.out.println("Ҫ�޸ĵ����ݲ����ڣ�����");
		}
		else{
			head.next.name=node.name;
		}
	}
	
	//ɾ������
	public void  deleteDoubleLinkedList(LinkedNode head, int  k) {
		boolean flag = true;
		LinkedNode  temp=head.next;
		while (temp != null) {
			if (temp.no == k) {
				flag=false;
				break;
			}
			temp = temp.next;
		}
		if(flag){
			System.out.println("Ҫɾ�������ݲ����ڣ�����");
		}
		else{
			temp.per.next=temp.next;
			if(temp.next!=null){
				temp.next.per=temp.per;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
		LinkedNode head=new  LinkedNode(0, "0");
		LinkedNode  l1=new LinkedNode(1, "1");
		LinkedNode  l2=new LinkedNode(2, "2");
		LinkedNode  l3=new LinkedNode(3, "3");
		LinkedNode  l4=new LinkedNode(4, "4");
		LinkedNode  newl4=new LinkedNode(4, "node4");
		doubleLinkedList.addDoubleLinkedListOrder(head, l1);
		doubleLinkedList.addDoubleLinkedListOrder(head, l4);
		doubleLinkedList.addDoubleLinkedListOrder(head, l3);
		doubleLinkedList.addDoubleLinkedListOrder(head, l2);
		/*doubleLinkedList.updateDoubleLinkedList(head, newl4);
		doubleLinkedList.deleteDoubleLinkedList(head, 4);*/
		doubleLinkedList.showDoubleLinkedList(head);
	}
}

class LinkedNode {
	int no;
	String  name;
	LinkedNode next;
	LinkedNode per;

	@Override
	public String toString() {
		return "LinkedNode [no=" + no + ",name="+name+ "]";
	}

	public LinkedNode(int no,String name) {
		this.no = no;
		this.name=name;
	}

}
