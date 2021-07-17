package BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class printZigZagTree {
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

	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Stack<BinaryTreeNode<Integer>> stk = new Stack<>();
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		int level = 1;
		pending.enqueue(root);
		while(!pending.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = pending.dequeue();
				
				System.out.print(current.data+" ");
				if(level%2==0) {
					if(current.right!=null) {
						stk.push(current.right);
					}
					if(current.left!=null) {
						stk.push(current.left);
					}
				}
				else {
					if(current.left!=null) {
						stk.push(current.left);
					}
					if(current.right!=null) {
						stk.push(current.right);
					}
				}
				if(pending.isEmpty()) {
					 while(!stk.isEmpty()) {
						 pending.enqueue(stk.pop());
					 }
					 System.out.println();
					 level++;
					 
				}
				
				
			} 
			catch (QueueIsEmpty e) {
				
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		print(root);
	}

}
