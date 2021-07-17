package BinaryTree;

import java.util.Scanner;

public class Diameter{
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
		QueueUsingLL<BinaryTreeNode<Integer>> pendingnode = new QueueUsingLL<>();
		pendingnode.enqueue(root);
		while(!pendingnode.isEmpty()) {
			BinaryTreeNode<Integer>frontnode =null;

			try {
				frontnode = pendingnode.dequeue();
			} catch (QueueIsEmpty e) {

				e.printStackTrace();
			}
			System.out.print(frontnode.data+":");
			if(frontnode.left!=null) {
				pendingnode.enqueue(frontnode.left);
				System.out.print("Left:"+ frontnode.left.data+"  ");
			}
			else {
				System.out.print("left:"+"-1" );

			}
			if(frontnode.right!=null) {
				pendingnode.enqueue(frontnode.right);
				System.out.print("right:"+frontnode.right.data+"   ");
			}
			else {
				System.out.print("Right:"+"-1");
				System.out.println();
			}
		}		
	}
	
	public static int height (BinaryTreeNode<Integer>root) {
		if(root==null) {
			return 0;
		}
		int left = height(root.right);
		int right = height(root.left);
		int max = Math.max(left, right);
		return max+1;
	}
	public static int Diameter (BinaryTreeNode<Integer>root) {
		if(root==null) {
			return 0;
		}
		
		int left = Diameter(root.left);
		int right = Diameter(root.right);
		int option = height(root.left)+height(root.right);
		int ans = Math.max(option,Math.max(right, left));
		return ans;
		
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		int ans = Diameter(root);
		System.out.println(ans);
	}
}
