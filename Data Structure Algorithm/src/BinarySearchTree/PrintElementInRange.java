package BinarySearchTree;

import java.util.Scanner;

public class PrintElementInRange {
	public static BinarySearchNode takeinput(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinarySearchNode> pendingnode = new QueueUsingLL<>();
		System.out.println("Enter the root element");
		int rootdata =  s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinarySearchNode root = new BinarySearchNode(rootdata);
		pendingnode.enqueue(root);
		while(!(pendingnode.isEmpty())) {
			BinarySearchNode front;
			try {
				front = pendingnode.dequeue();
			}
			
			catch(QueueIsEmpty e) {
				return null;
			}
			System.out.println("Enter the left child of "+ front.data);
			int childleft = s.nextInt();
			if(childleft!=-1) {
				BinarySearchNode child =new BinarySearchNode(childleft);
				pendingnode.enqueue(child);
				front.left = child;
			}
			System.out.println("Enter the right child of " + front.data);
			int rightchild = s.nextInt();
			if(rightchild != -1) {
				BinarySearchNode child = new BinarySearchNode(rightchild);
				pendingnode.enqueue(child);
				front.right = child;
			}

		}
		return root;
	}
	
	private static void printRange(BinarySearchNode<Integer> root,int a,int b) {
		if(root==null) {
			return;
		}
		if(root.data>=a && root.data<=b) {
			printRange(root.left, a, b);
			System.out.print(root.data+" ");
			printRange(root.right, a, b);
		}
		if(root.data<a) {
			printRange(root.right, a, b);
		}
		if(root.data>b) {
			printRange(root.left, a, b);
		}

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearchNode root = takeinput();
		int a = s.nextInt();
		int b = s.nextInt();
		printRange(root,a,b);
		
	}



}
