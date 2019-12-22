package com.dyg.datestucture.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*java 查找算法  :线性查找，二分查找，插值查找,斐波那契查找
 * @author  dyg
 * */
public class Select {
	public static void main(String[] args) {
		int arr[] = { 11, 15, 18, 20, 30, 41 };
		System.out.println(fibselect(arr, 18));
	}

	// 线性查找
	public static List<Integer> sxselect(int arr[], int findvalue) {
		int rvalue = 0;
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == findvalue) {
				rvalue = i;
				l.add(rvalue);
				/* break; */
			} /*
				 * else { rvalue = -1; }
				 */
		}
		return l;

	}

	// 二分查找--必须有序
	public static List<Integer> twoselect(int arr[], int findvalue, int left, int right) {
		List<Integer> l = new ArrayList<Integer>();
		int mid = (left + right) / 2;
		int midv = arr[mid];
		if (left > right) {
			return new ArrayList<Integer>();
		}
		if (findvalue > midv) {
			return twoselect(arr, findvalue, mid + 1, right);
		} else if (findvalue < midv) {
			return twoselect(arr, findvalue, left, mid - 1);
		} else {
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findvalue) {
					break;
				}
				l.add(temp);
				temp--;
			}
			l.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > right || arr[temp] != findvalue) {
					break;
				}
				l.add(temp);
				temp++;
			}
			return l;
		}
	}

	// 插值查找--必须有序
	public static List<Integer> insertselect(int arr[], int findvalue, int left, int right) {
		List<Integer> l = new ArrayList<Integer>();
		int mid = left + (right - left) * (findvalue - arr[left]) / (arr[right] - arr[left]);
		int midv = arr[mid];
		if (left > right) {
			return new ArrayList<>();
		}
		if (findvalue > midv) {
			return insertselect(arr, findvalue, mid + 1, right);
		} else if (findvalue < midv) {
			return insertselect(arr, findvalue, left, mid - 1);
		} else {
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findvalue) {
					break;
				}
				l.add(temp);
				temp--;
			}
			l.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > right || arr[temp] != findvalue) {
					break;
				}
				l.add(temp);
				temp++;
			}
			return l;
		}
	}

	public static int[] fib() {
		int temp[] = new int[20];
		temp[0] = 1;
		temp[1] = 1;
		for (int i = 2; i < temp.length - 1; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp;
	}
    //斐波那契查找
	public static int fibselect(int arr[], int findvalue) {
		int left = 0;
		int right = arr.length - 1;
		int k = 0;
		int mid = 0;
		int f[] = fib();
		while (right>f[k]-1) {
			k++;
		}

		int temp[] = Arrays.copyOf(arr, f[k]);
		for (int i = right + 1; i < temp.length; i++) {
			temp[i] = arr[right];
		}
		while (left <=right) {
			mid=left+f[k-1]-1;
             if(findvalue<temp[mid]){
            	 right=mid-1;
            	 k--;
             }else  if(findvalue>temp[mid]){
            	 left=mid+1;
            	 k-=2;
             }else{
            	 if(mid<=right){
            		 return  mid;
            	 }
            	 else{
            		 return  right;
            	 }
             }
		}
		return  -1;
	}

}
