package BinarySearchTree;

import java.util.Scanner;


public class CreateBinarySearchFromSorted {
	public static BinarySearchNode helper(int arr[],int start,int end){
		if(start>end) {
			return null;
		}
		int mid = start+(end-start)/2;
		BinarySearchNode root = new BinarySearchNode(arr[mid]);
		root.left = helper(arr, start, mid-1);
		root.right =helper(arr, mid+1, end);
		return root;
	}
	public static BinarySearchNode create(int arr[]){
		return helper(arr,0,arr.length-1);
	}
	public static void print(BinarySearchNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = new int[s.nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.nextInt();
		}
		BinarySearchNode ans = create(arr);
		print(ans);
	}
}
