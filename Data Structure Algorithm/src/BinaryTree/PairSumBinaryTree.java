package BinaryTree;

import java.util.Scanner;


public class PairSumBinaryTree {
	public static BinaryTreeNode<Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingnode = new QueueUsingLL<>();
		System.out.println("Enter the root element");
		int rootdata =  s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		pendingnode.enqueue(root);
		while(!(pendingnode.isEmpty())) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingnode.dequeue();

			}
			catch(QueueIsEmpty e) {
				return null;
			}
			System.out.println("Enter the left child of "+ front.data);
			int childleft = s.nextInt();
			if(childleft!=-1) {
				BinaryTreeNode<Integer> child =new BinaryTreeNode<Integer>(childleft);
				pendingnode.enqueue(child);
				front.left = child;
			}
			System.out.println("Enter the right child of " + front.data);
			int rightchild = s.nextInt();
			if(rightchild != -1) {
				BinaryTreeNode<Integer>child = new BinaryTreeNode<Integer>(rightchild);
				pendingnode.enqueue(child);
				front.right = child;
			}

		}
		return root;
	}
	
	public static boolean checkBST(BinaryTreeNode<Integer> root) {
		return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static boolean checkBST(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
		if(root==null) {
			return true;
		}
		if(root.data>minValue && root.data<=maxValue) {
			boolean ans1 = checkBST(root.left,minValue,root.data-1);
			boolean ans2 = checkBST(root.right,root.data+1,maxValue);
			return ans1&&ans2;
		}
		else {
			return false;
		}
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		int max = Math.max(left, right);
		return max+1;
	}
	public static int PairSum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return -1;
		}
		
		if(checkBST(root)) {
			return height(root);
		}
		else {
		int left = PairSum(root.left);
		int right = PairSum(root.right);
		return Math.max(left, right);
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		System.out.println(PairSum(root));
	}
}
