public class Test {

    public static void main(String[] args) {
        PCB a = new PCB(1);
        PCB b = new PCB(2);
        PCB c = new PCB(3);
        PCB d = new PCB(4);
        PCB e = new PCB(5);
        Queue<PCB> queue= new Queue<>("queue");
        queue.push(a);
        queue.push(b);
        queue.push(c);
        queue.push(d);
        queue.push(e);
        queue.printQueue();
        System.out.println("E' stato rimosso --> " + queue.pop().toString()+"\n");
        queue.printQueue();
    }
}
