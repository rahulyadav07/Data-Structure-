package BinarySearchTree;

import java.util.Scanner;



public class LargestBST {
	public static BinarySearchNode takeinput(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinarySearchNode> pendingnode = new QueueUsingLL<>();
//		System.out.println("Enter the root element");
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
//			System.out.println("Enter the left child of "+ front.data);
			int childleft = s.nextInt();
			if(childleft!=-1) {
				BinarySearchNode child =new BinarySearchNode(childleft);
				pendingnode.enqueue(child);
				front.left = child;
			}
//			System.out.println("Enter the right child of " + front.data);
			int rightchild = s.nextInt();
			if(rightchild != -1) {
				BinarySearchNode child = new BinarySearchNode(rightchild);
				pendingnode.enqueue(child);
				front.right = child;
			}

		}
		return root;
	}
	
	public static boolean isBST(BinarySearchNode<Integer> root) {
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
    public static boolean isBST(BinarySearchNode<Integer> root,int min,int max){
        if(root==null){
            return true;
        }
        if(root.data>min && root.data<=max){
            boolean ans1 = isBST(root.left,min,root.data-1);
            boolean ans2 = isBST(root.right,root.data,max);
            return ans1 &ans2;
        }
        else{
            return false;
        }
    }

    public static int height (BinarySearchNode<Integer> root) {
       if(root==null) {
    	   return 0;
       }
       int  left= height(root.left);
       int right = height(root.right);
       int max  =Math.max(left, right)+1;
       return max;
	}
    
    public static int LargestBst(BinarySearchNode<Integer> root) {
    	if(root==null) {
    		return 0;
    	}
//    	 LargestBst(root.left);
//    	LargestBst(root.right);
    	if(isBST(root)) {
    		 return height(root);
    	}else {
    		int ans1 = LargestBst(root.left);
    		int ans2 = LargestBst(root.right);
    		int max = Math.max(ans1, ans2);
    		return max;
    	}
    }
	public static void main(String[] args) {
		BinarySearchNode<Integer> root = takeinput();
		int ans  = LargestBst(root);
		System.out.println(ans);
	}

}
