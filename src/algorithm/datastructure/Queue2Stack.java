package algorithm.datastructure;

public class Queue2Stack {
	private ArrayQueue queue1;
	private ArrayQueue queue2;
	private int maxLength;
	
	public Queue2Stack(int capacity){
		maxLength=capacity;
		queue1=new ArrayQueue(capacity);
		queue2=new ArrayQueue(capacity);
	}
	
	public boolean push(int item){
		if(size()==maxLength){
			return false;
		}
		if(queue2.isEmpty()){
			queue1.put(item);
		}else{
			queue2.put(item);
		}
		return true;
	}
	
	public Object pop(){
		if(size()==0){
			throw new IndexOutOfBoundsException("栈内已空");
		}else{
			if(queue2.isEmpty()){
				while(queue1.size()>1){
					queue2.put(queue1.poll());
				}
				return queue1.poll();
			}else{
				while(queue2.size()>1){
					queue1.put(queue2.poll());
				}
				return queue2.poll();
			}		
		}
	}
	
	public int size(){
		return queue1.size()+queue2.size();
	}
}
