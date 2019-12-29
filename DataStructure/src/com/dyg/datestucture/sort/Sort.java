package com.dyg.datestucture.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*Java≈≈–Ú    √∞≈›£¨—°‘Ò£¨≤Â»Î£¨œ£∂˚£¨øÏÀŸ£¨πÈ≤¢£¨ª˘ ˝,∂—≈≈–Ú
@author  dyg*/
public class Sort {

	public static void main(String[] args) {

		/*
		 * int arr[] = { 12, 22, 41, 54, 5, -7 }; insertsort(arr);
		 * System.out.println(Arrays.toString(arr));
		 */
	//	int arr[] = { 8, 9, 1, -71, 752, 453, 5, 114, -688, 0 };
		/* shellsort2(arr); */
		//int[] temp = new int[arr.length];
		int arr[] ={4,6,8,5,9};
		TreeSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	// ‘≠ º√∞≈›≈≈–Ú
	public static void bulbbesort(int arr[]) {
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

	// ”≈ªØ√∞≈›≈≈–Ú
	public static void quickbulbbesort(int arr[]) {
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

	// —°‘Ò≈≈–Ú
	public static int[] selectsort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			int minvalue = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
					minvalue = arr[j];
				}
			}
			if (min != i) {
				arr[min] = arr[i];
				arr[i] = minvalue;
			}
		}
		return arr;
	}

	// ≤Â»Î≈≈–Ú
	public static void insertsort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int insertvalue = arr[i];
			int insertindex = i - 1;
			while (insertindex >= 0 && insertvalue < arr[insertindex]) {
				arr[insertindex + 1] = arr[insertindex];
				insertindex--;
			}
			arr[insertindex + 1] = insertvalue;
		}
	}

	// œ£∂˚≈≈–ÚªªŒª∑®
	public static void shellsort1(int arr[]) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2)
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						int temp = arr[j + gap];
						arr[j + gap] = arr[j];
						arr[j] = temp;
					}
				}
			}

	}

	// œ£∂˚≈≈–Ú“∆Œª∑®
	public static void shellsort2(int arr[]) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2)
			for (int i = gap; i < arr.length; i++) {
				int indexvalue = arr[i];
				int index = i - gap;
				if (indexvalue < arr[index]) {
					while (index >= 0 && indexvalue < arr[index]) {
						arr[index + gap] = arr[index];
						index -= gap;
					}
					arr[index + gap] = indexvalue;
				}
			}
	}

	// øÏÀŸ≈≈–Ú
	public static void quicksort(int arr[], int left, int right) {
		int l = left;
		int r = right;
		int midvalue = arr[(left + right) / 2];
		int temp = 0;
		while (l < r) {
			while (arr[l] < midvalue) {
				l++;
			}
			while (arr[r] > midvalue) {
				r--;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if (l >= r) {
				break;
			}
			if (arr[l] == midvalue) {
				r--;
			}
			if (arr[r] == midvalue) {
				l++;
			}
		}

		if (l == r) {
			r--;
			l++;
		}
		if (left < r) {
			quicksort(arr, left, r);
		}
		if (right > l) {
			quicksort(arr, l, right);
		}

	}

	// πÈ≤¢≈≈–Ú
	public static void mergegsort(int arr[], int left, int right, int temp[]) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergegsort(arr, left, mid, temp);
			mergegsort(arr, mid + 1, right, temp);
			mergeg(arr, left, mid, right, temp);
		}

	}

	public static void mergeg(int arr[], int left, int mid, int right, int temp[]) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		t = 0;
		int templeft = left;
		while (templeft <= right) {
			arr[templeft++] = temp[t++];
		}

	}

	// ª˘ ˝≈≈–Ú
	public static void BukcetSort(int arr[]) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		int maxlength = (max + "").length();
		for (int i = 0, n = 1; i < maxlength; i++, n *= 10) {
			int[][] bukcet = new int[19][arr.length];
			int[] bukcetelement = new int[19];
			for (int k = 0; k < arr.length; k++) {
				int value = (arr[k] / n) % 10;
				if (value >= 0) {
					value += 9;
				} else {
					value = Math.abs(value) - 1;
				}
				bukcet[value][bukcetelement[value]] = arr[k];
				bukcetelement[value]++;
			}
			int index = 0;
			for (int j = 0; j < bukcetelement.length; j++) {
				if (bukcetelement[j] != 0) {
					for (int l = 0; l < bukcetelement[j]; l++) {
						arr[index++] = bukcet[j][l];
						bukcetelement[l] = 0;
					}
				}
			}
		}

	}
	
	public static  void  TreeSort(int arr[]){
		for(int i=arr.length/2-1;i>=0;i--){
			justTree(arr, i, arr.length);
		}
		//System.out.println(Arrays.toString(arr));
		
		for(int  j=arr.length-1;j>=0;j--){
			int temp=arr[0];
			arr[0]=arr[j];
			arr[j]=temp;
			justTree(arr, 0,j);
		}
	}
	public static void  justTree(int arr[],int i,int length){
		int  temp=arr[i];
		for(int k=i*2+1;k<length;k=k*2+1){
			if(k+1<length&&arr[k]<arr[k+1]){
				k++;
			}
			if(arr[k]>temp){
				arr[i]=arr[k];
				i=k;
			}else{break;}
		
		}
		arr[i]=temp;
		
	}

}
