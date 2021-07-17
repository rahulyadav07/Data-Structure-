package BinaryTree;

import java.util.*;

public class Inorderwithoutrecursion {
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
	
	 public static void inOrder(BinaryTreeNode<Integer> root) {
	        if(root==null){
	            return;
	        }
	        Stack<BinaryTreeNode<Integer>> stk = new Stack<>();
	        BinaryTreeNode<Integer>  frontnode = root;
	      
	        while(frontnode!= null || stk.size()>0){

	            while(frontnode !=null){
	                stk.push(frontnode);
	                frontnode = frontnode.left;
	            }
	            frontnode = stk.pop();
	            System.out.print(frontnode.data+" ");
	                frontnode = frontnode.right;

	        }
	    }

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		inOrder(root);
	}
}
