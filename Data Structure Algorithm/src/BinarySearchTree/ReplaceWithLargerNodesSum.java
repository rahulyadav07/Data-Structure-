package BinarySearchTree;
import java.util.Scanner;
public class ReplaceWithLargerNodesSum {
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
	
	public static void print(BinarySearchNode<Integer> root) {
		if(root==null){
			return;
		}
		QueueUsingLL<BinarySearchNode<Integer>> pending= new QueueUsingLL<>();
		pending.enqueue(root);
		
		while(!pending.isEmpty()) {
			int size = pending.size();
			if(size==0) {
				break;
			}
			while(size>=1) {
				BinarySearchNode<Integer> frontnode;
				try {
					frontnode = pending.dequeue();
				} catch (QueueIsEmpty e) {
					return;
				}
				System.out.print(frontnode.data+" ");
				if(frontnode.left!=null) {
					pending.enqueue(frontnode.left);
				}
				if(frontnode.right!=null) {
					pending.enqueue(frontnode.right);
				}
				size--;
			}
			System.out.println();
		}
		
	}
	public static int Relpacewithlargernode(BinarySearchNode<Integer> root,int sum) {
		if(root==null) {
			return sum;
		}
		int right = Relpacewithlargernode(root.right,sum);
		root.data = root.data+right;
		int left = Relpacewithlargernode(root.left,root.data);
		return left;
	}
	public static  void replace(BinarySearchNode<Integer> root) {
		 Relpacewithlargernode(root,0);
	}
	public static void main(String[] args) {
		BinarySearchNode<Integer> root = takeInput();
		replace(root);
		print(root);
	}
}
