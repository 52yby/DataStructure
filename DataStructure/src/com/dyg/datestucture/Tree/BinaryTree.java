package com.dyg.datestucture.Tree;
/*@auhtor dyg
 * java 实现二叉树  遍历,查找删除，线索化。
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
    //遍历线索化中序二叉树
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
	//遍历线索化后序二叉树
	public  void  threadendNodeList(){
		 //1、找后序遍历方式开始的节点
        LinkedNode node = root;
        while ( node != null && node.getLefttype() == 0 ) {
            node = node.getLeft();
        }
        while ( node != null ) {
            //右节点是线索
            if (node.getRighttype() == 1) {
                System.out.println(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while ( node != null && node.getLefttype() == 0 ) {
                        node = node.getLeft();
                    }
                }
            }
        }
	}
	//遍历线索化前序二叉树
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
	//数组以二叉树前序输出
	public void arrtoporTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("数组为空");
		}

		System.out.println(arr[index]);
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}

	}
	//数组以二叉树中序输出
	public void arrtomidTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("数组为空");
		}
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		System.out.println(arr[index]);
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}
	}
	//数组以二叉树后序输出
	public void arrtoendTree(int index) {
		if (arr.length == 0 && arr == null) {
			System.out.println("数组为空");
		}
		if ((index * 2 + 1) < arr.length) {
			arrtoporTree(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			arrtoporTree(index * 2 + 2);
		}
		System.out.println(arr[index]);
	}
	//前序遍历二叉树
	public void porList() {
		root.porList();
	}
	//中序遍历二叉树
	public void midList() {
		root.midList();
	}
	//后序遍历二叉树
	public void endList() {
		root.endList();
	}
	//后序遍历二叉树
	public LinkedNode endSearch(int n) {
		return root.endSearch(n);
	}
	//中序遍历二叉树
	public LinkedNode midSearch(int n) {
		return root.midSearch(n);
	}
	//前序查找二叉树
	public LinkedNode porSearch(int n) {
		return root.porSearch(n);
	}
  //删除
	public void del(int n) {
		if (root == null) {
			System.out.println("树为空！！！");
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
		 * binaryTree.porList(); System.out.println("中序"); binaryTree.midList();
		 * System.out.println("后序"); binaryTree.endList();
		 * System.out.println("前序");
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
