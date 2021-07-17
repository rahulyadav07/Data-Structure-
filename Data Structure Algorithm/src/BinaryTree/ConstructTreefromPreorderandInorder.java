package BinaryTree;import java.util.Scanner;


public class ConstructTreefromPreorderandInorder {
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
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		pending.enqueue(root);
		while(!pending.isEmpty()) {
			int size = pending.size();
			if(size==0) {
				break;
			}
			while(size>=1) {
				BinaryTreeNode<Integer> frontnode=null;
				try {
					frontnode = pending.dequeue();
				} catch (Exception e) {
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
	
	public static BinaryTreeNode<Integer> constructTree(int inOrder[],int preOrder[]){
		if(inOrder.length!=preOrder.length) {
			return null;
		}
		return helper (0, 0, inOrder.length - 1,  preOrder, inOrder);
	}
	
	
  
    private static BinaryTreeNode<Integer> helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        //base condition
        if (preStart > preorder.length - 1 || inStart > inEnd) 
            return null;
        
        //get the root node with curr preorder element
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[preStart]);
        
        //get inIndex; finding preorder's element's index in inorder
        int inIndex = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.data) {
                inIndex = i; 
            }
        }
        //(next, left of inIndex is the end for left subtree)
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //(prestart + length of left subtree + 1)
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeinput();
		print(root);
	}
}