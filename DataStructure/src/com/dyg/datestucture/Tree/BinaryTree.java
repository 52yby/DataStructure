package com.dyg.datestucture.Tree;
/*@auhtor dyg
 * java ʵ�ֶ�����  ����,����ɾ������������
*/
public class BinaryTree {
	LinkedNode root;
	private int[] arr;

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public void threadmidNode() {
		root.threadmidNode(root);
	}
	public void threadporNode() {
		root.threadporNode(root);
	}
	public void threadendNode() {
		root.threadendNode(root);
	}

	public void setRoot(LinkedNode root) {
		this.root = root;
	}
    //�������������������
	public void threadmidNodeList() {
		LinkedNode node = root;
		while (node != null) {
			while (node.getLefttype() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while (node.getRighttype() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}

	}
	private LinkedNode pre = null;
	//�������������������
	public  void  threadendNodeList(){
		 //1���Һ��������ʽ��ʼ�Ľڵ�
        LinkedNode node = root;
        while ( node != null && node.getLefttype() == 0 ) {
            node = node.getLeft();
        }
        while ( node != null ) {
            //�ҽڵ�������
            if (node.getRighttype() == 1) {
                System.out.println(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //����ϸ�����Ľڵ��ǵ�ǰ�ڵ���ҽڵ�
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //�������ڵ�Ľ������ҵ�������������ڵ�
                    node = node.getRight();
                    while ( node != null && node.getLefttype() == 0 ) {
                        node = node.getLeft();
                    }
                }
            }
        }
	}
	//����������ǰ�������
	public void threadporNodeList() {
		LinkedNode node = root;
		while (node != null) {
			while (node.getLefttype() == 0) {
				System.out.println(node);
				node = node.getLeft();
			}
			System.out.println(node);
			node = node.getRight();
		}

	}
	//�����Զ�����ǰ�����
	public void arrtoporTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("����Ϊ��");
		}

		System.out.println(arr[index]);
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}

	}
	//�����Զ������������
	public void arrtomidTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("����Ϊ��");
		}
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		System.out.println(arr[index]);
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}
	}
	//�����Զ������������
	public void arrtoendTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("����Ϊ��");
		}
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}
		System.out.println(arr[index]);
	}
	//ǰ�����������
	public void porList() {
		root.porList();
	}
	//�������������
	public void midList() {
		root.midList();
	}
	//�������������
	public void endList() {
		root.endList();
	}
	//�������������
	public LinkedNode endSearch(int n) {
		return root.endSearch(n);
	}
	//�������������
	public LinkedNode midSearch(int n) {
		return root.midSearch(n);
	}
	//ǰ����Ҷ�����
	public LinkedNode porSearch(int n) {
		return root.porSearch(n);
	}
  //ɾ��
	public void del(int n) {
		if (root == null) {
			System.out.println("��Ϊ�գ�����");
		} else {
			if (root.getNo() == n) {
				root = null;
			} else {
				root.delno(n);
			}
		}
	}

	public static void main(String[] args) {
		LinkedNode l1 = new LinkedNode(1, "node1");
		LinkedNode l2 = new LinkedNode(2, "node2");
		LinkedNode l3 = new LinkedNode(3, "node3");
		LinkedNode l4 = new LinkedNode(4, "node4");
		LinkedNode l5 = new LinkedNode(5, "node5");
		LinkedNode l6 = new LinkedNode(6, "node6");
		LinkedNode l7 = new LinkedNode(7, "node7");
		
		l1.setLeft(l3);
		l1.setRight(l5);
		l3.setLeft(l2);
		l3.setRight(l4);
		l5.setLeft(l7);
		l5.setRight(l6);
		l3.setParent(l1);
		l5.setParent(l1);
		l2.setParent(l3);
		l4.setParent(l3);
		l7.setParent(l5);
		l6.setParent(l5);
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(l1);
		/*
		 * binaryTree.porList(); System.out.println("����"); binaryTree.midList();
		 * System.out.println("����"); binaryTree.endList();
		 * System.out.println("ǰ��");
		 * System.out.println(binaryTree.porSearch(5));
		 * System.out.println(binaryTree.endSearch(4));
		 * System.out.println(binaryTree.midSearch(3));
		 */

//		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
//		binaryTree.setArr(arr);
//		binaryTree.arrtomidTree(0);
		//binaryTree.endList();//2437651
		binaryTree.threadendNode();
		//System.out.println(l4.getRight());
	
		 binaryTree.threadendNodeList();
	}
}
