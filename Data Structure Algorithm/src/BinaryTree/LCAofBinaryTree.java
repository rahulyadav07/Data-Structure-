package BinaryTree;

import java.util.Scanner;

public class LCAofBinaryTree {
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

	public static int LCA(BinaryTreeNode<Integer> root,int a,int b) {
		if(root==null) {
			return -1;
		}
		if(root.data==a || root.data==b) {
			return root.data;
		}
		int LeftLca = LCA(root.left, a, b);
		int RightLca = LCA(root.right, a, b);
		if(LeftLca==-1 && RightLca!=-1) {
			return RightLca;
		}
		if(RightLca==-1 && LeftLca!=-1 ) {
			return LeftLca;
		}
		if(RightLca==-1 && LeftLca==-1) {
			return RightLca;
		}
		else {
			return root.data;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeinput();
		int a = s.nextInt();
		int b = s.nextInt();
		int Lca =LCA(root, a, b);
		System.out.println(Lca);
	}
}
