package BinaryTree;

import java.util.Scanner;

public class Linked {
	public static int findUnique(int[] arr){
	for(int i =0;i<arr.length;i++) {
		int count =0;
		for(int j=0;j<arr.length;j++) {
			if(arr[i] ==arr[j]) {
				count++;
			}
		}
		if(count==1) {
			return arr[i];
		}
	}
	return -1;
	}
	public static void main(String[] args) {
		int arr[] = {2,3,1,6,3,6,2};
		System.out.println(findUnique(arr));
		
	}
}