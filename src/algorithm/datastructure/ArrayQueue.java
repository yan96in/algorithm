package algorithm.datastructure;

public class ArrayQueue {
	private final Object[] items;
	private int head=0;
	private int tail=0;
	public ArrayQueue(int capacity){
		this.items=new Object[capacity];
	}
	
	public boolean put(Object item){
		if(head==(tail+1)%items.length){
			return false;
		}
		items[tail]=item;
		tail=(tail+1)%items.length;
		return true;
	}
	
	public Object peek(){
		if(head==tail){
			return null;
		}
		return items[head];
	}
	
	public Object poll(){
		if(head==tail){
			return null;
		}
		Object item=items[head];
		items[head]=null;
		head=(head+1)%items.length;
		return item;
	}
	
	public boolean isFull(){
		return head==(tail+1)%items.length;
	}
	
	public boolean isEmpty(){
		return head==tail;
	}
	
	public int size(){
		if(tail>=head){
			return tail-head;
		}else{
			return tail+items.length-head;
		}
	}
}
