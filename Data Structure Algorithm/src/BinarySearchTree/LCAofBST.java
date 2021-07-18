package BinarySearchTree;

import java.util.Scanner;

public class LCAofBST {

	public static BinarySearchNode<Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinarySearchNode> pendingnode = new QueueUsingLL<>();
		//	System.out.println("Enter the root element");
		int rootdata =  s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinarySearchNode root = new BinarySearchNode(rootdata);
		pendingnode.enqueue(root);
		while(!(pendingnode.isEmpty())) {
			BinarySearchNode front;
			try {
				front = pendingnode.dequeue();

			}
			catch(QueueIsEmpty e) {
				return null;
			}
			//		System.out.println("Enter the left child of "+ front.data);
			int childleft = s.nextInt();
			if(childleft!=-1) {
				BinarySearchNode child =new BinarySearchNode(childleft);
				pendingnode.enqueue(child);
				front.left = child;
			}
			//		System.out.println("Enter the right child of " + front.data);
			int rightchild = s.nextInt();
			if(rightchild != -1) {
				BinarySearchNode child = new BinarySearchNode(rightchild);
				pendingnode.enqueue(child);
				front.right = child;
			}

		}
		return root;
	}

	public static BinarySearchNode<Integer> Lca(BinarySearchNode<Integer> root,int a,int b){
		if(root==null || a==root.data || b==root.data){
            return root;
        }
		if(root.data>a && root.data>b) {
			return Lca(root.left, a, b);
		}
		if(root.data<a && root.data<b) {
			return Lca(root.right, a, b);
		}
		BinarySearchNode<Integer> left = Lca(root.left, a, b);
		BinarySearchNode<Integer> right = Lca(root.right, a, b);
		if(left==null && right==null) {
			return null;
		}
		if(left!=null && right==null) {
			return left;
		}
		if(left==null && right!=null) {
			return right;
		}
		else {
			return root;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearchNode<Integer> root = takeinput();
		int a = s.nextInt();
		int b =  s.nextInt();
		BinarySearchNode<Integer> ans = Lca(root,a,b);
		if(ans==null) {
			System.out.println("we not find Lca of that number");
		}else {
			System.out.println(root.data);
		}
	}
}
