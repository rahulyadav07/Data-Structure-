package BinaryTree;

import java.util.Scanner;

public class PathSumRootLeaf {
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

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		rootToLeafPathsSumToK(root,k,"");
	}
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String s) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null && root.data==k) {
			System.out.println(s+root.data);
		}
		s = s+root.data+" ";
		rootToLeafPathsSumToK(root.left, k-root.data,s);
		rootToLeafPathsSumToK(root.right, k-root.data,s);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeinput();
		int n = s.nextInt();
		
		rootToLeafPathsSumToK(root, n);
	}
}
