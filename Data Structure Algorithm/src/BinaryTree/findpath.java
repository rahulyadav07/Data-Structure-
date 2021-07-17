package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class findpath {
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
	public static ArrayList<Integer>FindPathOfBT(BinaryTreeNode<Integer> root,int x){
		if(root==null) {
			return null;
		}

		if(root.data==x) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftouput = FindPathOfBT(root.left, x);
		if(leftouput!=null) {
			leftouput.add(root.data);
			return leftouput;
		}
		ArrayList<Integer>rightoutput = FindPathOfBT(root.right, x);
		if(rightoutput!=null) {
			rightoutput.add(root.data);
			return rightoutput;
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeinput();
		int x = s.nextInt();
		ArrayList<Integer> ans =  FindPathOfBT(root, x);
		for(int i :ans) {
			System.out.print(i+" ");
		}


	}
}
