public class Queue<T> {

    private Node<T> head, tail;
    private String name;

    public Queue(String name) {
        this.name=name;
        this.head = null;
        this.tail = null;
    }

    public void push(T element) {
        Node newOne = new Node(element);
        if (tail == null) { // If queue is empty
            head = newOne;
        } else {
            tail.setNext(newOne);
        }
        tail = newOne;
    }

    public T pop() {
        if (head == null) // If queue is empty
            return null;

        Node<T> tmp = head;
        head = head.getNext();
        tmp.setNext(null);
        return (T) tmp;
    }

    public Node<T> getHead() {
        return head;
    }

    public void printQueue() {
        Node tmp = head;
        String out = name+":\n";
        while (tmp != null) {
            out += "\t" + tmp.toString() + "\n";
            tmp = tmp.getNext();
        }
        System.out.println(out);
    }
}
