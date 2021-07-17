package LinkedList;

import java.util.Scanner;

public class SumofTwoLinkedList {
	public static Node<Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head= null,tail =null;


		while(data!=-1) {
			Node<Integer> newnode = new Node<Integer> (data);
			if(head==null) {
				head = newnode;
				tail  = newnode;

			}else {
				tail.next = newnode;
				tail =newnode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static int change(int n) {
		int ans =0;
		int pow = 1;
		while(n!=0) {
			int rem =n%10;
			ans =ans+rem*pow;
			pow = pow *10;
			n =n/10;
		}
		return ans;
	}
	public static int Length(Node<Integer> head) {
		int count =0;
		while(head!=null) {
			count++;
			head = head.next;
		}
		return count;
	}
	public static int linkedsum(Node<Integer> head) {
		if(head==null) {
			return 0;
		}
		int ans = 0;

		Node<Integer> temp =head;
		int length =Length(temp);
		while(head!=null) {
			int Data = head.data;
			ans = ans+(int)Math.pow(10, length-1)*Data;
			head = head.next;
			length--;
		}
		return ans;

	}
	public static void main(String[] args) {
		Node<Integer> head = takeinput();
		Node<Integer> head1 = takeinput();
		int ans = linkedsum(head)+linkedsum(head1);
		System.out.println(ans);

	}

}
