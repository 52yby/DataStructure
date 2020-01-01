package com.dyg.datestucture.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/*@auhtor dyg
 * java 实现赫夫曼树，创建，数据压缩，解压
*/
public class HuffManTree {

	public static List<HuffLinkNode> StringtoList(String str) {
		List<HuffLinkNode> lnodes = new ArrayList<HuffLinkNode>();
		Map<Byte, Integer> nodes = new HashMap<Byte, Integer>();
		byte[] bytes = str.getBytes();
		for (byte item : bytes) {
			Integer count = nodes.get(item);
			if (count == null) {
				nodes.put(item, 1);
			} else {
				nodes.put(item, count + 1);
			}
		}
		for (Entry<Byte, Integer> entrySet : nodes.entrySet()) {
			lnodes.add(new HuffLinkNode(entrySet.getValue(), entrySet.getKey()));
		}
		return lnodes;
	}

	public static HuffLinkNode ListToTree(List<HuffLinkNode> nodes) {
		//List<HuffLinkNode> lnodes = new ArrayList<HuffLinkNode>();
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			HuffLinkNode left = nodes.get(0);
			HuffLinkNode right = nodes.get(1);
			HuffLinkNode parent = new HuffLinkNode(left.getValue() + right.getValue(), null);
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	static Map<Byte, String> nodes = new HashMap<Byte, String>();
	static StringBuffer stringBuffer = new StringBuffer();
	public static Map<Byte, String> TreeTocode(HuffLinkNode node, String code,StringBuffer s) {
		StringBuffer stringBuffer1 = new StringBuffer(s);
		stringBuffer1.append(code);
		if (node != null) {
			if (node.getData() == null) {
				TreeTocode(node.getLeft(), "0",stringBuffer1);
				TreeTocode(node.getRight(), "1",stringBuffer1);

			} else {
				nodes.put(node.getData(), stringBuffer1.toString());

			}
		}
		return nodes;
	}

	public static Byte[] Maptocode(byte[] bytes, Map<Byte, String> nodes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (Byte item : bytes) {
			stringBuffer.append(nodes.get(item));
		}
		int len = stringBuffer.length() % 8 == 0 ? stringBuffer.length() / 8 : stringBuffer.length() / 8 + 1;
		Byte[] bcode = new Byte[len];
		int index = 0;
		for (int i = 0; i < stringBuffer.length(); i+=8) {
			String str = new String();
			if (i + 8 > stringBuffer.length()) {
				str = stringBuffer.substring(i);
			} else {
				str = stringBuffer.substring(i, i + 8);
			}
			bcode[index] = (byte) Integer.parseInt(str, 2);
			index=index+1;
		}
		return bcode;
	}

	public static Byte[] zipdata(String str, byte[] bs) {
		List<HuffLinkNode> lnodes = StringtoList(str);
		HuffLinkNode node = ListToTree(lnodes);
		Map<Byte, String> map = TreeTocode(node, "",new StringBuffer());
		return  Maptocode(str.getBytes(), map);
	}

	public static HuffLinkNode CreateHuffTree(int arr[]) {

		List<HuffLinkNode> nodes = new ArrayList<HuffLinkNode>();
		for (int item : arr) {
			HuffLinkNode node = new HuffLinkNode(item);
			nodes.add(node);

		}

		// System.out.println(nodes);
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			HuffLinkNode left = nodes.get(0);
			HuffLinkNode right = nodes.get(1);
			HuffLinkNode parent = new HuffLinkNode(left.getValue() + right.getValue());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);

		}
		return nodes.get(0);

	}

	public static void porList(HuffLinkNode node) {
		if (node != null) {
			node.porList();
		} else {
			System.out.println("空树");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		/*
		 * HuffLinkNode node = CreateHuffTree(arr); porList(node);*/
		 
		String str="i like like like java do you like a java";
		//System.out.println(StringtoList(str));
		HuffLinkNode node=ListToTree(StringtoList(str));
		//porList(node);
	/*	TreeTocode(node, "", stringBuffer);
		System.out.println(nodes);*/
	//	String str="i like like like java do you like a java";
		System.out.println(Arrays.toString(zipdata(str, str.getBytes())));
		
	}
}
