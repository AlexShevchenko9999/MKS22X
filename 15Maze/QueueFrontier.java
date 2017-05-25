import java.util.*;
public class QueueFrontier implements Frontier {

    private Queue<Location> q = new Queue<Location>();

    public void add(Location s){
	q.add(s);
    }

    public Location next(){
	return q.peek();
    }

}