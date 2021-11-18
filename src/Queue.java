public class Queue<T> {

    private Node<T> head, tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void push(T element){
        Node newOne = new Node(element);
        if(tail == null){ // If queue is empty
            head = newOne;
        }else{
            tail.setNext(newOne);
        }
        tail=newOne;
    }

    public Node pop(){
        if(head == null) // If queue is empty
            return null;

        Node tmp = head;
        head = head.getNext();
        tmp.setNext(null);
        return tmp;
    }

    public void popByKey(T element){  //sistemero'

    }

    public void printQueue(){
        Node tmp = head;
        String out = "Queue:\n";
        while(tmp != null){
            out += "\t" + tmp.toString() + "\n";
            tmp = tmp.getNext();
        }
        System.out.println(out);
    }

}
