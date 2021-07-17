package BinarySearchTree;

import java.util.ArrayList;
import java.util.Scanner;

public class findpathtobst {
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

	public static ArrayList<Integer> getPath(BinarySearchNode<Integer> root,int x){
		if(root==null) {
			return null;
		}
		if(root.data==x) {
			ArrayList<Integer> output =  new ArrayList<>();
			output.add(root.data);
			return output;
		}
		if(root.data>x) {
			ArrayList<Integer> leftoutput = getPath(root.left, x);
			if(leftoutput!=null) {
				leftoutput.add(root.data);
				return leftoutput;
			}
		}

		if(root.data<x) {
			ArrayList<Integer> rightoutput = getPath(root.right, x);
			if(rightoutput!=null) {
				rightoutput.add(root.data);
				return rightoutput;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearchNode<Integer> root =  takeinput();
		int x = s.nextInt();
		ArrayList<Integer> path =getPath(root, x);
		if(path==null) {
			System.out.println("Path is not found");
		}else {
			for(int i:path) {
				System.out.print( i+" ");
			}	
		}

	}

}
