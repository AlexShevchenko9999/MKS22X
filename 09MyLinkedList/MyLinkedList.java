public class MyLinkedList{

    LNode start,end;
    int size;

    public MyLinkedList(){
	start = end = null;
	size = 0;
    }

    //ADD=========================================

    public boolean add(int value){
	if (size == 0){
	    start = end = new LNode(value);
	}
	else {
	    LNode next = new LNode(value);
	    end.setNext(next);
	    end = end.getNext();
	} 
	size++;
	return true;
    }

    public void add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0) {
	    start = end = new LNode(value);
	    return;
	}
	if (index == 0){ 
	    start = new LNode(value,start);
	    return;
	}	    
	LNode Node = start;
	while (index > 1){
	    Node = Node.getNext();
	    index--;
	}
	LNode next = new LNode(value,Node.getNext());
	Node.setNext(next);
	size++;
		     
    }

    //GET========================================

    public int get(int index){
	if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
	LNode node = start;
	while (index > 0){
	    node = node.getNext();
	    index--;
	}
	return node.getValue();
    }

    //SET=======================================

    public int set(int index, int NewValue){
	if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
	LNode node = start;
	while (index > 0){
	    node = node.getNext();
	    index--;
	}
	int ans = node.getValue();
	node.setValue(NewValue);
	return ans;
    }

    //GETINDEX===================================

    public int indexOf(int value){
	LNode node = start;
	for (int i = 0;i < size; i ++){
	    if (node.getValue() == value) return i;
	    else node = node.getNext();
	}
	return -1;
    }

    //REMOVE=====================================

    public int remove(int index){
	if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
	LNode node = start;
	while (index > 1){
	    node = node.getNext();
	    index--;
	}
	int ans = node.getNext().getValue();
	node.setNext(node.getNext().getNext());
	return ans;
    }

    //TOSTRING===================================
    
    public String toString(){
	String ans = "[ ";
	LNode Node = start;
	while (Node != null){
	    ans += Node.getValue()+",";
	    Node = Node.getNext();
	}
	return ans+"]";
    }

    public int size(){
	return size;
    }

    public static void main (String [] args){
	MyLinkedList L = new MyLinkedList();
	L.add(0);
	L.add(1);
	L.add(3);
	L.add(2,2);
	L.add(1,4);
	System.out.println(L);
	System.out.println("Set: " + L.set(0,10));
	System.out.println(L);
	System.out.println("Index: " + L.indexOf(5678));
	System.out.println("Remove: "+ L.remove(2));
	System.out.println(L);
    }

    //LNODE===================================================================================================
    //LNODE===================================================================================================
    //LNODE===================================================================================================

    class LNode{
	int value;
	LNode next;

	public LNode(int value){
	    this.value = value;
	    next = null;
	}

	public LNode(int value, LNode next){
	    this.value = value;
	    this.next = next;
	}

	public void setValue(int value){
	    this.value = value; 
	}
	
	public void setNext(LNode next){
	    this.next = next;
	} 

	public int getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}
	
    }

}
