package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeInorder {
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

	public static ArrayList<Integer> inorder(BinaryTreeNode<Integer> root){
		if(root==null) {
			ArrayList<Integer> ans = new ArrayList<>();
			return ans;
		}
		ArrayList<Integer> ans= new ArrayList<>();
		inorder(root.left);
		ans.add(root.data);
		inorder(root.right);
		
		
		return ans;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		ArrayList<Integer> ans = inorder(root);
		for(int i =0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
