package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LevelWiseLinkedList {

	public static BinarySearchNode<Integer> takeInput()  {
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinarySearchNode<Integer>> pendingNodes = new QueueUsingLL<BinarySearchNode<Integer>>();
		BinarySearchNode<Integer> root = new BinarySearchNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinarySearchNode<Integer> currentNode;

			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueIsEmpty e) {
				return null;
			}

			int leftChildData =  s.nextInt();
			if (leftChildData != -1) {
				BinarySearchNode<Integer> leftChild = new BinarySearchNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if (rightChildData != -1) {
				BinarySearchNode<Integer> rightChild = new BinarySearchNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static ArrayList<Node<Integer>> LevelWise(BinarySearchNode<Integer> root){
		QueueUsingLL<BinarySearchNode<Integer>> q = new QueueUsingLL<>();
		ArrayList<Node<Integer>> output = new  ArrayList<>();
		q.enqueue(root);
		int count = 0;
		int level =1;
		Node<Integer> head = null;
		Node<Integer> tail = null;
		while(!q.isEmpty()) {
			BinarySearchNode<Integer> current;
			try {
				current = q.dequeue();
			}
			catch (Exception e) {
				return null;
			}
			Node<Integer> newNode = new Node<Integer>(current.data);
			if(head==null) {
				head  = newNode;
				tail = newNode;
				
			}
			else {
				tail.next=newNode;
				tail =newNode;
			}
			if(current.left!=null) {
				q.enqueue(current.left);
				count++;
			}
			if(current.right!=null) {
				q.enqueue(current.right);
				count++;
			}
			level--;
			if(level==0) {
				output.add(head);
				head=null;
				tail=null;
				level=count;
				count=0;
			}
			
		}
		return output;
	}
	public static void print(Node<Integer> head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		BinarySearchNode<Integer> root = takeInput();
		ArrayList<Node<Integer>> Lists = LevelWise(root);
		
		for(Node<Integer> i:Lists) {
			print(i);
		}
	}
}
