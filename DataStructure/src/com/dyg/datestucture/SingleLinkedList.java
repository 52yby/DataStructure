package com.dyg.datestucture;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Stack;

/*���ݽṹ֪ʶ��������
 * @author  dyg
 * */
public class SingleLinkedList {

	// HeroNode head = new HeroNode(0, "", "");
	// ��������β��
	public void addNode(HeroNode head, HeroNode hero) {
		HeroNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = hero;
	}

	// �޸�����Ԫ��
	public void updateNode(HeroNode head, HeroNode hero) {
		boolean loop = true;
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("����Ϊ�գ�������");
		}
		while (temp.next != null) {
			if (temp.next.no == hero.no) {
				loop = false;
				break;
			}
			temp = temp.next;
		}
		if (loop) {
			System.out.println("���ݲ�����");
		} else {
			temp.next.name = hero.name;
			temp.next.nickname = hero.nickname;
		}

	}

	// ɾ������Ԫ��
	public void deleteNode(HeroNode head, int k) {
		boolean loop = true;
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("����Ϊ�գ�������");
		}
		while (temp.next != null) {
			if (temp.next.no == k) {
				loop = false;
				break;
			}
			temp = temp.next;
		}
		if (loop) {
			System.out.println("���ݲ�����");
		} else {
			temp.next = temp.next.next;
		}

	}

	// ͳ��������Ч����
	public int nodeSize(HeroNode head) {
		HeroNode temp = head;
		int size = 0;
		while (temp.next != null) {
			size++;
			temp = temp.next;
		}
		return size;

	}

	// ���������⣬��ȡ��������k������
	public HeroNode getnode(HeroNode head, int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize(head) < k) {
			System.out.println("��������ݴ���");
		}
		while (temp != null) {
			size++;

			if ((nodeSize(head) - k + 1) == size) {
				break;
			}
			temp = temp.next;
		}
		return temp;
	}

	// ��ȡ�����k������
	public HeroNode getnodeasc(HeroNode head, int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize(head) < k) {
			System.out.println("��������ݴ���");
		}
		while (temp != null) {
			size++;

			if (k == size) {
				break;
			}
			temp = temp.next;
		}
		return temp;
	}

	// ���밴��˳��
	public void addNodeOrder(HeroNode head, HeroNode hero) {
		HeroNode temp = head;
		boolean loop = false;

		while (true) {
			if (temp.next == null) {
				break;
			}
			if (hero.no < temp.next.no) {
				break;
			}
			if (hero.no == temp.next.no) {
				loop = true;
				break;
			}
			temp = temp.next;
		}
		if (loop) {
			System.out.println("�������ݱ�Ŵ��ڣ�����");
		} else {
			hero.next = temp.next;
			temp.next = hero;
		}

	}

	// �鿴����
	public void list(HeroNode head) {
		HeroNode temp = head.next;
		if (temp == null) {
			System.out.println("����Ϊ�գ�������");
			return;
		}
		while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// �ٶ������ⵥ����ת
	public void fzHeroNode(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		HeroNode newhead = new HeroNode(0, "", "");
		HeroNode next = null;
		HeroNode cur = head.next;
		while (cur != null) {
			next = cur.next;
			cur.next = newhead.next;
			newhead.next = cur;
			cur = next;
		}
		head.next = newhead.next;
	}

	// ��Ѷ�����������������:����һ��ת���������Ϊ�˱�֤ԭ��������ݲ��䣬ʹ�������
	public void listHeroNodeNx(HeroNode head) throws Exception, IOException {
		if (head.next == null || head.next.next == null) {
			return;
		}
		HeroNode newhead = new HeroNode(0, "", "");
		HeroNode next = null;
		HeroNode cur = head.next.Clone();
		while (cur != null) {
			next = cur.next;
			cur.next = newhead.next;
			newhead.next = cur;
			cur = next;
		}
		while (newhead.next != null) {
			System.out.println(newhead.next);
			newhead = newhead.next;
		}
	}

	// ��Ѷ�����������������:����һ��ת���������ʹ��ջ��
	public void listHeroNodeStack(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		while (head.next != null) {
			stack.push(head.next);
			head = head.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	
	public static void main(String[] args) throws IOException, Exception {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode head1 = new HeroNode(0, "", "");
		HeroNode head2 = new HeroNode(0, "", "");
		HeroNode heNode1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode heNode2 = new HeroNode(2, "����", "�Ƕ���");
		HeroNode heNode3 = new HeroNode(3, "����ʤ", "������");
		HeroNode cheNode3 = new HeroNode(3, "����ʤ", "11������");
		HeroNode heNode4 = new HeroNode(4, "��ʤ", "��");
		HeroNode heNode5 = new HeroNode(5, "�ֳ�", "����ͷ");
		HeroNode heNode6 = new HeroNode(6, "����", "����");
		/*singleLinkedList.addNodeOrder(head1, heNode1);
		singleLinkedList.addNodeOrder(head1, heNode5);
		singleLinkedList.addNodeOrder(head1, heNode4);
		singleLinkedList.addNodeOrder(head2, heNode2);
		singleLinkedList.addNodeOrder(head2, heNode3);
		singleLinkedList.addNodeOrder(head2, heNode6);*/
		heNode1.next=heNode3;
		heNode3.next=heNode5;
		heNode2.next=heNode4;
		heNode4.next=heNode6;
		// singleLinkedList.updateNode(head2, cheNode3);
		// singleLinkedList.deleteNode(head1, 1);
		// System.out.println(singleLinkedList.nodeSize(head2));
		// System.out.println(singleLinkedList.getnodeasc(head1, 1));
		// singleLinkedList.fzHeroNode(head1);
		singleLinkedList.list(head1);
		singleLinkedList.listHeroNodeNx(head1);
		singleLinkedList.listHeroNodeStack(head1);
		
	}
}

class HeroNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int no;
	String name;
	String nickname;
	HeroNode next;

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ",next=" + next + "]";
	}

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	public HeroNode Clone() throws IOException, ClassNotFoundException {
		// ������д������
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(this);
		// ������ȡ��
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		return (HeroNode) objectInputStream.readObject();

	}

}
