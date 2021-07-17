package LinkedList;

import java.util.Scanner;

public class palindromeLinkedList {
	public static Node<Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		if(data==-1) {
			return null;
		}
		Node<Integer> head =null,tail=null;
		while(data!=-1) {
			Node<Integer> newnode = new Node<>(data);
			if(head==null) {
				head=newnode;
				tail  = newnode;
			}else {
				tail.next = newnode;
				tail = newnode;
			}
			data= s.nextInt();
		}
		return head;
	}

	public static Node<Integer> reverse(Node<Integer> head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> ans = reverse(head.next);
		Node<Integer> newNode = ans;
		while(newNode.next!=null) {
			newNode = newNode.next;
		}
		newNode.next = head;
		head.next=null;
		return ans;

	}
	public static boolean palindrome(Node<Integer> head) {
		if(head==null) {
			return true;
		}
		int length =0;
		Node<Integer> temp =head;
		while(temp!=null) {
			temp =temp.next;
			length++;
		}

		int mid = length/2;
		int i=0;
		temp =head;
		while(i<mid &&temp!=null) {
			temp =temp.next;
			i++;
		}
		Node<Integer> tempnexNode = temp.next;
		temp.next =null;
		Node<Integer> rever = reverse(tempnexNode);
		Node<Integer> temp2 = head;
		while(rever!=null && temp2!=null) {
			if(rever.data.equals(temp2.data)) {
				return false;
			}
			rever = rever.next;
		temp2=	temp2.next;
		}

		return true;
	}
	public static void main(String[] args) {
		Node<Integer> head = takeinput();
	Node<Integer> ans =	reverse(head);
		while(ans!=null) {
			System.out.print(ans.data + " ");
			ans=ans.next;
		}
	}
}
