
import java.util.ArrayList;
import java.util.Scanner;

public class Emulation {

    private static PCB[] fill() {
        String programs[] = {"Chrome", "Word", "Paint", "Spotify", "Photoshop", "Notepad",
                "VirtualBox", "PowerPoint", "Excel", "Settings", "PowerShell", "Premiere",
                "Photo", "Calendar", "Calculator"};
        PCB out[] = new PCB[(int) (Math.random() * (15 - 5)) + 5];
        for (int i = 0; i < out.length - 1; i++) {
            out[i] = new PCB(i);
            out[i].setPC((int) (Math.random() * (500 - 1)) + 1);
            out[i].setPriority((int) (Math.random() * 3));
            out[i].setProcessName(programs[i]);
            out[i].setProcessState("new");
        }
        return out;
    }

    private static void printStatus(ArrayList r, ArrayList w) {
        System.out.println("\nReady-Queue:");
        for (int i = 0;i < r.size(); i++)
            System.out.print((i+1)+". " + r.get(i).toString() + "\n");

        System.out.println("\nWaiting-Queue:");
        for (int i = 0;i < w.size(); i++)
            System.out.print((i+1)+". " + w.get(i).toString() + "\n");

        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        // We are on a single core and the scheduling is FCFS (First Come First Served) type

        ArrayList<PCB> r = new ArrayList<>();
        ArrayList<PCB> w = new ArrayList<>();
        PCB processes[] = fill();

        for (int i = 0; i < processes.length - 1; i++) { // I fill the queue with the PCBs of the processes
            processes[i].setProcessState("ready");
            r.add(processes[i]);
        }

        printStatus(r, w);

        Scanner sc = new Scanner(System.in);

        while (!(r.isEmpty())) { // Until the ready queue is empty
            String presentation = sc.nextLine(); // Used to run the program step by step
            PCB tmp = r.remove(0);
            System.out.println("\n>>In esecuzione sul core il processo " + tmp.getProcessName());
            long time = ((int) (Math.random() * (10 - 1) + 1)) * 1000;
            long previousMillis = System.currentTimeMillis();
            while ((System.currentTimeMillis() - previousMillis) < time && (System.currentTimeMillis() - previousMillis) < 5000) {
            } // It waits either for the process to finish or for an interrupt to occur. Each process has an execution time of 5s
            if (time >= 5000) {
                System.out.println(">>Il processo " + tmp.getProcessName() + " ha finito l'esecuzione");
            } else {
                System.out.println(">>Si e' verificato un interrupt, il processo " + tmp.getProcessName() + " e' stato tolto dal core");
                tmp.setProcessState("waiting");
                w.add(tmp);
            }
            printStatus(r, w);
            if (!(w.isEmpty())){
                PCB newOne = w.remove(0);
                newOne.setProcessState("ready");
                r.add(newOne);
            }
        }
    }
}
