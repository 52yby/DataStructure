package com.dyg.datestucture.linkedlist;

/*java 实现单向环形链表
 * @author  dyg
*/
public class CritleLinkedList {
	// 创建环形链表
	public CritleLinkedNode CreateCritleLinkedList(int k) {
		CritleLinkedNode first = null;
		CritleLinkedNode cur = null;
		if (k < 1) {
			throw new RuntimeException("输入错误！！！");
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

	// 输出环形链表
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

	// 环形链表长度
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

	// 约舍夫问题
	/*@param  start 开始数的位置
	 *@param  count 数的个数
	 *@param  node 环形链表
	 * */
	public void JonsephuQuestion(int start, int count, CritleLinkedNode node) {
		if (node == null || start < 1 || count > CritleLinkedListsize(node)) {
			System.out.println("输入出错！！！！");
			return;
		}
		CritleLinkedNode cur = node;//辅助指针指在要数的前一个
		while (cur.next != node) {
			cur = cur.next;
		}
		//先将辅助指针和node移动到要数的位置
		for (int i = 0; i < start - 1; i++) {
			cur = cur.next;
			node = node.next;
		}
		while (true) {
			//输完了结束
			if (cur == node) {
				System.out.println(cur);
				break;
			}//进行数数节点移动
			for (int i = 0; i < count - 1; i++) {
				cur = cur.next;
				node = node.next;
			}//打印出链表的节点
			System.out.println(node);
			//移出链表
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
