/**
 * Created by Grant on 3/25/2017.
 */
public class MyQueue {

     public static Node head;
     public int count = 0;

    MyQueue(){}


    public void add(Object o) {
        Node n = new Node(o);
        Node Next = head;
        if(isEmpty()) {
            head = n;
            count++;
        } else{
            while(Next.getNext() != null){
                Next = Next.getNext();
            }
            Next.setNext(n);
            count++;

        }

    }
    public boolean isEmpty(){
            if(count == 0)
                return true;
            else
                return false;

    }
    public Node peek(){
        return head;
    }
    public Node remove() {
        Node removed;
        if(isEmpty()){
            return null;
        }else{
            removed = head;
            head = head.getNext();
            count--;
            return removed;
        }
    }

    public int size(){
        return this.count;
    }

}
