package algorithm.datastructure;

public class HashTable {
	private static final int DEFAULT_INITIAL_CAPACITY=4;
	private static final float LOAD_FACTOR=0.75f;
	private Entry[] table=new Entry[DEFAULT_INITIAL_CAPACITY];
	private int size=0;
	private int use=0;
	
	public void put(int key,int value){
		int index=hash(key);
		if(table[index]==null){
			table[index]=new Entry(-1,-1,null);
		}
		
		Entry e=table[index];
		if(e.next==null){
			table[index].next=new Entry(key,value,null);
			size++;
			use++;
			//
			if(use>=table.length+LOAD_FACTOR){
				resize();
			}
		}else{
			//
			for(e=e.next;e!=null;e=e.next){
				int k=e.key;
				if(k==key){
					e.value=value;
					return;
				}
			}
			//
			Entry temp=table[index].next;
			Entry newEntry=new Entry(key,value,temp);
			table[index].next=newEntry;
			size++;
		}
	}
	
	public void remove(int key){
		int index=hash(key);
		Entry e=table[index];
		Entry pre=table[index];
		if(e!=null&&e.next!=null){
			for(e=e.next;e!=null;pre=e,e=e.next){
				int k=e.key;
				if(k==key){
					pre.next=e.next;
					size--;;
					return;
				}
			}
		}
	}
	
	public int get(int key){
		int index=hash(key);
		Entry e=table[index];
		if(e!=null&&e.next!=null){
			for(e=e.next;e!=null;e=e.next){
				int k=e.key;
				if(k==key){
					return e.value;
				}
			}
		}
		//
		return -1;
	}
	
	public int getLength(){
		return table.length;
	}
	
	private int hash(int key){
		return key%table.length;
	}
	
	private void resize(){
		int newLength=table.length*2;
		Entry[] oldTable=table;
		table=new Entry[newLength];
		use=0;
		for(int i=0;i<oldTable.length;i++){
			if(oldTable[i]!=null&&oldTable[i].next!=null){
				Entry e=oldTable[i];
				while(null!=e.next){
					Entry next=e.next;
					int index=hash(next.key);
					if(table[index]==null){
						use++;
						table[index]=new Entry(-1,-1,null);
					}
					Entry temp=table[index].next;
					Entry newEntry=new Entry(next.key,next.value,temp);
					table[index].next=newEntry;
					e=next;
				}
			}
		}
	}
}
