/**
 * Created by Grant on 3/25/2017.
 */
public class Node {

    private Object data;
    private Node next;
    //private Node prev = null;

    public Node(Object obj) {
        this.data = obj;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }
    public Object getData()
    {
        return this.data;
    }
}
