public class MyLinkedList{

    LNode start,end;
    int size;

    public MyLinkedList(){
	start = end = null;
	size = 0;
    }

    public void add(int value){
	if (size == 0) start = end = new LNode(value);
	else {
	    LNode next = new LNode(value);
	    end.setNext(next);
	    end = end.getNext();
	} 
	//start = new LNode(value,start);
	size++;
    }

    public void add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0) start = end = new LNode(value);
	LNode Node = start;
	while (index > 1){
	    Node = Node.getNext();
	    index--;
	}
	LNode next = new LNode(value,Node.getNext());
	Node.setNext(next);
	size++;
		     
    }

    public String toString(){
	String ans = " ";
	LNode Node = start;
	while (Node != null){
	    ans += Node.getValue()+",";
	    Node = Node.getNext();
	}
	return ans;
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
	L.add(4,4);
	System.out.println(L);
    }

    

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
