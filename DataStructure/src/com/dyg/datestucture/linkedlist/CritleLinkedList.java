package com.dyg.datestucture.linkedlist;

/*java ʵ�ֵ���������
 * @author  dyg
*/
public class CritleLinkedList {
	// ������������
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

	// �����������
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

	// ����������
	public int CritleLinkedListsize(CritleLinkedNode node) {
		CritleLinkedNode temp = node;
		int size = 0;
		while (true) {
			size++;
			if (temp.next == node) {
				break;
			}
			temp = temp.next;
		}
		return size;
	}

	// Լ�������
	/*@param  start ��ʼ����λ��
	 *@param  count ���ĸ���
	 *@param  node ��������
	 * */
	public void JonsephuQuestion(int start, int count, CritleLinkedNode node) {
		if (node == null || start < 1 || count > CritleLinkedListsize(node)) {
			System.out.println("�������������");
			return;
		}
		CritleLinkedNode cur = node;//����ָ��ָ��Ҫ����ǰһ��
		while (cur.next != node) {
			cur = cur.next;
		}
		//�Ƚ�����ָ���node�ƶ���Ҫ����λ��
		for (int i = 0; i < start - 1; i++) {
			cur = cur.next;
			node = node.next;
		}
		while (true) {
			//�����˽���
			if (cur == node) {
				System.out.println(cur);
				break;
			}//���������ڵ��ƶ�
			for (int i = 0; i < count - 1; i++) {
				cur = cur.next;
				node = node.next;
			}//��ӡ������Ľڵ�
			System.out.println(node);
			//�Ƴ�����
			node = node.next;
			cur.next = node;
		}
	}

	public static void main(String[] args) {
		CritleLinkedList critleLinkedList = new CritleLinkedList();
		CritleLinkedNode node = critleLinkedList.CreateCritleLinkedList(5);
		// CritleLinkedNode node1 =
		// critleLinkedList.CreateCritleLinkedList(node, new
		// CritleLinkedNode(7));
		//critleLinkedList.showCritleLinkedListBetch(node);
		critleLinkedList.JonsephuQuestion(1, 5, node);
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
