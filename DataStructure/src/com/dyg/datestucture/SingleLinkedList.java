package com.dyg.datestucture;
/*数据结构知识：单链表
 * @author  dyg
 * */
public class SingleLinkedList {

	HeroNode head = new HeroNode(0, "", "");
   //插入链表尾部
	public void addNode(HeroNode hero) {
		HeroNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = hero;
	}
  //修改链表元素
	public void updateNode(HeroNode hero) {
		boolean loop = true;
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("链表为空！！！！");
		}
		while (temp.next != null) {
			if (temp.next.no == hero.no) {
				loop = false;
				break;
			}
			temp = temp.next;
		}
		if (loop) {
			System.out.println("数据不存在");
		} else {
			temp.next.name = hero.name;
			temp.next.nickname = hero.nickname;
		}

	}
  //删除链表元素
	public void deleteNode(HeroNode hero) {
		boolean loop = true;
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("链表为空！！！！");
		}
		while (temp.next != null) {
			if (temp.next.no == hero.no) {
				loop = false;
				break;
			}
			temp = temp.next;
		}
		if (loop) {
			System.out.println("数据不存在");
		} else {
			temp.next = temp.next.next;
		}

	}
    //统计链表有效个数
	public int nodeSize() {
		HeroNode temp = head;
		int size = 0;
		while (temp.next != null) {
			size++;
			temp = temp.next;
		}
		return size;

	}
   //新浪面试题，获取链表倒数第k个数据
	public HeroNode getnode(int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize() < k) {
			System.out.println("输入的数据错误");
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
   //插入按照顺序
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
			System.out.println("插入数据编号存在！！！");
		} else {
			hero.next = temp.next;
			temp.next = hero;
		}

	}
   //查看链表
	public void list() {
		HeroNode temp = head.next;
		if (temp == null) {
			System.out.println("链表为空！！！！");
			return;
		}
		while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heNode1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode heNode2 = new HeroNode(2, "吴用", "智多星");
		HeroNode heNode3 = new HeroNode(3, "公孙胜", "入云龙");
		HeroNode heNode5 = new HeroNode(3, "公孙胜", "11入云龙");
		HeroNode heNode4 = new HeroNode(4, "关胜", "大刀");

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
