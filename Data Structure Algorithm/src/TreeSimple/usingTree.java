package TreeSimple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class usingTree {
	public static Tree<Integer> takeInput(Scanner s) {
		int n;
		System.out.println("Enter next node data");
		n = s.nextInt();
		Tree<Integer> root = new Tree<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		for (int i = 0; i < childCount; i++) {
			Tree<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	public static void level(Tree<Integer> root){
		Queue<Tree<Integer>> pending = new LinkedList();
		pending.add(root);
		pending.add(null);
		while(!pending.isEmpty()) {
			Tree<Integer> frontnode  = pending.poll();
			if(frontnode==null) {
				if(pending.isEmpty()) {
					break;
				} 
				System.out.println();
				pending.add(null);
			}
			else {
				
				System.out.print(frontnode.data+" ");
				for(int i=0;i<frontnode.children.size();i++) {
					pending.add(frontnode.children.get(i));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Tree<Integer> root = takeInput(s);
		level(root);
	}

}
