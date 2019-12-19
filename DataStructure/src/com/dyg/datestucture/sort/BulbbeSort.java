package com.dyg.datestucture.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//Java排序1.冒泡时间复杂度n^2 
//@author  dyg
public class BulbbeSort {

	public static void main(String[] args) {
		int arr[] = new int[80000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.random() * 8000000;
		}
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("开始时间"+simpleDateFormat.format(new  Date()));
		long starttime=System.currentTimeMillis();
		//sort(arr);
		quicksort(arr);
		long endtime=System.currentTimeMillis();
		System.out.println("结束时间"+simpleDateFormat.format(new  Date()));
		System.out.println(endtime-starttime);
	}

	// 原始冒泡排序
	public static void sort(int arr[]) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	// 优化
	public static void quicksort(int arr[]) {
		int temp = 0;
		boolean falg = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					falg = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!falg) {
				break;
			} else {
				falg = false;
			}
		}

	}
}
