public class Emulation {

    private static PCB[] fill(){
        String programs[] = {"Chrome", "Word", "Paint", "Spotify", "Photoshop", "Notepad",
                "VirtualBox", "PowerPoint", "Excel", "Settings", "PowerShell", "Premiere",
                "Photo", "Calendar", "Calculator"};
        PCB out[] = new PCB[(int) (Math.random() * (20 - 5)) + 5];
        for(int i = 0; i < out.length; i++){
            out[i] = new PCB(i);
            out[i].setPC((int) (Math.random() * (500 - 1)) + 1);
            out[i].setPriority((int) (Math.random() * 3));
            out[i].setProcessName(programs[i]);
            out[i].setProcessState("new");
        }
        return out;
    }

    private static void printStatus(){
        
    }

    public static void main(String[] args) {

        // We are on a single core and the scheduling is FCFS (First Come First Served) type

        Queue<PCB> r = new Queue<>("Ready-Queue");
        Queue<PCB> w = new Queue<>("Waiting-Queue");
        PCB processes[] = fill();

        for(int i = 0; i < processes.length; i++){ // I fill the queue with the PCBs of the processes
            processes[i].setProcessState("ready");
            r.push(processes[i]);
        }

        while(r.getHead() != null){ // Until the ready queue is empty
            PCB tmp = r.pop();
            System.out.println(">>In esecuzione sul core il processo " + tmp.getProcessName());
            long time = ((int) (Math.random() * (10 - 1) + 1)) * 1000;
            long previousMillis = System.currentTimeMillis();
            while((System.currentTimeMillis() - previousMillis) < time && (System.currentTimeMillis() - previousMillis) < 5000){
            } // It waits either for the process to finish or for an interrupt to occur. Each process has an execution time of 5s
            if(time >= 5){
                System.out.println(">>Il processo " + tmp.getProcessName() + " ha finito l'esecuzione");
            }else{
                System.out.println(">>Si e' verificato un interrupt, il processo " + tmp.getProcessName() + "e' stato tolto dal core");
                w.push(tmp);
            }
            printStatus();
            r.push(w.pop());
        }
    }
}
