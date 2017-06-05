import java.util.*;
public class QueueFrontier implements Frontier {

    private LinkedList<Location> q;
    private int size;

    public QueueFrontier(){
	size = 0;
	q = new LinkedList<Location>();
    }

    public void add(Location s){
	q.add(s);
	size++;
    }

    public Location next(){
	return q.remove();
	size--;
    }

    public boolean isEmpty(){
	return q.peek()==null;
    }

}