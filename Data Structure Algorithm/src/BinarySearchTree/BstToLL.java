package BinarySearchTree;
import java.io.BufferedReader;
import java.util.Scanner;


class pair{
	Node<Integer> head;
	Node<Integer> tail;
}
public class BstToLL {
	
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
	
	
	public static Node<Integer> constructLinkedList(BinarySearchNode<Integer> root) {
        return helperconstructList(root).head;
	}
    public static pair helperconstructList(BinarySearchNode<Integer> root){
        if(root==null){
            pair ans = new pair();
            return ans;
        }
        Node<Integer> newNode = new Node<Integer>(root.data);
        pair pairleft = helperconstructList(root.left);
        pair pairright  = helperconstructList(root.right);
        pair ans = new pair();
        if(pairleft.tail!=null){
            pairleft.tail.next = newNode;
        }
         newNode.next = pairright.head;
        if(pairleft.head !=null){
            ans.head = pairleft.head;
        }
        else{
            ans.head = newNode;
        }
        if(pairright.tail!=null){
            ans.tail=pairright.tail;
        }
        else{
            ans.tail = newNode;
        }
        return ans;
    }
    public static void print(BinarySearchNode root) {
			if(root==null) {
				return;
			}
			System.out.print(root.data+" ");
			print(root.left);
			print(root.right);
		}
	public static void main(String[] args) {
		BinarySearchNode<Integer> root = takeInput();
		
		Node<Integer> head = constructLinkedList(root);
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}
