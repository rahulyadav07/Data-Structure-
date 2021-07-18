package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PrintVerticalyTree {
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


	 public static void printVerticalOrderUtil(BinaryTreeNode<Integer> root, int vertical_level, HashMap<Integer, ArrayList<Integer>> m) {
	        // Base case
	        if(root == null) {
	            return;

	        }

	        // storing current node in the hashmap which is passed by reference 

	        ArrayList<Integer> temp = m.get(vertical_level);
	        if(temp == null) {
	            temp = new ArrayList<Integer>();
	        }

	        temp.add(root.data);
	        m.put(vertical_level, temp);
	        //Recursive call in left subtree with vertical level-1 
	        printVerticalOrderUtil(root.left, vertical_level-1, m);

	        // Recursive call in right subtree with vertical_level+1 
	        printVerticalOrderUtil(root.right, vertical_level+1, m);

	    }

	    public static void printBinaryTreeVerticalOrder (BinaryTreeNode<Integer> root) {

	        //creating a hashmap which stores vertical order level number and a vector containing nodes at that 
	        HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
	        int vertical_level = 0; //vertical level number 
	        printVerticalOrderUtil(root, vertical_level, m);

	        // Traverse the hashmap and print nodes at every vertical level

	        Set<Integer> s = m.keySet(); 
	        for (int i: s) {
	            ArrayList<Integer> a = m.get(i); 
	            for(int j : a) {
	                System.out.print(j + " ");

	            } 
	            System.out.println();
	        }
	    }
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		printBinaryTreeVerticalOrder(root);
	}
}
