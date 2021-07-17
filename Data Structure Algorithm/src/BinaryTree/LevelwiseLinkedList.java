package BinaryTree;

import java.util.Scanner;


import java.util.*;
public class LevelwiseLinkedList {


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


	public static ArrayList<Node<Integer>> linkedlist(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  pending  = new QueueUsingLL<>();
		ArrayList<Node<Integer>> list = new ArrayList<>();
		pending.enqueue(root);
		int level = 1;
		int count =0;
		Node<Integer> head =null;
		Node<Integer> tail =null;
		while(!pending.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = pending.dequeue();
			} catch (QueueIsEmpty e) {
				
				return null;
			}
			Node<Integer> newnode = new Node<>(current.data);
			if(head==null) {
				head = newnode;
				tail = newnode;
			}
			else {
				tail.next = newnode;
				tail = newnode;
			}
			if(current.left!=null) {
				pending.enqueue(current.left);
				count++;
			}
			if(current.right!=null) {
				pending.enqueue(current.right);
				count++;
			}
			level--;
			if(level==0) {
				list.add(head);
				head = null;
				tail = null;
				level=count;
				count=0;
			}
		}
		return list;
	}
	
	public static void print(Node<Integer> head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		ArrayList<Node<Integer>> ans = linkedlist(root);
		for(Node<Integer>head :ans) {
			print(head);
		}
	}
}
