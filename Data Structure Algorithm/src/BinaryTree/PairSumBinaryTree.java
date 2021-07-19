package BinaryTree;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;


public class PairSumBinaryTree {
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

	
	public static void convertToArray(BinaryTreeNode<Integer> root, ArrayList<Integer> output){
	    if(root==null){
	        return ;
	    }
	    output.add(root.data);
	    convertToArray(root.left,output);
	    convertToArray(root.right,output);
	}
		public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
			// Write your code here
	        ArrayList<Integer> output= new ArrayList<Integer>();
	        convertToArray(root,output);
	        Collections.sort(output);
	        int i =0, j=output.size()-1;
	        while(i<j){
	            if(output.get(i)+output.get(j)== sum){
	                int countI = 1, countJ=1;
	                int k = i+1;
	                while(output.get(k)==output.get(i)){
	                    countI++;
	                    k++;
	                }
	                k=j-1;
	                while(output.get(k)==output.get(j)){
	                    countJ++;
	                    k--;
	                }
	                int count = countI*countJ;
	                while(count>0){
	                    System.out.println(output.get(i)+" " +output.get(j));
	                    count--;
	                }
	                i+= countI;
	                j-=countJ;
	                
	                    
	                }
	            else if(output.get(i)+output.get(j)>sum){
	                j--;
	            } else {
	                i++;
	            }
	        }

		}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x =s.nextInt();
		BinaryTreeNode<Integer> root = takeinput();
		nodesSumToS(root,x);

	}
}
