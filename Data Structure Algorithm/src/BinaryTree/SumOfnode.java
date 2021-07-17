package BinaryTree;

import java.util.*;
public class SumOfnode {
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
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		pending.enqueue(root);
		while(!pending.isEmpty()) {
			int size = pending.size();
			if(size==0) {
				break;
			}
			while(size>=1) {
				BinaryTreeNode<Integer> frontnode=null;
				try {
					frontnode = pending.dequeue();
				} catch (Exception e) {
					return;
				}
				System.out.print(frontnode.data+" ");
				if(frontnode.left!=null) {
					pending.enqueue(frontnode.left);
				}
				if(frontnode.right!=null) {
					pending.enqueue(frontnode.right);
				}
				size--;
			}
			System.out.println();

		}
	}
public static int sum(BinaryTreeNode<Integer> root) {
	if(root==null) {
		return 0;
	}
	int left = sum(root.left);
	int right= sum(root.right);
	int ans = left+right;
	return ans+root.data;
	
}
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeinput();
		 int ans=sum(root);
		 System.out.println(ans);
	}
}
