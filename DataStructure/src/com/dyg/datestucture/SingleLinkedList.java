package com.dyg.datestucture;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Stack;

/*数据结构知识：单链表
 * @author  dyg
 * */
public class SingleLinkedList {

	// HeroNode head = new HeroNode(0, "", "");
	// 插入链表尾部
	public void addNode(HeroNode head, HeroNode hero) {
		HeroNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = hero;
	}

	// 修改链表元素
	public void updateNode(HeroNode head, HeroNode hero) {
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

	// 删除链表元素
	public void deleteNode(HeroNode head, int k) {
		boolean loop = true;
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("链表为空！！！！");
		}
		while (temp.next != null) {
			if (temp.next.no == k) {
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

	// 统计链表有效个数
	public int nodeSize(HeroNode head) {
		HeroNode temp = head;
		int size = 0;
		while (temp.next != null) {
			size++;
			temp = temp.next;
		}
		return size;

	}

	// 新浪面试题，获取链表倒数第k个数据
	public HeroNode getnode(HeroNode head, int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize(head) < k) {
			System.out.println("输入的数据错误");
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

	// 获取链表第k个数据
	public HeroNode getnodeasc(HeroNode head, int k) {
		HeroNode temp = head.next;

		int size = 0;
		if (nodeSize(head) < k) {
			System.out.println("输入的数据错误");
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

	// 插入按照顺序
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
			System.out.println("插入数据编号存在！！！");
		} else {
			hero.next = temp.next;
			temp.next = hero;
		}

	}

	// 查看链表
	public void list(HeroNode head) {
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

	// 百度面试题单链表反转
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

	// 腾讯面试题链表逆向输出:方法一反转链表输出，为了保证原链表的数据不变，使用深拷贝。
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

	// 腾讯面试题链表逆向输出:方法一反转链表输出，使用栈。
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
		HeroNode heNode1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode heNode2 = new HeroNode(2, "吴用", "智多星");
		HeroNode heNode3 = new HeroNode(3, "公孙胜", "入云龙");
		HeroNode cheNode3 = new HeroNode(3, "公孙胜", "11入云龙");
		HeroNode heNode4 = new HeroNode(4, "关胜", "大刀");
		HeroNode heNode5 = new HeroNode(5, "林冲", "豹子头");
		HeroNode heNode6 = new HeroNode(6, "武松", "行者");
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
		// 将对象写入流中
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(this);
		// 从流中取出
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		return (HeroNode) objectInputStream.readObject();

	}

}
