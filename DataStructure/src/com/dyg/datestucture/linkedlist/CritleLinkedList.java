package com.dyg.datestucture.linkedlist;

/*java ʵ�ֵ���������
 * @author  dyg
*/
public class CritleLinkedList {
    //������������
	public CritleLinkedNode CreateCritleLinkedList(int k) {
		CritleLinkedNode first = null;
		CritleLinkedNode cur = null;
		if (k < 1) {
			throw new RuntimeException("������󣡣���");
		}
		for (int i = 1; i <= k; i++) {
			CritleLinkedNode node = new CritleLinkedNode(i);
			if (i == 1) {
				first = node;
				first.next = first;
				cur = first;
			} else {
				cur.next = node;
				node.next = first;
				cur = node;
			}

		}
		return first;

	}

	
   //�����������
	public void showCritleLinkedListBetch(CritleLinkedNode node) {
		CritleLinkedNode temp = node;
		while (true) {
			System.out.println(temp);
			if (temp.next == node) {
				break;
			}
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		CritleLinkedList critleLinkedList = new CritleLinkedList();
		CritleLinkedNode node = critleLinkedList.CreateCritleLinkedList(5);
		//CritleLinkedNode node1 = critleLinkedList.CreateCritleLinkedList(node, new CritleLinkedNode(7));
		critleLinkedList.showCritleLinkedListBetch(node);
	}
}

class CritleLinkedNode {

	int n;
	CritleLinkedNode next;

	@Override
	public String toString() {
		return "CritleLinkedNode [n=" + n + "]";
	}

	public CritleLinkedNode(int n) {
		this.n = n;
	}

}
