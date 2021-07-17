package BinarySearchTree;

import java.util.Scanner;

public class SearchNodeInBst {
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

	public static boolean searchNode(BinarySearchNode<Integer> root,int x){
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return true;	
		}
		if(root.data>x) {
			 return searchNode(root.left, x);
		}
		else {
			return searchNode(root.right, x);
		}
	}
	
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	BinarySearchNode root = takeinput();
	int x = s.nextInt();
	System.out.println(searchNode(root, x));
	}


}