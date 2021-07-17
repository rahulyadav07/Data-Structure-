package BinaryTree;

import java.util.Scanner;

public class RemoveLeafNode {
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


	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null){
			return;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pending= new QueueUsingLL<>();
		pending.enqueue(root);

		while(!pending.isEmpty()) {
			int size = pending.size();
			if(size==0) {
				break;
			}
			while(size>=1) {
				BinaryTreeNode<Integer> frontnode;

				try {
					frontnode = pending.dequeue();
				} catch (QueueIsEmpty e) {
					// TODO Auto-generated catch block
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

	public static BinaryTreeNode<Integer> removeleaf (BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left= removeleaf(root.left);
		root.right=removeleaf(root.right);
		return root;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root =takeinput();
		
		BinaryTreeNode<Integer>ans = removeleaf(root);
		printLevelWise(ans);
	}

}
