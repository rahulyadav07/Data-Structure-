package BinaryTree;

import java.util.Scanner;

public class checkBalancedTree {
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
	public static boolean check(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int left = height(root.left);
		int right = height(root.right);
		if((left-right)>1 ||(right-left)>1 ){
			return false;
		}
		boolean ans1=check(root.left);
		boolean ans2 =check(root.right);
		return ans1&&ans2;
	}
	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		int ans = Math.max(left, right);
		return ans+1;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		System.out.println(check(root));
	}
}
