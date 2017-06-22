package algorithm.datastructure;

public class StaticLinkedList {
	private Element[] elements;
	private int head;
	private int tail;
	private int unUsed;
	private int size;
	
	public StaticLinkedList(int capacity){
		elements=new Element[capacity];
		unUsed=0;
		for(int i=0;i<capacity-1;i++){
			elements[i]=new Element();
			elements[i].setCur(i+1);
		}
		elements[capacity-1]=new Element();
		elements[capacity-1].setCur(-1);
	}
	
	public void insert(int data,int index){
		if(index==0){
			insertFirst(data);
		}else if(index==size){
			insertLast(data);
		}else{
			checkFull();
			Element preElement=get(index);
			Element unUsedElement=elements[unUsed];
			int temp=unUsed;
			unUsed=unUsedElement.getCur();
			unUsedElement.setCur(preElement.getCur());
			preElement.setCur(temp);
			unUsedElement.setData(data);
			size++;
		}
	}
	
	public void insertFirst(int data){
		checkFull();
		Element unUsedElement=elements[unUsed];
		int temp=unUsed;
		unUsed=unUsedElement.getCur();
		unUsedElement.setCur(head);
		unUsedElement.setData(data);
		head=temp;
		size++;
	}
	
	public void insertLast(int data){
		checkFull();
		Element unUsedElement=elements[unUsed];
		int temp=unUsed;
		unUsed=unUsedElement.getCur();
		elements[tail].setCur(temp);
		unUsedElement.setData(data);
		tail=temp;
		size++;
	}
	
	public void deleteFirst(){
		checkEmpty();
		Element deleteElement=elements[head];
		int temp=head;
		head=deleteElement.getCur();
		deleteElement.setCur(unUsed);
		unUsed=temp;
		size--;
	}
	
	public void deleteLast(){
		delete(size-1);
	}
	
	public void delete(int index){
		if(index==0){
			deleteFirst();
		}else{
			checkEmpty();
			Element pre=get(index-1);
			int del=pre.getCur();
			Element deleteElement=elements[del];
			pre.setCur(deleteElement.getCur());
			if(index==size-1){
				tail=index-1;
			}
			deleteElement.setCur(unUsed);
			unUsed=del;
			size--;
		}
	}
	
	public Element get(int index){
		checkEmpty();
		Element element=elements[head];
		for(int i=0;i<index;i++){
			element=elements[element.getCur()];
		}
		return element;
	}
	public void printAll(){
		Element element=elements[head];
		System.out.println(element.getData());
		for(int i=1;i<size;i++){
			element=elements[element.getCur()];
			System.out.println(element.getData());
		}
	}
	public int size(){
		return size;
	}
	private void checkFull(){
		if(size==elements.length){
			throw new IndexOutOfBoundsException("数组不够长了");
		}
	}
	
	private void checkEmpty(){
		if(size==0){
			throw new IndexOutOfBoundsException("链表为空");
		}
	}
}
