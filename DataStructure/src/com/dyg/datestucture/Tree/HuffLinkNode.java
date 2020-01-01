package com.dyg.datestucture.Tree;

public class HuffLinkNode   implements Comparable<HuffLinkNode>{

	private  int value;
	private  HuffLinkNode  left;
	private  HuffLinkNode  right;
	private  Byte  data;
	
	public HuffLinkNode(int value, Byte data) {
		super();
		this.value = value;
		this.data = data;
	}

	public HuffLinkNode(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public HuffLinkNode getLeft() {
		return left;
	}
	public void setLeft(HuffLinkNode left) {
		this.left = left;
	}
	public HuffLinkNode getRight() {
		return right;
	}
	public void setRight(HuffLinkNode right) {
		this.right = right;
	}
	

	public Byte getData() {
		return data;
	}

	public void setData(Byte data) {
		this.data = data;
	}

	@Override
	public int compareTo(HuffLinkNode o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
	
	public  void porList(){
		System.out.println(this);
		if(this.left!=null){
			this.left.porList();
		}
		if(this.right!=null){
			this.right.porList();
		}
		
	}

	@Override
	public String toString() {
		return "HuffLinkNode [value=" + value + ",data=" + data + "]";
	}

	
}
