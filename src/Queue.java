public class Queue<T> {

    private Node<T> head, tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void push(Node<T> element){
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

    public void popByKey(Node<T> T){  //sistemero'

    }

    public void printQueue(){
        Node tmp = head;
        String out = "";
        while(tmp != null){
            out += tmp.toString() + "\n";
            tmp = tmp.getNext();
        }
        System.out.println(out);
    }

}
