package com.dyg.datestucture;
/*���ݽṹ֪ʶ��������
 * @author  dyg
 * */
public class SingleLinkedList {

	HeroNode head = new HeroNode(0, "", "");
   //��������β��
	public void addNode(HeroNode hero) {
		HeroNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = hero;
	}
  //�޸�����Ԫ��
	public void updateNode(HeroNode hero) {
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
  //ɾ������Ԫ��
	public void deleteNode(HeroNode hero) {
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
			temp.next = temp.next.next;
		}

	}
    //ͳ��������Ч����
	public int nodeSize() {
		HeroNode temp = head;
		int size = 0;
		while (temp.next != null) {
			size++;
			temp = temp.next;
		}
		return size;

	}
   //���������⣬��ȡ��������k������
	public HeroNode getnode(int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize() < k) {
			System.out.println("��������ݴ���");
		}
		while (temp != null) {
			size++;

			if ((nodeSize() - k + 1) == size) {
				break;
			}
			temp = temp.next;
		}
		return temp;
	}
   //���밴��˳��
	public void addNodeOrder(HeroNode hero) {
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
   //�鿴����
	public void list() {
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

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heNode1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode heNode2 = new HeroNode(2, "����", "�Ƕ���");
		HeroNode heNode3 = new HeroNode(3, "����ʤ", "������");
		HeroNode heNode5 = new HeroNode(3, "����ʤ", "11������");
		HeroNode heNode4 = new HeroNode(4, "��ʤ", "��");

		singleLinkedList.addNodeOrder(heNode4);
		singleLinkedList.addNodeOrder(heNode1);
		singleLinkedList.addNodeOrder(heNode3);
		// singleLinkedList.addNodeOrder(heNode3);
		singleLinkedList.addNodeOrder(heNode2);

		singleLinkedList.list();
		singleLinkedList.updateNode(heNode5);
		singleLinkedList.deleteNode(heNode2);
		singleLinkedList.list();
		System.out.println(singleLinkedList.nodeSize());
		System.out.println(singleLinkedList.getnode(13));
	}
}

class HeroNode {
	int no;
	String name;
	String nickname;
	HeroNode next;

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ", next=" + next + "]";
	}

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

}
