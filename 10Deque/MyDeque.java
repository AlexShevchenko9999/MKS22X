public class MyDeque {

    private int front,back,size;
    private String [] que;
    
    public MyDeque(){
	size = 1;
	que = new String[size];
	front = back = -1;
    }

    //======================================

    private boolean isFull(){
	if ((back+1 >= size && front==0) || (back+1 == front)){
	    return true;
	}
	return false;
    }

    private void refill(){
	//back index stays the same
	String []temp = new String[size*2];
	for (int i = 0;i < size; i++){
	    if (front >= size){
		front = 0;
	    }
	    temp[i] = que[front];
	    front++;
	}
	front = 0;
	back = size-1;
	size *= 2;
	que = temp;
    }
    
    //======================================

    public void addFirst(String first){
	if (isFull()){
	    refill();
	    addFirst(first);
	}
	/*else {
	    if (front == -1)front=0;
	    else if (front-1<0) front = size-1;
	    else front--;
	    que[front] = first;
	    }*/
	else {
	    if (front==-1 || back==-1) front=back=0;
	    else if( front-1 < 0) front = size-1;
	    else front--;
	    que[front] = first;
	}
    }

    
    public void addLast(String last){
	if (isFull()){
	    refill();
	    addLast(last);
	}
	else{
	    if (front==-1 || back==-1) front=back=0;
	    else if (back+1 >= size) back = 0;
	    else back++;
	    que[back] = last;
	}
    }
    
    
    public String removeFirst(){
	String ans = que[front];
	que[front] = null;
	if (front+1 >= size) front = 0;
	else front ++;
	return ans;
    }
    
    
    public String removeLast(){
	String ans = que[back];
	que[back] = null;
	if (back-1 < 0) back = size-1;
	else back--;
	return ans;
    }
    
    public String getFirst(){
	return que[front];
    }
    
    public String getLast(){
	return que[back];
    }
    

    public String toString(){
	String ans = "";
	for (int i = 0; i < size; i++){
	    ans += que[i] + " ";
	}
	return ans;
    }

    public static void main(String []args){
	MyDeque D = new MyDeque();
	D.addFirst("THIS");
	D.addFirst("DA");
	D.addLast("Last");
	System.out.println(D.removeLast());
	System.out.println(D);
    }
}
