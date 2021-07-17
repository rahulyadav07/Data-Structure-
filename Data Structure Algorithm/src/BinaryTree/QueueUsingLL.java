package BinaryTree;

public class QueueUsingLL<T>{
	private Node<T> front;
	private Node<T> rear;
	private int size;
	public QueueUsingLL(){
		front =null;
		rear = null;
		size =0;
	}
	int size() {
		return size;
	}
	boolean isEmpty() {
		return size==0;
	}
	T front() throws QueueIsEmpty {
		if(size==0) {
			throw new QueueIsEmpty();
		}
		else {
			return front.data;
		}
		
	}
	void enqueue(T data) {
		Node<T> newnode = new Node<>(data);
		if(rear==null) {
			front = newnode;
			rear = newnode;
		}
		else {
			rear.next = newnode;
			rear = newnode;
		}
		size++;
		
	}
	T dequeue() throws QueueIsEmpty{
		if(size==0) {
			throw new QueueIsEmpty();
		}
		T Temp = front.data;
		front = front.next;
		if(size==1) {
			rear= null;
		}
		size--;
		return Temp;
	}
	

}
