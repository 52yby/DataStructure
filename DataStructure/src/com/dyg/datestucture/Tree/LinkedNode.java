package com.dyg.datestucture.Tree;

public class LinkedNode {

	private int no;
	private String name;
	private LinkedNode left;
	private LinkedNode right;
	private int lefttype;
	private int righttype;
	private LinkedNode pre = null;

	private LinkedNode parent;

	public LinkedNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "LinkedNode [no=" + no + ", name=" + name + "]";
	}

	
	public LinkedNode getParent() {
		return parent;
	}

	public void setParent(LinkedNode parent) {
		this.parent = parent;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedNode getLeft() {
		return left;
	}

	public void setLeft(LinkedNode left) {
		this.left = left;
	}

	public LinkedNode getRight() {
		return right;
	}

	public void setRight(LinkedNode right) {
		this.right = right;
	}

	public int getLefttype() {
		return lefttype;
	}

	public void setLefttype(int lefttype) {
		this.lefttype = lefttype;
	}

	public int getRighttype() {
		return righttype;
	}

	public void setRighttype(int righttype) {
		this.righttype = righttype;
	}
   //线索化中序二叉树
	public void threadmidNode(LinkedNode node) {

		if (node == null) {
			return;
		}
		if (node.left != null) {
			threadmidNode(node.left);
		}
		if (node.left == null) {
			node.setLeft(pre);
			node.setLefttype(1);
		}
		if (pre != null && pre.right == null) {
			pre.setRight(node);
			pre.setRighttype(1);
		}
		pre = node;
		if (node.right != null) {
			threadmidNode(node.right);
		}

	}
	//线索化前序二叉树
	public void threadporNode(LinkedNode node) {
		// 如果node==null, 不能线索化
		if (node == null) {
			return;
		}
		// 左指针为空,将左指针指向前驱节点
		// 8结点的.left = 上一个节点 , 8结点的.leftType = 1
		if (node.getLeft() == null) {
			// 让当前结点的左指针指向前驱结点
			node.setLeft(pre);
			// 修改当前结点的左指针的类型,指向前驱结点
			node.setLefttype(1);
		}
		// 处理后继结点,是下一次进行处理，有点不好理解
		if (pre != null && pre.getRight() == null) {
			// 让前驱结点的右指针指向当前结点
			pre.setRight(node);
			// 修改前驱结点的右指针类型
			pre.setRighttype(1);
		}
		// !!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
		pre = node;
		// (一)先线索化左子树
		if (node.getLefttype() != 1) {
			threadporNode(node.getLeft());
		}
		// (三)再线索化右子树
		if (node.getRighttype() != 1) {
			threadporNode(node.getRight());
		}

	}
	//线索化后序二叉树
	public void threadendNode(LinkedNode node) {

		// 如果node==null, 不能线索化
		if (node == null) {
			return;
		}
		threadporNode(node.getLeft());
		threadporNode(node.getRight());
		// 左指针为空,将左指针指向前驱节点
		// 8结点的.left = 上一个节点 , 8结点的.leftType = 1
		if (node.getLeft() == null) {
			// 让当前结点的左指针指向前驱结点
			node.setLeft(pre);
			// 修改当前结点的左指针的类型,指向前驱结点
			node.setLefttype(1);
		}
		// 处理后继结点,是下一次进行处理，有点不好理解
		if (pre != null && pre.getRight() == null) {
			// 让前驱结点的右指针指向当前结点
			pre.setRight(node);
			// 修改前驱结点的右指针类型
			pre.setRighttype(1);
		}
		// !!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
		pre = node;

	}
    //前序查找
	public LinkedNode porSearch(int n) {
		int i = 1;
		System.out.println("pro第" + (i++) + "次查找");
		if (this.no == n) {
			return this;
		}
		LinkedNode node = null;
		if (this.left != null) {
			node = this.left.porSearch(n);
		}
		if (node != null) {
			return node;
		}
		if (this.right != null) {
			node = this.right.porSearch(n);
		}
		return node;

	}
   //中序查找
	public LinkedNode midSearch(int n) {

		LinkedNode node = null;
		if (this.left != null) {
			node = this.left.midSearch(n);
		}
		if (node != null) {
			return node;
		}
		System.out.println("mid查找");
		if (this.no == n) {
			return this;
		}

		if (this.right != null) {
			node = this.right.midSearch(n);
		}
		return node;
	}
    //后序查找
	public LinkedNode endSearch(int n) {
		int i = 1;

		LinkedNode node = null;
		if (this.left != null) {
			node = this.left.endSearch(n);
		}
		if (node != null) {
			return node;
		}

		if (this.right != null) {
			node = this.right.endSearch(n);
		}
		if (node != null) {
			return node;
		}
		System.out.println("end第" + (i++) + "次查找");
		if (this.no == n) {
			return this;
		}

		return node;
	}
  //前序遍历
	public void porList() {
		System.out.println(this);
		if (this.left != null) {
			this.left.porList();
		}
		if (this.right != null) {
			this.right.porList();
		}

	}
    //中序遍历
	public void midList() {
		if (this.left != null) {
			this.left.midList();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midList();
		}
	}
   //后序遍历
	public void endList() {
		if (this.left != null) {
			this.left.endList();
		}

		if (this.right != null) {
			this.right.endList();
		}
		System.out.println(this);
	}
   //删除
	public void delno(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delno(no);
		}
		if (this.right != null) {
			this.right.delno(no);
		}

	}
}
