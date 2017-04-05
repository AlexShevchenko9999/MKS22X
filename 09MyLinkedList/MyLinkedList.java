public class MyLinkedList{

    LNode start,end;
    int size;

    public MyLinkedList(){
	start = end = null;
	size = 0;
    }

    //ADD=========================================

    public boolean add(int value){
	add(size,value);
	return true;
    }

    public void add(int index, int value){
	if (index < 0 || index > size){
	    System.out.println("" + index + " " + size);
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0) {
	    start = end = new LNode(value);
	    size++;
	    return;
	}
	if (index == 0){
	    LNode temp = new LNode(value,start);
	    start.setPrevious(temp);
	    start = temp;
	    size++;
	    return;
	}	
	if (index == size){
	    LNode te = new LNode(value,null,end);
	    end.setNext(te);
	    end = te;
	    size++;
	    return;
	}
	LNode Node = getNode(index);
	LNode next = new LNode(value,Node,Node.getPrevious());
	next.getPrevious().setNext(next);
	next.getNext().setPrevious(next);
	size++;
		     
    }

    //GET========================================

    public int get(int index){
	return getNode(index).getValue();
    }

    //SET=======================================

    public int set(int index, int NewValue){
	LNode node = getNode(index);
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

    //Nth NODE==================================

    private LNode getNode(int index){
	if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
	LNode node = start;
	if (index < size/2){   
	    while (index > 0){
		node = node.getNext();
		index--;
	    }
	}
	else {
	    node = end;
	    int i = size-1;
	    while (i>index ){
		node = node.getPrevious();
		i--;
	    }
	}
	return node;
    }

    //REMOVE=====================================

    public int remove(int index){
	if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
	if (index == 0){
	    int ans = start.getValue();
	    start = start.getNext();
	    start.setPrevious(null);
	    size--;
	    return ans;
	}
	if (index == size-1){
	    int ans = end.getValue();
	    end = end.getPrevious();
	    end.setNext(null);
	    size--;
	    return ans;
	}
	return remove(getNode(index));
    }

    private int remove(LNode node){
	node.getPrevious().setNext(node.getNext());
	node.getNext().setPrevious(node.getPrevious());
	size--;
	return node.getValue();
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

    //SIZE=======================================

    public int size(){
	return size;
    }

    public static void main (String [] args){
	MyLinkedList L = new MyLinkedList();
	//L.add(0);
	L.add(0,2345);
	System.out.println(L);
	//System.out.println(L.remove(0));
	L.add(1);
	L.add(3);
	System.out.println(L);
	L.add(2,2);
	System.out.println(L);
	L.add(2,4);
	System.out.println(L);
	System.out.println("Set: " + L.set(4,10));
	System.out.println(L);
	System.out.println("Index: " + L.indexOf(5678));
	System.out.println(L);
	System.out.println("Remove: "+ L.remove(4));
	System.out.println(L);
	L.add(8);
	L.add(13);
	L.add(28);
	System.out.println(L);
	System.out.println(L.get(5));
	System.out.println(L.indexOf(13));
	System.out.println(L.remove(4));
	System.out.println(L);
    }

    //LNODE===================================================================================================
    //LNODE===================================================================================================
    //LNODE===================================================================================================

    class LNode{
	int value;
	LNode next,previous;

	public LNode(int value){
	    this.value = value;
	    next = null;
	    previous = null;
	}

	public LNode(int value, LNode next){
	    this.value = value;
	    this.next = next;
	}

	public LNode(int value,LNode next, LNode prev){
	    this.value = value;
	    this.next = next;
	    previous = prev;
	}

	public void setValue(int value){
	    this.value = value; 
	}
	
	public void setNext(LNode next){
	    this.next = next;
	} 

	public void setPrevious(LNode prev){
	    previous = prev;
	}

	public int getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}

	public LNode getPrevious(){
	    return previous;
	}
	
    }

}
