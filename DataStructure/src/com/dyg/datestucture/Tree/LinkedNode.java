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
   //���������������
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
	//������ǰ�������
	public void threadporNode(LinkedNode node) {
		// ���node==null, ����������
		if (node == null) {
			return;
		}
		// ��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
		// 8����.left = ��һ���ڵ� , 8����.leftType = 1
		if (node.getLeft() == null) {
			// �õ�ǰ������ָ��ָ��ǰ�����
			node.setLeft(pre);
			// �޸ĵ�ǰ������ָ�������,ָ��ǰ�����
			node.setLefttype(1);
		}
		// �����̽��,����һ�ν��д����е㲻�����
		if (pre != null && pre.getRight() == null) {
			// ��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			// �޸�ǰ��������ָ������
			pre.setRighttype(1);
		}
		// !!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
		pre = node;
		// (һ)��������������
		if (node.getLefttype() != 1) {
			threadporNode(node.getLeft());
		}
		// (��)��������������
		if (node.getRighttype() != 1) {
			threadporNode(node.getRight());
		}

	}
	//���������������
	public void threadendNode(LinkedNode node) {

		// ���node==null, ����������
		if (node == null) {
			return;
		}
		threadporNode(node.getLeft());
		threadporNode(node.getRight());
		// ��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
		// 8����.left = ��һ���ڵ� , 8����.leftType = 1
		if (node.getLeft() == null) {
			// �õ�ǰ������ָ��ָ��ǰ�����
			node.setLeft(pre);
			// �޸ĵ�ǰ������ָ�������,ָ��ǰ�����
			node.setLefttype(1);
		}
		// �����̽��,����һ�ν��д����е㲻�����
		if (pre != null && pre.getRight() == null) {
			// ��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			// �޸�ǰ��������ָ������
			pre.setRighttype(1);
		}
		// !!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
		pre = node;

	}
    //ǰ�����
	public LinkedNode porSearch(int n) {
		int i = 1;
		System.out.println("pro��" + (i++) + "�β���");
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
   //�������
	public LinkedNode midSearch(int n) {

		LinkedNode node = null;
		if (this.left != null) {
			node = this.left.midSearch(n);
		}
		if (node != null) {
			return node;
		}
		System.out.println("mid����");
		if (this.no == n) {
			return this;
		}

		if (this.right != null) {
			node = this.right.midSearch(n);
		}
		return node;
	}
    //�������
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
		System.out.println("end��" + (i++) + "�β���");
		if (this.no == n) {
			return this;
		}

		return node;
	}
  //ǰ�����
	public void porList() {
		System.out.println(this);
		if (this.left != null) {
			this.left.porList();
		}
		if (this.right != null) {
			this.right.porList();
		}

	}
    //�������
	public void midList() {
		if (this.left != null) {
			this.left.midList();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midList();
		}
	}
   //�������
	public void endList() {
		if (this.left != null) {
			this.left.endList();
		}

		if (this.right != null) {
			this.right.endList();
		}
		System.out.println(this);
	}
   //ɾ��
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
